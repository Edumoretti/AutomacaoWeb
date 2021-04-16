package selenium.test.steps;

import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;
import selenium.test.pages.*;

public class CadastroSteps {

    protected CadastroVehicleData cadastroPage = new CadastroVehicleData();
    protected CadastroInsuranteData insurantDataPage = new CadastroInsuranteData();
    protected CadastroProductData productDataPage = new CadastroProductData();
    protected CadastroPriceOption priceOptionPage = new CadastroPriceOption();
    protected CadastroSendQuote sendQuotePage = new CadastroSendQuote();

    @Dado("que eu acesso o site")
    public void que_eu_acesso_o_site() {
        Assert.assertTrue(cadastroPage.aguardarPaginaInicialCarregar());
    }

    @E("preencher dados do veiculo")
    public void preencher_dados_do_veiculo() {
        cadastroPage.fillOutMake();
        cadastroPage.fillOutModel();
        cadastroPage.fillOutCylinder();
        cadastroPage.fillOutEnginePerformance();
        cadastroPage.fillOutDateManufacture();
        cadastroPage.fillOutNumberSeats();
        cadastroPage.fillOutRightHandDriveyes();
        cadastroPage.fillOutNumberSeatsMotorcycle();
        cadastroPage.fillOutFuel();
        cadastroPage.fillOutPayload();
        cadastroPage.fillOutTotalWeight();
        cadastroPage.fillOutListPrice();
        cadastroPage.fillOutLicensePlateNumber();
        cadastroPage.fillOutAnnualMileage();
        cadastroPage.fillOutNextEnterInsurantData();
    }


    @E("preencher dados do seguro")
    public void preencher_dados_do_seguro() {
        insurantDataPage.aguardarPaginaInicialCarregar();
        insurantDataPage.fillOutFirstName();
        insurantDataPage.fillOutLastName();
        insurantDataPage.fillOutBirthDate();
        insurantDataPage.fillOutGender();
        insurantDataPage.fillOutStreetAddress();
        insurantDataPage.fillOutCountry();
        insurantDataPage.fillOutZipCode();
        insurantDataPage.fillOutCity();
        insurantDataPage.fillOutOccupation();
        insurantDataPage.fillOutSkydiving();
        insurantDataPage.clickEnterProductData();
    }

    @E("preencher dados do produto")
    public void preencher_dados_do_produto() {
        productDataPage.aguardarPaginaInicialCarregar();
        productDataPage.fillOutStartDate();
        productDataPage.fillOutInsuranceSum();
        productDataPage.fillOutMeritrating();
        productDataPage.fillOutDamageInsurance();
        productDataPage.fillOutEuroProtection();
        productDataPage.fillOutCourteSycar();
        productDataPage.fillOutNextSelectPriceOption();
    }

    @E("selecionar opcao de precos")
    public void selecionar_opcao_de_precos() {
        priceOptionPage.aguardarPaginaInicialCarregar();
        priceOptionPage.fillOutSilver();
        priceOptionPage.clickNextSendQuote();
    }

    @Quando("enviar a cotacao")
    public void enviar_a_cotacao() {
        sendQuotePage.aguardarPaginaInicialCarregar();
        sendQuotePage.fullOutEmail();
        sendQuotePage.fullOutPhone();
        sendQuotePage.fullOutUserName();
        sendQuotePage.fullOutPassword();
        sendQuotePage.fullOutConfirmPassword();
        sendQuotePage.clickSendQuote();
        sendQuotePage.aguardarMensagemSucesso();
    }




}
