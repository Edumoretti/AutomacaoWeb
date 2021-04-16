package selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.core.driver.BasePage;
import selenium.core.utils.FakeUtils;

public class CadastroVehicleData extends BasePage {

    @FindBy(xpath = "//select[@id='make']")
    private WebElement lstMake;

    @FindBy(xpath = "//select[@id='model']")
    private WebElement lstModel;

    @FindBy(xpath = "//input[@id='cylindercapacity']")
    private WebElement txtCylindercapacity;

    @FindBy(xpath = "//input[@id='engineperformance']")
    private WebElement txtEngineperformance;

    @FindBy(xpath="//input[@id='dateofmanufacture']")
    private WebElement txtDateofmanufacture;

    @FindBy(xpath="//select[@id='numberofseats']")
    private WebElement lstNumberofseats;

    @FindBy(xpath="//input[@id='righthanddriveyes']")
    private WebElement rdoRighthanddriveyes;

    @FindBy(xpath="//select[@id='numberofseatsmotorcycle']")
    private WebElement lstNumberSeatsMotorcycle;

    @FindBy(xpath = "//select[@id='fuel']")
    private WebElement lstFuel;

    @FindBy(xpath = "//input[@id='payload']")
    private  WebElement txtPayload;

    @FindBy(xpath = "//input[@id='totalweight']")
    private WebElement txtTotalweight;

    @FindBy(xpath = "//input[@id='listprice']")
    private  WebElement txtListprice;

    @FindBy(xpath = "//input[@id='licenseplatenumber']")
    private WebElement txtLicenseplatenumber;

    @FindBy(xpath = "//input[@id='annualmileage']")
    private WebElement txtAnnualmileage;

    @FindBy(xpath = "//button[@id='nextenterinsurantdata']")
    private WebElement btnNextenterinsurantdata;

    @FindBy(xpath = "//img[@id='tricentis_logo']")
    private  WebElement imgtricentis_logo;


    public boolean aguardarPaginaInicialCarregar(){
        super.tirarPrint(imgtricentis_logo);
        return super.verificaElementoPresenteTela(imgtricentis_logo);
    }

    public void fillOutMake(){
        super.selecionarItemLista(lstMake, 1);
    }

    public void fillOutModel(){
        super.selecionarItemLista(lstModel, 1);
    }

    public void fillOutCylinder(){
        super.digitarTexto(txtCylindercapacity, "50");
    }

    public void fillOutEnginePerformance(){
        super.clicarElemento(txtEngineperformance);
        super.digitarTexto(txtEngineperformance, "100");
    }

    public void fillOutDateManufacture(){
        super.clicarElemento(txtDateofmanufacture);
        super.digitarTexto(txtDateofmanufacture, "11/10/2019");
    }

    public void fillOutRightHandDriveyes(){
        super.tirarPrint();
        super.clicarElemento(rdoRighthanddriveyes);
    }

    public  void fillOutNumberSeatsMotorcycle(){
        super.selecionarItemLista(lstNumberSeatsMotorcycle, 1);
    }

    public void fillOutNumberSeats(){
        super.selecionarItemLista(lstNumberofseats, 1);
    }

    public void fillOutFuel(){
        super.selecionarItemLista(lstFuel, 4);
    }

    public void fillOutPayload(){
        super.clicarElemento(txtPayload);
        super.digitarTexto(txtPayload, "200");
    }

    public void fillOutTotalWeight(){
        super.clicarElemento(txtTotalweight);
        super.digitarTexto(txtTotalweight, "250");
    }

    public void fillOutListPrice(){
        super.clicarElemento(txtListprice);
        super.digitarTexto(txtListprice, "1100");
    }

    public void fillOutLicensePlateNumber(){
        super.clicarElemento(txtLicenseplatenumber);
        super.digitarTexto(txtLicenseplatenumber, "123456");
    }

    public void fillOutAnnualMileage(){
        super.clicarElemento(txtAnnualmileage);
        super.digitarTexto(txtAnnualmileage, "1500");
        super.scrollAteOFimDaPagina();
        super.tirarPrint();
    }

    public void fillOutNextEnterInsurantData() {
        super.clicarElemento(btnNextenterinsurantdata);
    }
}
