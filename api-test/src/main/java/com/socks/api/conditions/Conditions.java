package com.socks.api.conditions;

import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;

@UtilityClass
public class Conditions {

    public StatusCodeConditions statusCode(int statusCode) {
        return new StatusCodeConditions(statusCode);
    }

    public BodyFieldCondition bodyCondition(String jsonPath, Matcher matcher) {
        return new BodyFieldCondition(jsonPath, matcher);
    }
}
