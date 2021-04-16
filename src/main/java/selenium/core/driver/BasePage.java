package selenium.core.driver;


import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import selenium.core.utils.report.screenshot.ScenarioRepository;

import java.util.List;

import static selenium.core.driver.DriverFactory.getDriver;
import static selenium.core.driver.DriverFactory.getDriverWait;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(getDriver(), this);
    }

    private static final Logger log = Logger.getLogger(BasePage.class.getName());

    /**
     * Metodo para realizar um input de texto em um elemento
     *
     * @param elemento campo mapeado
     * @param texto texto da a ser digitado
     */
    protected void digitarTexto(WebElement elemento, String texto) {
        try {
            waitProcessPage();
            esperarElementoFicarVisivel(elemento);
            elemento.sendKeys(texto);
        } catch (WebDriverException e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].value='"+texto+"';", elemento);
        } catch (Exception e) {
            ScenarioRepository.screenShot();
            log.error("Falha ao digitar no elemento :" + elemento);
        }
    }

    /**
     * Metodo para clicar em um elemento de 3 formas caso alguma delas falhem
     * 1º - Selenium
     * 2º - Actions
     * 3º - JavaScript
     *
     * @param elemento elemento mapeado nas pages
     */
    protected void clicarElemento(WebElement elemento) {
        try {
            waitProcessPage();
            esperarElementoFicarClicavel(elemento);
            elemento.click();
        } catch (ElementNotInteractableException e) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(elemento).click().build().perform();
        } catch (WebDriverException e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", elemento);
        } catch (Exception e) {
            ScenarioRepository.screenShot();
            log.error("Falha ao clicar no elemento :" + elemento);
        }
    }

    /**
     * Recupera o texto de um elemento
     *
     * @param elemento elemento que contem um texto
     * @return texto contido no elemento html
     */
    protected String recuperarTexto(WebElement elemento) {
        String valor = null;
        try {
            waitProcessPage();
            esperarElementoFicarVisivel(elemento);
            valor = elemento.getText();
        } catch (Exception e) {
            ScenarioRepository.screenShot();
            log.error("Falha ao clicar no elemento :" + elemento);
        }
        return valor;
    }

    /**
     * Metodo para clicar em um elemento problematico
     *
     * @param elemento elemento mapeado nas pages
     */
    protected void tentarClicarBotaoLoop(WebElement elemento){
        int tentativas = 0;
        do {
            try {
                waitProcessPage();
                esperarElementoFicarClicavel(elemento);
                clicarElemento(elemento);
                return;
            } catch (Exception ignored) {}
            tentativas++;
        } while (tentativas < 10);
    }

    /**
     * Metodo para selecionar uma opção de um Selec List
     *
     * @param elemento selectList mapeado nas pages
     * @param texto texto da opção desejada
     */
    protected void selecionarItemLista(WebElement elemento, String texto){
        Select lista = new Select(elemento);
        lista.selectByVisibleText(texto);
    }

    /**
     * Metodo para selecionar uma opção de um Selec List
     *
     * @param elemento selectList mapeado nas pages
     * @param index posição do elemento
     */
    protected void selecionarItemLista(WebElement elemento, int index){
        Select lista = new Select(elemento);
        lista.selectByIndex(index);
    }

    /**
     * Validar mensagem pop up
     *
     * @param texto texto a ser verificado
     * @return valor booleano de acordo com a existencia do texto no popup
     */
    public boolean validarMensagemPopUp(String texto) {
        return getDriver().switchTo().alert().getText().contains(texto);
    }

    /**
     * Tirar um print da pagina para adicionar ao relatório
     */
    public void tirarPrint(){
        waitProcessPage();
        ScenarioRepository.screenShot();
    }

    /**
     * Tirar um print da pagina para adicionar ao relatório
     * @param elementos Elemento(s) para realizar um highlight no print
     */
    public void tirarPrint(WebElement... elementos){
        waitProcessPage();
        ScenarioRepository.screenShot(elementos);
    }

    /**
     * Percorre lista de elementos e clica no que possui o texto desejado
     * @param listaDeElementos lista de Elementos
     * @param texto texto a ser clicado entre os elementos da lista
     */
    protected void correrListaEClicarElemento(List<WebElement> listaDeElementos, String texto) {
        for (WebElement webElement : listaDeElementos) {
            if (recuperarTexto(webElement).equalsIgnoreCase(texto)) {
                clicarElemento(webElement);
                break;
            }
        }
    }

    /**
     * Valida a existencia do elemento na tela
     * @param elemento elemento mapeado
     * @return valor booleano recorrente da existencia do elemento
     */
    protected boolean verificaElementoPresenteTela(WebElement elemento) {
        boolean valor = false;
        try {
            waitProcessPage();
            esperarElementoFicarClicavel(elemento);
            valor = elemento.isDisplayed();
        } catch (Exception e) {
            ScenarioRepository.screenShot();
            log.error("Falha ao tentar encontrar o elemento: " + elemento);
        }
        return valor;
    }

    /**
     * Valida a existencia do elemento na tela por texto
     * @param texto texto dentro do elemento
     * @return valor booleano recorrente da existencia do elemento
     */
    public boolean verificaElementoPresenteTela(String texto) {
        boolean valor = false;
        try {
            waitProcessPage();
            esperarElementoFicarClicavel(getDriver().findElement(By.xpath("//*[.='"+texto+"']")));
            valor = getDriver().findElement(By.xpath("//*[.='"+texto+"']")).isDisplayed();
        } catch (Exception e) {
            ScenarioRepository.screenShot();
            log.error("Falha ao tentar encontrar o elemento: " + getDriver().findElement(By.xpath("//*[.='"+texto+"']")));
        }
        return valor;
    }

    /**
     * Realizar scroll ate o elemento
     * @param elemento elemento a ser focalizado
     */
    public void scrollAteOElemento(WebElement elemento){
        try {
            esperarElementoFicarVisivel(elemento);
            waitProcessPage();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", elemento);
        }catch (Exception e){
            ScenarioRepository.screenShot();
            log.error("Falha ao tentar encontrar o elemento: " + elemento);
        }

    }

    /**
     * Realizar scroll ate o fim da pagina
     */
    public void scrollAteOFimDaPagina(){
        waitProcessPage();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Realizar scroll ate o topo da pagina
     */
    public void scrollAteOTopoDaPagina(){
        waitProcessPage();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollTop)");
    }

    /**
     * Wait com execucao de codigo JS para aguargar o carregamento dos elementos
     */
    private void waitProcessPage(){
        getDriverWait().until(waitProcess());
    }

    /**
     * Condicao personalizada para carrregar os elementos
     */
    private ExpectedCondition<Boolean> waitProcess() {
        return driver -> {
            try {
                String js = "var reqAjax = typeof window.Ajax !== 'undefined' ?window.Ajax.activeRequestCount : 0;\n" +
                        "var reqAngular = typeof angular !== 'undefined' ? angular.by(document.body).injector().get('$http').pendingRequests.length : 0;\n" +
                        "var reqJquery = typeof jQuery !== 'undefined' ? jQuery.active : 0;\n" +
                        "var reqDom = document.readyState;\n" +
                        "\n" +
                        "if (reqAjax === 0 && reqAngular === 0 & reqJquery === 0 && reqDom === 'complete') {\n" +
                        " return 'complete';\n" +
                        "}\n" +
                        "else {\n" +
                        " return 'process';\n" +
                        "}";

                assert driver != null;
                return ((JavascriptExecutor) driver).executeScript(js).toString().equals("complete");
            } catch (Exception e) {
                return true;
            }
        };
    }

    /**
     * Esperar elemento ficar clicavel
     */
    private void esperarElementoFicarClicavel(WebElement webElement) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Esperar elemento ficar visivel
     */
    private void esperarElementoFicarVisivel(WebElement webElement) {
        getDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

}
