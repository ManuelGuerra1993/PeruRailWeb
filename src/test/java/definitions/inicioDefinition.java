package definitions;

import PageObjects.inicioPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.IOException;

import static support.DocumentWord.evidencia2;
import static support.Screenshot.evidencia;

public class inicioDefinition{
    inicioPage inicio;

    public inicioDefinition() {
        inicio = new inicioPage();
    }

    @Given("El usuario ingresa a la web de PeruRail")
    public void abroElNavegadorWeb() {
        hook.driver.get("https://www.perurail.com/");
    }

    @When("visualizo la pantalla de Radios")
    public void visualizoLaPantallaDeRadios() {
    }

    @Then("cierro la aplicacion")
    public void cierroLaAplicacion() throws InterruptedException {
        Thread.sleep(6000);
    }

    @Given("selecciono el tipo de viaje {string}")
    public void seleccionoElTipoDeViaje(String opcion) {
        inicio.seleccionarTipoViaje(opcion);
    }

    @Given("El usuario selecciona el tipo de viaje y la ruta {string} {string} {string} {string} {string} {string} {string}")
    public void completoLosDatosDelPaso1(String opcion, String destino, String ruta, String tren, String dia, String mes, String anio) {
        inicio.seleccionarTipoViaje(opcion);
        inicio.seleccionarDestino(destino);
        inicio.seleccionarRuta(ruta);
        inicio.seleccionarTren(tren);
        inicio.seleccionarFecha(dia,mes,anio);
        inicio.clickEnBuscarTicketTren();
    }

    @When("selecciono el destino {string}")
    public void seleccionoElDestino(String destino) {
        inicio.seleccionarDestino(destino);
    }

    @And("selecciono la ruta {string}")
    public void seleccionoLaRuta(String ruta) {
        inicio.seleccionarRuta(ruta);
    }

    @And("selecciono el tren {string}")
    public void seleccionoElTren(String tren) {
        inicio.seleccionarTren(tren);
    }


    @And("selecciono la fecha de salida {string} {string} {string}")
    public void seleccionoLaFechaDeSalida(String dia, String mes, String anio) {
        inicio.seleccionarFecha(dia,mes,anio);
    }

    @And("hago click en el botón Find Train Ticket")
    public void hagoClickEnElBotónFindTrainTicket() throws IOException, InvalidFormatException {
        evidencia2("hago click en el botón Find Train Ticket");
        inicio.clickEnBuscarTicketTren();
    }
}
