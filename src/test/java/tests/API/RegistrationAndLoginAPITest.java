package tests.API;

import models.API.AuthorizationModel;
import models.API.RegistrationModel;
import models.API.UserCredentialsModel;
import models.API.UserRegistrationModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class RegistrationAndLoginAPITest extends AbstractAPITest {
    private UserCredentialsModel userCredentialsModel;
    private String token;

    @Test (description = "Getting credentials from user")
    public void getCredentials() {
        userCredentialsModel = given()
                .when()
                .get(endpoint + "/users/2")
                .then()
                .log().body()
                .extract().body().as(UserCredentialsModel.class);
    }

    @Test(
            dependsOnMethods = "getCredentials",
            description = "Complete registration"
    )
    public void registerNewUser() {
        UserRegistrationModel userRegistrationModel = new UserRegistrationModel(
                userCredentialsModel.getData().getEmail(),
                randomHelper.getRandomString((new Random().nextInt(20) + 1), true, true)
        );
        RegistrationModel registrationModel = given()
                .contentType("application/json")
                .when()
                .body(userRegistrationModel)
                .post(endpoint + "/register")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().as(RegistrationModel.class);
        token =  registrationModel.getToken();
    }

    @Test(
            dependsOnMethods = "registerNewUser",
            description = "Performing a login"
    )
    public void login() {
        UserRegistrationModel userRegistrationModel = new UserRegistrationModel(
                userCredentialsModel.getData().getEmail(),
                randomHelper.getRandomString((new Random().nextInt(20) + 1), true, true)
        );
        AuthorizationModel authorizationModel = given()
                .contentType("application/json")
                .when()
                .body(userRegistrationModel)
                .post(endpoint + "/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().as(AuthorizationModel.class);
        Assert.assertEquals(authorizationModel.getToken(), token,
                "Tokens are not equal => User logged into someone else's system with his credentials"
        );
    }


}
