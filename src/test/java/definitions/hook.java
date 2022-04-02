package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class hook {
    private static String navegador="chrome";
    public static WebDriver driver;
    //private static String url = "www.google.com";

    @Before
    public static void setup(){
        if (navegador.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            //driver.get(url);
        } else if (navegador.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/resources/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            //driver.get(url);
        } else {
            System.out.println("El navegador que deseas inicializar no esta instanciado"+navegador);
        }
    }

    @After
    public static void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
