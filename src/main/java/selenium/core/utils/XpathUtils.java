package selenium.core.utils;

import org.openqa.selenium.WebElement;
import selenium.core.driver.BasePage;

import java.util.ArrayList;
import java.util.List;

public class XpathUtils extends BasePage {
    /**
     * Metodo que retorna uma lista de String a partir de uma lista de elementos
     * @param elementos elemento(s) que contem texto
     */
    public List<String> retornarListDeStringAPartirDeUmaListaDeElementos(WebElement... elementos){
        List<String> retorno = new ArrayList<>();
        for (WebElement webElement : elementos){
            retorno.add(super.recuperarTexto(webElement));
        }
        return retorno;
    }
}
