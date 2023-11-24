package data;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static constants.Endpoints.BASE_URL;
import static constants.Endpoints.CHANGE_DELETE_USER;
import static io.restassured.RestAssured.given;

public class User {
    private String name;
    private String email;
    private String password;

    @Step("Создать пользователя")
    public static Response createUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(BASE_URL + "/api/auth/register");
    }

    @Step("Удаление пользователя")
    public static void deleteUser(String token) {
        if (token != null) {
            given()
                    .header("Authorization", token)
                    .delete(BASE_URL + CHANGE_DELETE_USER)
                    .then()
                    .statusCode(202);
        }
    }

    public User() {
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}