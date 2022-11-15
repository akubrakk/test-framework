package com.socks.api;

import com.github.javafaker.Faker;
import com.socks.api.config.ProjectConfigImpl;
import com.socks.api.services.UserApiService;

import java.util.Locale;

public class UserBaseTest  implements ProjectConfigImpl {
    protected final UserApiService service = new UserApiService();
    protected final Faker faker = new Faker(new Locale(config.locale()));

}
