package com.socks.api;

import com.socks.api.request_models.UserModel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;

public class UserTest1 {

    public static final String BASE_URL = "http://192.168.56.101";

    public RequestSpecification getRequestSpecification(){
        return   new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setRelaxedHTTPSValidation()
                .build();
    }

    @Test
    public void testCanRegisterNewUser(){
//        UserModel user = new UserModel();
//        user.setUsername(RandomStringUtils.randomAlphanumeric(6));
//        user.setEmail("test@mail.com");
//        user.setPassword("test123");
        UserModel user = new UserModel()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("test@mail.com")
                .password("test123");

        RestAssured
                .given(getRequestSpecification())
                .contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("/register")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", not(emptyString()));

    }
    @Test
    public void testCanNotRegisterSameUserTwice(){
        UserModel user = new UserModel()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("test@mail.com")
                .password("test123");

        RestAssured
                .given(getRequestSpecification())
                .contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("/register")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", not(emptyString()));
        RestAssured
                .given(getRequestSpecification())
                .contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("/register")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
}
