package pageobjects.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginUIPage extends BaseUIPage {
    private final String usernameInput = "username";
    private final String passwordInput = "password";
    private final String loginButton = "//*[@id=\"login\"]/button";
    private final String errorText = "//div[@class='flash error']";

    private WebElement elemUsernameInput;
    private WebElement elemPasswordInput;
    private WebElement elemLoginButton;
    private WebElement elemErrorText;

    public LoginUIPage(WebDriver chromeDriver, int waitSeconds) {
        super(chromeDriver, waitSeconds);
        elemUsernameInput = chromeDriver.findElement(By.id(usernameInput));
        elemPasswordInput = chromeDriver.findElement(By.id(passwordInput));
        elemLoginButton = chromeDriver.findElement(By.xpath(loginButton));
    }

    public void loginInSystem(String username, String password) {
        waitDriver.until(ExpectedConditions.visibilityOf(elemUsernameInput));
        elemUsernameInput.sendKeys(username);
        waitDriver.until(ExpectedConditions.visibilityOf(elemPasswordInput));
        elemPasswordInput.sendKeys(password);
        waitDriver.until(ExpectedConditions.visibilityOf(elemLoginButton));
        elemLoginButton.click();
    }

    public List<WebElement> findErrorText() {
        return chromeDriver.findElements(By.xpath(errorText));
    }
}
