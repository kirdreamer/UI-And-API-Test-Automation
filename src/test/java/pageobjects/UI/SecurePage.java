package pageobjects.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecurePage extends BaseUIPage{
    private final String successText = "//div[@class='flash success']";

    private WebElement elemSuccess;

    public SecurePage(WebDriver chromeDriver, int waitSeconds) {
        super(chromeDriver, waitSeconds);
        elemSuccess = chromeDriver.findElement(By.xpath(successText));
    }

    public WebElement getElemSuccess() {
        return elemSuccess;
    }
}
