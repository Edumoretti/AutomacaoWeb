package selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.core.driver.BasePage;

public class CadastroPriceOption extends BasePage {

    @FindBy(xpath ="//a[@id='selectpriceoption']")
    private WebElement aSelectPriceoption;

    @FindBy(xpath ="//input[@id='selectgold']")
    private WebElement optSelectSilver;

    @FindBy(xpath = "//button[@id='nextsendquote']")
    private WebElement btnNextSendQuote;

    public boolean aguardarPaginaInicialCarregar(){
        super.tirarPrint(aSelectPriceoption);
        return super.verificaElementoPresenteTela(aSelectPriceoption);
    }

    public void fillOutSilver(){
        super.clicarElemento(optSelectSilver);
    }

    public void clickNextSendQuote(){
        super.tirarPrint(btnNextSendQuote);
        super.clicarElemento(btnNextSendQuote);
    }
}
