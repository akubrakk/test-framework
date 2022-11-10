package com.socks.api;

import com.socks.api.conditions.Conditions;
import com.socks.api.request_models.UserModel;
import com.socks.api.response_models.UserRegistrationResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;

public class UserTest2 extends UserBaseTest {

    @Test
    public void testCanRegisterNewUser(){


        UserModel user = new UserModel()
                .username(faker.funnyName().name())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

       service.registerUser(user)
               .shouldHave(Conditions.statusCde(HttpStatus.SC_OK))
               .shouldHave(Conditions.bodyField("id", not(emptyString())));


    }
    @Test
    public void testCanNotRegisterSameUserTwice(){
        UserModel user = new UserModel()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        service.registerUser(user)
                .shouldHave(Conditions.statusCde(HttpStatus.SC_OK))
                .shouldHave(Conditions.bodyField("id", not(emptyString())));
        service.registerUser(user)
                .shouldHave(Conditions.statusCde(HttpStatus.SC_INTERNAL_SERVER_ERROR));

    }
    @Test
    public void testCanRegisterNewUserPojo(){
        UserModel user = new UserModel()
                .username(faker.funnyName().name())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        UserRegistrationResponse responseUser = service.registerUser(user)
                .shouldHave(Conditions.statusCde(HttpStatus.SC_OK))
                .asPojo(UserRegistrationResponse.class);
        responseUser.getId();

    }
}
