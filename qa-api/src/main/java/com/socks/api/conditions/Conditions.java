package com.socks.api.conditions;

import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;

@UtilityClass
public class Conditions {
    public StatusCodeCondition statusCde(int code){
        return new StatusCodeCondition(code);
    }

    public BodyFieldCondition bodyField(String jsonPath, Matcher<String> matcher){
        return new BodyFieldCondition(jsonPath,matcher);
    }
}
