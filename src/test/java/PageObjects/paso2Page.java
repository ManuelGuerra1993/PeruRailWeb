package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

import java.rmi.server.ExportException;

public class paso2Page extends util {
    public static String subTotal;

    public paso2Page() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(text(),'Choose your cabin')]") private WebElement lblTitulo;
    @FindBy(xpath = "//div[@class=\"box-cabina\"][1]//select[@class=\"selectRooms selectMe\"]") private WebElement cboCabinasSuite;
    @FindBy(xpath = "//div[@class=\"box-cabina\"][2]//select[@class=\"selectRooms selectMe\"]") private WebElement cboCabinasTwin;
    @FindBy(xpath = "//div[@class=\"box-cabina\"][3]//select[@class=\"selectRooms selectMe\"]") private WebElement cboCabinasBunk;
    @FindBy(id = "continuar_bae") private WebElement btnContinue;
    @FindBy(xpath = "//div[@class=\"sb-content\"]") private WebElement popUpCantidadMaxima;
    @FindBy(id = "sb-nav-close") private WebElement btnXpopUp;
    @FindBy(xpath = "//*[@id=\"compra\"]/a") private WebElement btnPurchaseSummary;
    @FindBy(xpath = "//*[@id=\"tarifaSUBTOTAL\"]/div[2]/span[1]/span") private WebElement lblSubtotalcabina;
    @FindBy(xpath = "//*[@id=\"priceUSDrc\"]") private WebElement lblTotalSummary;
    @FindBy(xpath = "(//*[contains(text(),'No cabins')])[1]") private WebElement btnCabinaNoDisponibleSuite;
    @FindBy(xpath = "(//*[contains(text(),'No cabins')])[2]") private WebElement btnCabinaNoDisponibleTwin;
    @FindBy(xpath = "(//*[contains(text(),'No cabins')])[3]") private WebElement btnCabinaNoDisponibleBank;
    @FindBy(xpath = "//div[contains(text(),'The Belmond')]") private WebElement lblMensajeNocabins;
    @FindBy(name = "selectRooms[suite][cabinas][cab1][adult]") private WebElement cboAdulto;
    @FindBy(name = "selectRooms[suite][cabinas][cab1][nin]") private WebElement cboNinio;
    @FindBy(xpath = "//*[contains(text(),'You must select')]") private WebElement lblPopUpValidaMayores;


    public void Scroll(){
        scrollDown();
    }

    public boolean validarPaso2(){
        wait.until(ExpectedConditions.visibilityOf(lblTitulo));
        return lblTitulo.isEnabled();
    }

    public void seleccionarCabinas(String cabina, String cantidad){
        switch (cabina){
            case "suite":
                scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(cboCabinasSuite));
                new Select(cboCabinasSuite).selectByValue(cantidad);
                break;
            case "twin":
                scrollDown();
                scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(cboCabinasTwin));
                new Select(cboCabinasTwin).selectByValue(cantidad);
                break;
            case "bunk":
                scrollDown();
                scrollDown();
                scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(cboCabinasBunk));
                new Select(cboCabinasBunk).selectByValue(cantidad);
                break;
            default:
                System.out.println("El tipo de cabina no se encontro");
        }
    }

    public void clickContinue(){
        wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
        btnContinue.click();
    }

    public void clickCerrarPopUp(){
        if (popupVisible() == "1"){
            btnXpopUp.click();
        }
    }

    public String popupVisible(){
        String valor ="";
        try {
            popUpCantidadMaxima.isEnabled();
            valor = "1";
        } catch (Exception e){
            valor = "2";
        }
        return  valor;
    }

    public void clickbotonSummary(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPurchaseSummary));
        btnPurchaseSummary.click();
    }

    public void obtenerSubtotalDolares(){
        wait.until(ExpectedConditions.visibilityOf(lblSubtotalcabina));
        subTotal = lblSubtotalcabina.getText().trim();
    }

    public boolean compararMontoPagar(){
        String val = lblTotalSummary.getText().trim();
        String val2 = lblSubtotalcabina.getText().trim();
        System.out.println(val +" "+val2);
        wait.until(ExpectedConditions.visibilityOf(lblTotalSummary));
        if (lblTotalSummary.getText().trim().equals(lblSubtotalcabina.getText().trim())){
            return true;
        } else {
            return false;
        }
    }

    public boolean validarDisponiblidadCabina(){
        wait.until(ExpectedConditions.visibilityOf(lblMensajeNocabins));
        return lblMensajeNocabins.isEnabled();
    }

    public void seleccionarCantidadAdulto(String cantidad){
        wait.until(ExpectedConditions.elementToBeClickable(cboAdulto));
        new Select(cboAdulto).selectByValue(cantidad);
    }

    public void seleccionarCantidadNinio(String cantidad){
        wait.until(ExpectedConditions.elementToBeClickable(cboNinio));
        new Select(cboNinio).selectByValue(cantidad);
    }

    public boolean validarTextoValidaMinimo1Mayor(){
        wait.until(ExpectedConditions.visibilityOf(lblPopUpValidaMayores));
        return lblPopUpValidaMayores.isEnabled();
    }
}
