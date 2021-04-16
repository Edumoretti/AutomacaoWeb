package selenium.core.utils.report.screenshot.impl;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UntilScreenShot {
    public static IScreenshot<byte[]> screenShotWeb(final WebDriver webdriver) {
        return new IScreenshot<byte[]>() {
            @Override
            public byte[] apply(Object input) {
                return ScrrenshotUtils.screenshot(webdriver);
            }
        };
    }

    public static IScreenshot<byte[]> screenShotWeb(final WebDriver webdriver, final WebElement... webElement) {
        return new IScreenshot<byte[]>() {
            @Override
            public byte[] apply(Object input) {
                String jsHighlight = ScrrenshotUtils.getJavaScriptHighlight(webdriver, webElement);
                String jsUnHighlight = ScrrenshotUtils.getJavaScriptUnHighlight(webdriver, webElement);
                ScrrenshotUtils.executeJavaScript(webdriver, jsHighlight, webElement);
                byte[] screenshot = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
                ScrrenshotUtils.executeJavaScript(webdriver, jsUnHighlight, webElement);
                return screenshot;
            }
        };
    }
}
