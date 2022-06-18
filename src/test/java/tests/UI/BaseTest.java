package tests.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver chromeDriver;
    private final String rootPath = "src/main/resources/";
    private String webUIConfigurationPath = rootPath + "webUI.properties";

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() {
        chromeDriver.quit();
    }

    public Properties getApplicationProperties() throws IOException {
        Properties applicationProperties = new Properties();
        applicationProperties.load(new FileInputStream(webUIConfigurationPath));
        return applicationProperties;
    }
}
