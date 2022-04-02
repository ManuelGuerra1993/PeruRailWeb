package definitions;

import PageObjects.paso4Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.IOException;

import static support.DocumentWord.evidencia2;

public class paso4Definition {
    paso4Page paso4;

    public paso4Definition() {
        paso4 = new paso4Page();
    }

    @Then("se muestra del paso_4 Confirmacion y Pago")
    public void seMuestraElPaso_4ConfirmacionyPago() throws IOException, InvalidFormatException, InterruptedException {
        Assert.assertTrue("El paso 2 de elegir la cabina no estaba activo",paso4.validarPaso4());
        Thread.sleep(1000);
        evidencia2("se muestra del paso_4 Confirmacion y Pago");
    }


    @When("selecciono el metodo de pago {string} en el paso 4")
    public void seleccionoElMetodoDePagoEnElPaso(String metodo) {
        paso4.seleccionarMetodoPago(metodo);
    }

    @And("hago click en el botón Ingresar Tarjeta del paso 4")
    public void hagoClickEnElBotónIngresarTarjetaDelPaso() {
        paso4.clickBotonIngresarTarjeta();
    }

    @And("ingreso los datos de mi tarjeta {string} {string} {string} {string} {string} {string}")
    public void ingresoLosDatosDeMiTarjeta(String metodo, String nroTarjeta, String mesV, String anioV, String codSeguridad, String nombreTarjeta) {
        paso4.ingresarDatosDeTarjeta(metodo, nroTarjeta, mesV, anioV, codSeguridad, nombreTarjeta);
    }

    @And("hago click en el botón continue en el paso 4")
    public void hagoClickEnElBotónContinueEnElPaso() {
    }
}
