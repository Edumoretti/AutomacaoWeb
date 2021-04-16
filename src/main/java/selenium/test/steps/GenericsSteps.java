package selenium.test.steps;

import io.cucumber.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.core.driver.BasePage;

public class GenericsSteps {
    BasePage base = new BasePage();



    @Então("validar a mensagem {string} esta sendo exibida")
    public void validar_a_mensagem_esta_sendo_exibida(String mensagem) throws InterruptedException {

        //Thread.sleep(20000);


        Assert.assertTrue(base.verificaElementoPresenteTela(mensagem));
        base.tirarPrint();
    }

}
