package stellarburgers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAction {

    @Step("Create user REST request")
    public static void createUser(User user) {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/register");
    }

    @Step("Login user REST request")
    public static Response loginUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/login");
    }

    @Step("Delete user REST request")
    public static void deleteUser(String token) {
        given()
                .auth().oauth2(token)
                .delete("/api/auth/user");
    }

    @Step("Get user access token REST request")
    public static String getAccessTokenUser(User user) {
        return loginUser(user)
                .then().extract().body().path("accessToken").toString().substring(7);
    }
}