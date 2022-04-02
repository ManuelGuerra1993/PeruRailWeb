package definitions;

import PageObjects.paso3Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;

import static support.DocumentWord.evidencia2;

public class paso3Definition {
    paso3Page paso3;

    public paso3Definition() {
        paso3 = new paso3Page();
    }

    @Then("se muestra del paso_3 Datos del Pasajero")
    public void seMuestraElPaso_3DatosDelPasajero(){
        Assert.assertTrue("El paso 2 de elegir la cabina no estaba activo",paso3.validarPaso3());
    }


    @And("ingreso los datos del pasajero {string} {string}")
    public void ingresoLosDatosDelPasajero(String cabina, String cantidad) throws IOException {
        /*paso3.escribirFirstName(firstname);
        paso3.escribirLastName(lastname);
        paso3.seleccionaFechaNacimiento(dia, mes, anio);
        paso3.seleccionarNacionalidad(country);
        paso3.seleccionarTipoDocumento(type);
        paso3.escribirNroDocumento(number);
        paso3.seleccionarSexo(Sex);
        paso3.escribirTelefono(phone);
        paso3.escribirEmail(email);
        paso3.escribirEmailconfirmar(reEmail);*/

        paso3.escribirDatosPasajero(cabina, cantidad);
    }


    @And("hago click en el botón continue en el paso 3")
    public void hagoClickEnElBotónContinueEnElPaso() throws IOException, InvalidFormatException {
        evidencia2("hago click en el botón continue en el paso 3");
        paso3.clickbotonContinuar();
    }
}
