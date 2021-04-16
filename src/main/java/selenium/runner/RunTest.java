package selenium.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import selenium.core.utils.report.Report;


@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"selenium/test/steps", "selenium/core/hooks"},
        tags = {"@regressivo"}
)


public class RunTest {
    @AfterClass
    public static void gerarRelatorio(){
        Report.gerarRelarotioClueCumber();
    }
}
