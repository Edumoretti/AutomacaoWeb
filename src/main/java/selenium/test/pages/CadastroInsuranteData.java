package selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.core.driver.BasePage;
import selenium.core.utils.FakeUtils;

public class CadastroInsuranteData extends BasePage {

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement txtLastName;

    @FindBy(xpath = "//input[@id='birthdate']")
    private WebElement txtBirthDate;

    @FindBy(xpath = "//input[@id='gendermale']")
    private WebElement txtGender;

    @FindBy(xpath = "//input[@id='streetaddress']")
    private WebElement txtStreetAddress;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement lstCountry;

    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement txtZipCode;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement txtCity;

    @FindBy(xpath = "//select[@id='occupation']")
    private WebElement lstOccupation;

    @FindBy(xpath = "//input[@id='skydiving']")
    private WebElement optSkydiving;

    @FindBy(xpath = "//button[@id='nextenterproductdata']")
    private WebElement btnNextEnterProductData;

    @FindBy(xpath = "//a[@id='enterinsurantdata']")
    private WebElement aEnterInsurantData;


    public boolean aguardarPaginaInicialCarregar(){
        super.tirarPrint(aEnterInsurantData);
        return super.verificaElementoPresenteTela(aEnterInsurantData);
    }

    public void fillOutFirstName(){
        super.clicarElemento(txtFirstName);
        super.digitarTexto(txtFirstName, FakeUtils.gerarPrimeiroNome().replace("'",""));
    }

    public void fillOutLastName(){
        super.clicarElemento(txtLastName);
        super.digitarTexto(txtLastName, FakeUtils.gerarUltimoNome().replace("'",""));
    }

    public void fillOutBirthDate(){
        super.clicarElemento(txtBirthDate);
        super.digitarTexto(txtBirthDate, "12/12/1982");
    }

    public void fillOutGender(){
        super.clicarElemento(txtGender);
    }

    public void fillOutStreetAddress(){
        super.clicarElemento(txtStreetAddress);
        super.digitarTexto(txtStreetAddress, FakeUtils.gerarEndereco());
    }

    public void fillOutCountry(){
         super.selecionarItemLista(lstCountry, "United Kingdom");
    }

    public void fillOutZipCode(){
        super.clicarElemento(txtZipCode);
        super.digitarTexto(txtZipCode,"123456");
        //super.digitarTexto(txtZipCode, FakeUtils.gerarCep().replace("-","").replace(" ",""));
    }

    public void fillOutCity(){
        super.clicarElemento(txtCity);
        super.digitarTexto(txtCity, FakeUtils.gerarCidade());
    }

    public void fillOutOccupation(){
        super.selecionarItemLista(lstOccupation, 1);
    }

    public void fillOutSkydiving(){
        super.scrollAteOFimDaPagina();
        super.tirarPrint();
        super.clicarElemento(optSkydiving);
    }

    public void clickEnterProductData(){
        super.clicarElemento(btnNextEnterProductData);
    }

}
