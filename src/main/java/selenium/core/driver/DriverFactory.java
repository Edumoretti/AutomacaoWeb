package selenium.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.core.driver.enums.Web;
import selenium.core.driver.interfaces.WebApplication;
import selenium.core.utils.PropertiesManager;

/**
 * Classe com design pattern singleton para trabalhar com instancias do Driver
 */
public class DriverFactory {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    /**
     * Recuperar instancia unica do Web Driver
     *
     * @return retorna o WebDriver
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    /**
     * Recuperar instancia unica do Web Driver Wait
     *
     * @return retorna o WebDriverWait
     */
    public static WebDriverWait getDriverWait() {
        if (driver == null) {
            createDriver();
        }
        return wait;
    }

    /**
     * Criar driver com o design pattern singleton
     */
    private static void createDriver() {
        if (driver != null) driver.close();
        driver = ((WebApplication) Web.CHROME).getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertiesManager.getProp("urlAPP"));
    }

    /**
     * Fecha e navegador
     */
    public static void closeDriver(){
        driver.close();
        driver = null;
    }

    /**
     * Mata tarefa do Driver
     */
    public static void killDriver() {
        driver.quit();
        driver = null;
    }

}
