package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class inicioPage extends util {

    public inicioPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[contains(text(),'Round trip')]") private WebElement rbRoundTrip;
    @FindBy(xpath = "//label[contains(text(),'One Way')]") private WebElement rbOneWay;
    @FindBy(id = "destinoSelect") private WebElement cboDestino;
    @FindBy(id = "rutaSelect") private WebElement cboRuta;
    @FindBy(id = "cbTrenSelect") private WebElement cboTren;
    @FindBy(id = "salida") private WebElement dtpFechaSalida;
    @FindBy(xpath = "//div[@class=\"ui-datepicker-title\"]") private WebElement calendario;
    @FindBy(xpath = "//span[contains(text(),'Next')]") private WebElement NextCalendaro;
    @FindBy(id = "btn_search") private WebElement btnFindTrainticket;



    public void seleccionarTipoViaje(String opcion){
        switch (opcion){
            case "Round Trip":
                wait.until(ExpectedConditions.elementToBeClickable(rbRoundTrip));
                rbRoundTrip.click();
                break;
            case "One Way":
                wait.until(ExpectedConditions.elementToBeClickable(rbOneWay));
                rbOneWay.click();
                break;
            default:
                System.out.println("No se encontró la opción solicitada para el tipo de viaje");
        }
    }

    public void seleccionarDestino(String destino){
        wait.until(ExpectedConditions.visibilityOf(cboDestino));
        new Select(cboDestino).selectByVisibleText(destino);
    }

    public void seleccionarRuta(String ruta){
        wait.until(ExpectedConditions.visibilityOf(cboRuta));
        new Select(cboRuta).selectByVisibleText(ruta);
    }

    public void seleccionarTren(String tren){
        wait.until(ExpectedConditions.visibilityOf(cboTren));
        new Select(cboTren).selectByVisibleText(tren);
    }

    public void seleccionarFecha(String dia, String mes, String anio){
        wait.until(ExpectedConditions.visibilityOf(dtpFechaSalida));
        dtpFechaSalida.click();

        wait.until(ExpectedConditions.elementToBeClickable(calendario));
        String mesanio = convertirMes(mes) +" "+anio;
        while (calendario.getText().equals(mesanio)==false){
            wait.until(ExpectedConditions.elementToBeClickable(NextCalendaro));
            NextCalendaro.click();
        }
            WebElement day = driver.findElement(By.xpath("//table//a[contains(text(),'"+dia+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(day));
            day.click();

    }

    public String convertirMes(String mes){
        String Tmes="";
        switch (mes){
            case "1":
                Tmes = "January";
                break;
            case "2":
                Tmes = "February";
                break;
            case "3":
                Tmes = "March";
                break;
            case "4":
                Tmes = "April";
                break;
            case "5":
                Tmes = "May";
                break;
            case "6":
                Tmes = "June";
                break;
            case "7":
                Tmes = "July";
                break;
            case "8":
                Tmes = "August";
                break;
            case "9":
                Tmes = "September";
                break;
            case "10":
                Tmes = "October";
                break;
            case "11":
                Tmes = "November";
                break;
            case "12":
                Tmes = "December";
                break;
            default:
                System.out.println("No se encontro el mes");
        }
        return Tmes;
    }

    public void clickEnBuscarTicketTren(){
        wait.until(ExpectedConditions.elementToBeClickable(btnFindTrainticket));
        btnFindTrainticket.click();
    }
}
