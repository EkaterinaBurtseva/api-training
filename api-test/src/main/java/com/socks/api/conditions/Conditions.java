package com.socks.api.conditions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Conditions {

    public StatusCodeConditions statusCode(int statusCode){
        return new StatusCodeConditions(statusCode);
    }
}
