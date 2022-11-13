package io.swagger.petstore.tests.user;

import io.swagger.petstore.conditions.Conditions;
import org.testng.annotations.Test;

import static io.swagger.petstore.constants.GeneralConstants.TYPE_UNKNOWN;
import static io.swagger.petstore.utils.UserRequestUtil.getRandomUser;
import static org.apache.http.HttpStatus.SC_OK;

public class PostUserCreateWithArrayTest extends UserBaseTest{

    @Test
    public void postUserCreateWithArrayTest(){
        userApiService.postUserCreateWithArray(
                getRandomUser(),
                getRandomUser(),
                getRandomUser())
                        .shouldHave(Conditions.statusCode(SC_OK))
                        .shouldHave(Conditions.generalResponse(SC_OK,TYPE_UNKNOWN));
    }
}
