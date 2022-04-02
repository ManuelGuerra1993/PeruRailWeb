package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class paso4Page extends util {

    public paso4Page() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'CONFIRMATION')]") private WebElement lblTitulo;
    @FindBy(id = "visa") private WebElement rbVisa;
    @FindBy(id = "mastercard") private WebElement rbMastercard;
    @FindBy(id = "dinners") private WebElement rbDinners;
    @FindBy(id = "paypal") private WebElement rbPaypal;
    @FindBy(id = "safetypay") private WebElement rbSafety;
    @FindBy(id = "safetypay_peru") private WebElement rbTransferencia;
    @FindBy(id = "chk_tercon") private WebElement rbTerminosCondiciones;
    @FindBy(id = "ingresar_tarjeta") private WebElement btnIngresarTarjeta;
    @FindBy(id = "F1009") private WebElement txtNroTarjeta;
    @FindBy(id = "F1010_MM") private WebElement cboMesTarjeta;
    @FindBy(id = "F1010_YY") private WebElement cboAnioTarjeta;
    @FindBy(id = "F1136") private WebElement txtCodigoSeguridad;
    @FindBy(id = "F1142") private WebElement txtNombreTarjeta;
    @FindBy(id = "btnSubmit") private WebElement btnContinue;
    @FindBy(id = "btnCancel") private WebElement btnCancelar;

    public boolean validarPaso4() {
        wait.until(ExpectedConditions.visibilityOf(lblTitulo));
        return lblTitulo.isEnabled();
    }

    public void seleccionarMetodoPago(String metodo){
        switch (metodo){
            case "visa":
                wait.until(ExpectedConditions.elementToBeClickable(rbVisa));
                rbVisa.click();
                break;
            case "mastercard":
                wait.until(ExpectedConditions.elementToBeClickable(rbMastercard));
                rbMastercard.click();
                break;
            case "dinners":
                wait.until(ExpectedConditions.elementToBeClickable(rbDinners));
                rbDinners.click();
                break;
            case "paypal":
                wait.until(ExpectedConditions.elementToBeClickable(rbPaypal));
                rbPaypal.click();
                break;
            case "safetypay":
                wait.until(ExpectedConditions.elementToBeClickable(rbSafety));
                rbSafety.click();
                break;
            case "transferencia":
                wait.until(ExpectedConditions.elementToBeClickable(rbTransferencia));
                rbTransferencia.click();
                break;
            default:
                System.out.println("El metodo de pago buscado no se encuentra en la lista");
                break;
        }
        wait.until(ExpectedConditions.elementToBeClickable(rbTerminosCondiciones));
        rbTerminosCondiciones.click();
    }

    public void clickBotonIngresarTarjeta(){
        wait.until(ExpectedConditions.elementToBeClickable(btnIngresarTarjeta));
        btnIngresarTarjeta.click();
    }

    public void ingresarDatosDeTarjeta(String metodo, String nroTarjeta, String mesV, String anioV, String codSeguridad, String nomTarjeta){
        if (metodo.equals("visa") || metodo.equals("mastercard") || metodo.equals("dinners")) {
            driver.switchTo().frame(driver.findElement(By.id("global")));
            wait.until(ExpectedConditions.visibilityOf(txtNroTarjeta));
            txtNroTarjeta.sendKeys(nroTarjeta);
            new Select(cboMesTarjeta).selectByVisibleText(mesV);
            new Select(cboAnioTarjeta).selectByVisibleText(anioV);
            txtCodigoSeguridad.sendKeys(codSeguridad);
            txtNombreTarjeta.sendKeys(nomTarjeta);
        } else if (metodo.equals("safetypay") || metodo.equals("transferencia")){
            System.out.println("Codigo pendiente para trasnfetrencia y safetypay");
        } else {
            System.out.println("Codigo pendiente para Paypal");
        }
    }
}
