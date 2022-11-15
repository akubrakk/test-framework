package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.request_models.UserModel;


public class UserApiService extends  ApiService {

    public AssertableResponse registerUser(UserModel user){
       return new AssertableResponse( request()
               .body(user)
               .when()
               .post("register"));
    }
}
