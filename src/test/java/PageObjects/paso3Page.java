package PageObjects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class paso3Page extends util {
    public paso3Page() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Passenger')]")
    private WebElement lblTitulo;
    @FindBy(id = "txt_nombre[suite][cab1][1]")
    private WebElement txtFirstName;
    @FindBy(id = "txt_apellido[suite][cab1][1]")
    private WebElement txtLastName;
    @FindBy(id = "txt_fecha_nacimiento[suite][cab1][1]") private WebElement calendario;
    @FindBy(xpath = "//select[@class=\"ui-datepicker-month\"]") private WebElement cboMes;
    @FindBy(xpath = "//select[@class=\"ui-datepicker-year\"]") private WebElement cboAnio;
    @FindBy(id = "sel_nacion[suite][cab1][1]") private WebElement cboNacionalidad;
    @FindBy(id = "sel_tpdoc[suite][cab1][1]") private WebElement cboTipodocumento;
    @FindBy(id = "txt_nroid[suite][cab1][1]") private WebElement txtNrodocumento;
    @FindBy(id = "sel_sexo[suite][cab1][1]") private WebElement cboSexo;
    @FindBy(id = "txt_telefono[suite][cab1][1]") private WebElement txtTelefono;
    @FindBy(id = "txt_mail[suite][cab1][1]") private  WebElement txtEmail;
    @FindBy(id = "txt_mail_conf[suite][cab1][1]") private WebElement txtConfirmarEmail;
    @FindBy(id = "cab-1")
    private WebElement cabina1;
    @FindBy(id = "cab-2")
    private WebElement cabina2;
    @FindBy(id = "cab-3")
    private WebElement cabina3;
    @FindBy(id = "cab-4")
    private WebElement cabina4;
    @FindBy(id = "cab-5")
    private WebElement cabina5;
    @FindBy(id = "cab-6")
    private WebElement cabina6;
    @FindBy(id = "cab-7")
    private WebElement cabina7;
    @FindBy(id = "cab-8")
    private WebElement cabina8;
    @FindBy(id = "cab-9")
    private WebElement cabina9;
    @FindBy(id = "btnContinuarPas") private WebElement btnContinuar;

    public boolean validarPaso3() {
        wait.until(ExpectedConditions.visibilityOf(lblTitulo));
        return lblTitulo.isEnabled();
    }

    public void escribirFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        txtFirstName.sendKeys(firstName);
    }

    public void escribirLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOf(txtLastName));
        txtLastName.sendKeys(lastName);
    }

    public void seleccionaFechaNacimiento(String dia, String mes, String anio) {
        /*wait.until(ExpectedConditions.elementToBeClickable(calendario));
        calendario.click();*/
        wait.until(ExpectedConditions.visibilityOf(cboMes));
        new Select(cboMes).selectByVisibleText(mes);
        wait.until(ExpectedConditions.visibilityOf(cboAnio));
        new Select(cboAnio).selectByVisibleText(anio);

        try {
            List<WebElement> Tdia = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
            for (WebElement e : Tdia) {
                if (e.getText().trim().equals(dia)) {
                    e.click();
                    break;
                }
            }
        } catch (Exception d){
            WebElement DefaultDay = driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']"));
            if (DefaultDay.getText().equals(dia)){
                DefaultDay.click();
            }
        }
    }

    public void seleccionarNacionalidad(String country){
        wait.until(ExpectedConditions.visibilityOf(cboNacionalidad));
        new Select(cboNacionalidad).selectByVisibleText(country);
    }

    public void seleccionarTipoDocumento(String tipoDocumento){
        wait.until(ExpectedConditions.elementToBeClickable(cboTipodocumento));
        new Select(cboTipodocumento).selectByVisibleText(tipoDocumento);
    }

    public void escribirNroDocumento(String nroDocumento){
        wait.until(ExpectedConditions.visibilityOf(txtNrodocumento));
        txtNrodocumento.sendKeys(nroDocumento);
    }

    public void seleccionarSexo(String sexo){
        wait.until(ExpectedConditions.visibilityOf(cboSexo));
        new Select(cboSexo).selectByVisibleText(sexo);
    }

    public void escribirTelefono(String telefono){
        wait.until(ExpectedConditions.visibilityOf(txtTelefono));
        txtTelefono.sendKeys(telefono);
    }

    public void escribirEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(email);
    }

    public void escribirEmailconfirmar(String confirmarEmail){
        wait.until(ExpectedConditions.visibilityOf(txtConfirmarEmail));
        txtConfirmarEmail.sendKeys(confirmarEmail);
    }

    public void escribirDatosPasajero(String cabina, String cantidad) throws IOException {
        /*
    @FindBy(xpath = "//select[@class=\"ui-datepicker-month\"]") private WebElement cboMes;
    @FindBy(xpath = "//select[@class=\"ui-datepicker-year\"]") private WebElement cboAnio;
         */
            int cant = Integer.parseInt(cantidad);
            for (int i = 1; i <= cant; i++) {
                WebElement btnCabine = driver.findElement(By.id("cab-" + i));
                WebElement btnPasajero = driver.findElement(By.id("itm" + i + "-1"));
                WebElement txtFirstName = driver.findElement(By.id("txt_nombre[" + cabina + "][cab" + i + "][1]"));
                WebElement txtLastName = driver.findElement(By.id("txt_apellido[" + cabina + "][cab" + i + "][1]"));
                WebElement calendario = driver.findElement(By.id("txt_fecha_nacimiento[" + cabina + "][cab" + i + "][1]"));
                WebElement cboNacionalidad = driver.findElement(By.id("sel_nacion[" + cabina + "][cab" + i + "][1]"));
                WebElement cboTipoDocumento = driver.findElement(By.id("sel_tpdoc[" + cabina + "][cab" + i + "][1]"));
                WebElement txtDocumento = driver.findElement(By.id("txt_nroid[" + cabina + "][cab" + i + "][1]"));
                WebElement cboSexo = driver.findElement(By.id("sel_sexo[" + cabina + "][cab" + i + "][1]"));
                WebElement txtTelefono = driver.findElement(By.id("txt_telefono[" + cabina + "][cab" + i + "][1]"));
                WebElement txtEmail = driver.findElement(By.id("txt_mail[" + cabina + "][cab" + i + "][1]"));
                WebElement txtConfirmarEmail = driver.findElement(By.id("txt_mail_conf[" + cabina + "][cab" + i + "][1]"));

                File file = new File("src/test/resources/Data/Datos.xlsx");
                FileInputStream inputStream = new FileInputStream(file);

                XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

                XSSFSheet newSheet = newWorkbook.getSheet(cantidad);
                int rowcount = newSheet.getLastRowNum();
                for (int a=i;i<=rowcount;a++) {
                    scrollDown();
                    if (i > 1) {
                        wait.until(ExpectedConditions.elementToBeClickable(btnCabine));
                        btnCabine.click();
                        wait.until(ExpectedConditions.elementToBeClickable(btnPasajero));
                        btnPasajero.click();
                    }
                    String nameE = newSheet.getRow(a).getCell(0).getStringCellValue();
                    String apePatE = newSheet.getRow(a).getCell(1).getStringCellValue();
                    String dayE = newSheet.getRow(a).getCell(2).getStringCellValue();
                    String monthE = newSheet.getRow(a).getCell(3).getStringCellValue();
                    String yearE = newSheet.getRow(a).getCell(4).getStringCellValue();
                    String CountryE = newSheet.getRow(a).getCell(5).getStringCellValue();
                    String typeDocE = newSheet.getRow(a).getCell(6).getStringCellValue();
                    String numDocE = newSheet.getRow(a).getCell(7).getStringCellValue();
                    String sexE = newSheet.getRow(a).getCell(8).getStringCellValue();
                    String phoneE = newSheet.getRow(a).getCell(9).getStringCellValue();
                    String emailE = newSheet.getRow(a).getCell(10).getStringCellValue();
                    String reMailE = newSheet.getRow(a).getCell(11).getStringCellValue();

                wait.until(ExpectedConditions.visibilityOf(txtFirstName));
                txtFirstName.sendKeys(nameE);
                txtLastName.sendKeys(apePatE);
                calendario.click();
                seleccionaFechaNacimiento(dayE, monthE, yearE);
                new Select(cboNacionalidad).selectByVisibleText(CountryE);
                new Select(cboTipoDocumento).selectByVisibleText(typeDocE);
                wait.until(ExpectedConditions.visibilityOf(txtDocumento));
                txtDocumento.sendKeys(numDocE);
                new Select(cboSexo).selectByVisibleText(sexE);
                txtTelefono.sendKeys(phoneE);
                txtEmail.sendKeys(emailE);
                txtConfirmarEmail.sendKeys(reMailE);
                break;
            }
           continue;
        }
    }

    public void clickbotonContinuar(){
        wait.until(ExpectedConditions.elementToBeClickable(btnContinuar));
        btnContinuar.click();
    }
}
