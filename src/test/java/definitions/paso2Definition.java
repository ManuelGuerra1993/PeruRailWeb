package definitions;

import PageObjects.paso2Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.IOException;

import static support.DocumentWord.evidencia2;

public class paso2Definition {
    paso2Page paso2;

    public paso2Definition() {
        paso2 = new paso2Page();
    }

    @Then("se muestra del paso_2 Elige tu cabina")
    public void seMuestraElPaso_2EligeTuCabina(){
        Assert.assertTrue("El paso 2 de elegir la cabina no estaba activo",paso2.validarPaso2());
    }

    @When("selecciono la cabina {string} y la cantidad de pasajeros {string}")
    public void seleccionoLaCabinaYLaCantidadDePasajeros(String cabina, String cantidad) throws IOException, InvalidFormatException {
        paso2.seleccionarCabinas(cabina,cantidad);
        evidencia2("selecciono la cabina y la cantidad de pasajeros");
    }

    @When("El usuario selecciona la cabina {string}, pasajeros {string} y valida el monto a pagar")
    public void seleccionoLaCabinaYLaCantidad(String cabina, String cantidad) throws IOException, InvalidFormatException {
        paso2.seleccionarCabinas(cabina,cantidad);
        evidencia2("selecciono la cabina y la cantidad de pasajeros");
        paso2.clickCerrarPopUp();
        paso2.clickbotonSummary();
        Assert.assertTrue("No son iguales :(", paso2.compararMontoPagar());
        paso2.clickContinue();
    }

    @And("hago click en el botón continue en el paso 2")
    public void hagoClickEnElBotónContinue() throws IOException, InvalidFormatException {
        evidencia2("hago click en el botón continue en el paso 2");
        paso2.clickContinue();
    }

    @And("hago clic en el boton X del popUp")
    public void cierroPopUpSiDeValidaciónDeCapacidadMaxima() {
        paso2.clickCerrarPopUp();
    }

    @And("hago clic en Purchase Summary en la pantalla 2")
    public void hagoClicEnPurchaseSummaryEnLaPantalla() {
        paso2.clickbotonSummary();
    }

    @And("valido que los montos sean iguales en el paso 2")
    public void validoQueLosMontosSeanIgualesEnElPaso() {
        Assert.assertTrue("No son iguales :(", paso2.compararMontoPagar());
    }

    @And("se muestra que la cabina no esta disponible")
    public void seMuestraQueLaCabinaNoEstaDisponible() {
        Assert.assertTrue("La cabina si esta disponible", paso2.validarDisponiblidadCabina());
    }

    @And("selecciono la cantidad de mayores {string} de la cabina")
    public void seleccionoLaCantidadDeMayoresDeLaCabina(String cantidad) {
        paso2.seleccionarCantidadAdulto(cantidad);
    }

    @And("selecciona la cantidad de menores {string} de la cabina")
    public void seleccionaLaCantidadDeMenoresDeLaCabina(String cantidad) {
        paso2.seleccionarCantidadNinio(cantidad);
    }

    @Then("se muestra popUp validando que no se tiene mayores seleccionados")
    public void seMuestraPopUpValidandoQueNoSeTieneMayoresSeleccionados() {
        paso2.validarTextoValidaMinimo1Mayor();
    }
}
