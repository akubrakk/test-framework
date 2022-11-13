package io.swagger.petstore.tests.user;

import io.swagger.petstore.conditions.Conditions;
import org.testng.annotations.Test;

import static io.swagger.petstore.constants.GeneralConstants.TYPE_UNKNOWN;
import static io.swagger.petstore.utils.UserRequestUtil.getRandomUser;
import static org.apache.http.HttpStatus.SC_OK;

public class PostUserTest extends UserBaseTest{

    @Test
    public  void testPostUser(){
        userApiService.postUser(getRandomUser())
                .shouldHave(Conditions.statusCode(SC_OK))
                .shouldHave(Conditions.generalResponse(SC_OK,TYPE_UNKNOWN));
    }

//    @Test
//    public void testPostUserWithTestData(){
//        UserRequest[] userRequests = getTestData(PostUserTest.class, UserRequest[].class);
//
//        Arrays.asList(Objects.requireNonNull(userRequests)).forEach(userRequest ->
//                userApiService.postUser(userRequest)
//                        .shouldHave(Conditions.statusCode(SC_OK))
//                        .shouldHave(Conditions.generalResponse(SC_OK,TYPE_UNKNOWN)));
//
//    }
}
