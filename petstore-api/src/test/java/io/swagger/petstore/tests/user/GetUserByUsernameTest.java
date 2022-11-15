package io.swagger.petstore.tests.user;

import io.swagger.petstore.payloads.user.UserRequest;
import io.swagger.petstore.responses.GeneralResponse;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static io.swagger.petstore.conditions.Conditions.statusCode;
import static io.swagger.petstore.utils.UserRequestUtil.getRandomUser;
import static org.apache.http.HttpStatus.SC_OK;

public class GetUserByUsernameTest extends UserBaseTest{

    @Test
    public void testGetUserByUsername(){
        UserRequest userRequest = getRandomUser();

        userApiService.postUser(userRequest)
                .shouldHave(statusCode(SC_OK));

        GeneralResponse generalResponse =  userApiService.getUserByUsername(userRequest.getUsername())
                .shouldHave(statusCode(SC_OK))
                .asPojo(GeneralResponse.class);

        Assertions.assertThat(generalResponse.getUsername()).isEqualTo(userRequest.getUsername());
    }
}
