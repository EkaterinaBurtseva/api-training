package com.socks.tests;


import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.socks.api.conditions.Conditions.bodyCondition;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;

public class UsersTest {

    private final UserApiService userApiService = new UserApiService();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "";
    }

    @Test
    public void newUserRegistrationTest() {
        UserPayload user = new UserPayload()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("test@email.com")
                .password("test123");
        userApiService.registerNewUser(user)
               .shouldHave(statusCode(200))
                .shouldHave(bodyCondition("id", not(isEmptyOrNullString())));

    }

    @Test
    public void sameNameUserRegistrationTest(){
        UserPayload user = new UserPayload()
                .username(RandomStringUtils.randomAlphanumeric(6))
                .email("test@email.com")
                .password("test123");
        userApiService.registerNewUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyCondition("id", not(isEmptyOrNullString())));

        userApiService.registerNewUser(user)
                .shouldHave(statusCode(500));
    }

}
