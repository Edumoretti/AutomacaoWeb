package selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.core.driver.BasePage;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CadastroProductData extends BasePage {


    @FindBy(xpath = "//input[@id='startdate']")
    private WebElement txtStartDate;

    @FindBy(xpath = "//select[@id='insurancesum']")
    private WebElement lstInsuranceSum;

    @FindBy(xpath = "//select[@id='meritrating']")
    private WebElement lstMeritrating;

    @FindBy(xpath = "//select[@id='damageinsurance']")
    private WebElement lstDamageInsurance;

    @FindBy(xpath = "//input[@id='EuroProtection']")
    private WebElement ckEuroProtection;

    @FindBy(xpath = "//select[@id='courtesycar']")
    private WebElement lstCourteSycar;

    @FindBy(xpath = "//a[@id='enterproductdata']")
    private WebElement aEnterproductData;

    @FindBy(xpath ="//button[@id='nextselectpriceoption']")
    private WebElement btnNextSelectPriceOption;


    public boolean aguardarPaginaInicialCarregar(){
        super.tirarPrint(aEnterproductData);
        return super.verificaElementoPresenteTela(aEnterproductData);
    }

    public void fillOutStartDate(){
        super.clicarElemento(txtStartDate);
        super.digitarTexto(txtStartDate, "06/30/2021");
    }

    public void fillOutInsuranceSum (){
        super.selecionarItemLista(lstInsuranceSum, 1);
    }

    public void fillOutMeritrating(){
        super.selecionarItemLista(lstMeritrating, 1);
    }

    public void fillOutDamageInsurance(){
        super.selecionarItemLista(lstDamageInsurance, 1);
    }

    public void fillOutEuroProtection(){
        super.clicarElemento(ckEuroProtection);
    }

    public void fillOutCourteSycar(){
        super.scrollAteOFimDaPagina();
        super.tirarPrint();
        super.selecionarItemLista(lstCourteSycar, 1);
    }

    public void fillOutNextSelectPriceOption(){
        super.clicarElemento(btnNextSelectPriceOption);
    }
}
