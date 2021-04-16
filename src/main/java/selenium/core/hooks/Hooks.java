package selenium.core.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import selenium.core.driver.DriverFactory;
import selenium.core.utils.report.screenshot.ScenarioRepository;

public class Hooks {
    @Before
    public void inicializarTest(Scenario scenario){
        ScenarioRepository.add(scenario);
    }

    @After
    public void apenasFechar(){
        DriverFactory.closeDriver();
        ScenarioRepository.remove();
    }

    @AfterClass
    public static void matarTarefa(){
        DriverFactory.killDriver();
    }
}
