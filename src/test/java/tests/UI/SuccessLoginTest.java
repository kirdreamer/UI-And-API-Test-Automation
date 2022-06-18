package tests.UI;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.UI.LoginUIPage;
import pageobjects.UI.SecurePage;

import java.io.IOException;
import java.util.Properties;

public class SuccessLoginTest extends BaseTest {

    @Test(description = "Check successful login")
    public void checkSuccessfulLogin() throws IOException {
        Properties properties = getApplicationProperties();
        chromeDriver.get(properties.getProperty("login_page.url"));
        LoginUIPage loginUIPage = new LoginUIPage(chromeDriver, 15);
        loginUIPage.loginInSystem(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertEquals(loginUIPage.findErrorText().size(), 0, "The error element was found => " +
                "the problem with correct username and password");
        SecurePage securePage = new SecurePage(chromeDriver, 15);
        Assert.assertNotNull(securePage.getElemSuccess(), "The success element wasn't found => " +
                "the problem with moving to the next page / the problem with elements on the next page");
    }
}
