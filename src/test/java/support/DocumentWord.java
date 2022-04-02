package support;

import definitions.hook;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DocumentWord extends hook {

    public static void evidencia2(String paso) throws IOException, InvalidFormatException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");

        String path = "target\\evidencias\\";
        String nombre = formato.format(fecha) + "_screenshot.jpg";
        String ruta = path + nombre;

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(ruta));


        XWPFDocument document;
        //XWPFDocument document = new XWPFDocument();

        if (!Files.exists(Paths.get("target\\Word\\Documento_Evidencia.docx"))) {
            document = new XWPFDocument();
        } else {
            document = new XWPFDocument(Files.newInputStream(Paths.get("target\\Word\\Documento_Evidencia.docx")));
        }
        XWPFParagraph paragraph = document.createParagraph();

        XWPFRun run = paragraph.createRun();
        run.setText("EVIDENCIA DE PRUEBA AUTOMATIZADA");
        run.setFontFamily("Arial Black");
        run.setUnderline(UnderlinePatterns.DOUBLE);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run.addBreak();
        if (Files.exists(Paths.get("target\\Word\\Documento_Evidencia.docx"))){
            run.addCarriageReturn();
            run.addCarriageReturn();
        }

        run.setText("Test name: "+ paso);
        run.addCarriageReturn();
        run.addCarriageReturn();

        File image = new File(String.valueOf(file));
        FileInputStream imageData = new FileInputStream(image);

        int imageType = XWPFDocument.PICTURE_TYPE_JPEG;
        String imageFileName = image.getName();

        int imagewidth = 400;
        int imageHeight = 250;

        FileOutputStream fos = new FileOutputStream(new File("target\\Word\\Documento_Evidencia.docx"));

        run.addPicture(imageData, imageType, imageFileName, Units.toEMU(imagewidth),Units.toEMU(imageHeight));
        document.write(fos);

        fos.close();
    }


}
