package selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.core.driver.BasePage;
import selenium.core.utils.FakeUtils;

public class CadastroSendQuote extends BasePage {


    @FindBy(xpath = "//input[@id='email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement txtPhone;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement txtUserName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement txtPassWord;

    @FindBy(xpath = "//input[@id='confirmpassword']")
    private WebElement txtConfirmpassword;

    @FindBy(xpath = "//button[@id='sendemail']")
    private WebElement txtSendMail;

    @FindBy(xpath = "//a[@id='sendquote']")
    private WebElement aSendQuote;

    @FindBy(xpath = "//button[@id='sendemail']")
    private WebElement btnSendemail;

    @FindBy(xpath = "//*[.='Sending e-mail success!']")
    private WebElement txtMensagemSucesso;

    public boolean aguardarPaginaInicialCarregar(){
        super.tirarPrint(aSendQuote);
        return super.verificaElementoPresenteTela(txtEmail);
    }

    public void fullOutEmail(){
        super.clicarElemento(txtEmail);
        super.digitarTexto(txtEmail, FakeUtils.gerarEmail());
    }

    public void fullOutPhone(){
        super.clicarElemento(txtPhone);
        super.digitarTexto(txtPhone, FakeUtils.gerarTelefone().replace("-","")
                                                              .replace(" ",""));
    }

    public void fullOutUserName(){
        super.clicarElemento(txtUserName);
        super.digitarTexto(txtUserName, "edumoretti28");
    }

    public void fullOutPassword(){
        super.clicarElemento(txtPassWord);
        super.digitarTexto(txtPassWord, "24CD69bt");
    }

    public void fullOutConfirmPassword(){
        super.clicarElemento(txtConfirmpassword);
        super.digitarTexto(txtConfirmpassword, "24CD69bt");
        super.tirarPrint(txtConfirmpassword);
    }

    public void clickSendQuote(){
        super.tirarPrint(btnSendemail);
        super.clicarElemento(btnSendemail);
    }

    public boolean aguardarMensagemSucesso(){
        return super.verificaElementoPresenteTela(txtMensagemSucesso);
    }


}
