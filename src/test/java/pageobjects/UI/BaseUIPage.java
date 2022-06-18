package pageobjects.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUIPage {
    protected WebDriver chromeDriver;
    protected WebDriverWait waitDriver;

    public BaseUIPage(WebDriver chromeDriver, int waitSeconds) {
        this.chromeDriver = chromeDriver;
        this.waitDriver = new WebDriverWait(chromeDriver, waitSeconds);
    }
}
