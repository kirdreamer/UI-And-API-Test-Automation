package tests.UI;

import helper.RandomHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.UI.LoginUIPage;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class UnsuccessLoginTest extends BaseTest {

    private final String commonErrorMessage = "The error element wasn't found => Login was successful. The problem exists with ";

    @Test(description = "Check unsuccessful login without username and password")
    public void unsuccessLoginWithoutUsernameAndPassword() throws IOException {
        Properties properties = getApplicationProperties();
        chromeDriver.get(properties.getProperty("login_page.url"));
        LoginUIPage loginUIPage = new LoginUIPage(chromeDriver, 15);
        loginUIPage.loginInSystem("", "");
        Assert.assertEquals(loginUIPage.findErrorText().size(), 1,
                commonErrorMessage + "empty username and password"
        );
    }

    @Test(description = "Check unsuccessful login without password")
    public void unsuccessLoginWithoutPassword() throws IOException {
        Properties properties = getApplicationProperties();
        chromeDriver.get(properties.getProperty("login_page.url"));
        LoginUIPage loginUIPage = new LoginUIPage(chromeDriver, 15);
        loginUIPage.loginInSystem(properties.getProperty("username"), "");
        Assert.assertEquals(loginUIPage.findErrorText().size(), 1,
                commonErrorMessage + "empty password"
        );
    }

    @Test(description = "Check unsuccessful login without username")
    public void unsuccessLoginWithoutUsername() throws IOException {
        Properties properties = getApplicationProperties();
        chromeDriver.get(properties.getProperty("login_page.url"));
        LoginUIPage loginUIPage = new LoginUIPage(chromeDriver, 15);
        loginUIPage.loginInSystem("", properties.getProperty("password"));
        Assert.assertEquals(loginUIPage.findErrorText().size(), 1,
                commonErrorMessage + "empty username"
        );
    }

    @Test(description = "Check unsuccessful login with wrong username")
    public void unsuccessLoginWithWrongUsername() throws IOException {
        RandomHelper randomHelper = new RandomHelper();
        Properties properties = getApplicationProperties();
        chromeDriver.get(properties.getProperty("login_page.url"));
        LoginUIPage loginUIPage = new LoginUIPage(chromeDriver, 15);
        loginUIPage.loginInSystem(
                randomHelper.getRandomString((new Random().nextInt(20) + 1), true, true),
                properties.getProperty("password")
        );
        Assert.assertEquals(loginUIPage.findErrorText().size(), 1,
                commonErrorMessage + "wrong username"
        );
    }

    @Test(description = "Check unsuccessful login with wrong username and password")
    public void unsuccessLoginWithWrongPassword() throws IOException {
        RandomHelper randomHelper = new RandomHelper();
        Properties properties = getApplicationProperties();
        chromeDriver.get(properties.getProperty("login_page.url"));
        LoginUIPage loginUIPage = new LoginUIPage(chromeDriver, 15);
        loginUIPage.loginInSystem(
                properties.getProperty("username"),
                randomHelper.getRandomString((new Random().nextInt(20) + 1), true, true)
        );
        Assert.assertEquals(loginUIPage.findErrorText().size(), 1,
                commonErrorMessage + "wrong username and password"
        );
    }
}
