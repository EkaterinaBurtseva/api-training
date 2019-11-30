package com.socks.tests;


import com.github.javafaker.Faker;
import com.socks.api.ProjectConfig;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.socks.api.conditions.Conditions.bodyCondition;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;

public class UsersTest {

    private final UserApiService userApiService = new UserApiService();
    private Faker faker;

    @BeforeClass
    public void setUp() {

        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
        faker = new Faker(new Locale(config.locale()));
    }

    @Test
    public void newUserRegistrationTest() {
        UserPayload user = new UserPayload()
                .username(faker.name().username())
                .email("test@email.com")
                .password("test123");
        userApiService.registerNewUser(user)
                .shouldHave(statusCode(200))
                //  .asPojo(UserRegistrationResponse.class);
                // response.getId();
                .shouldHave(bodyCondition("id", not(isEmptyOrNullString())));

    }

    @Test
    public void sameNameUserRegistrationTest() {
        UserPayload user = new UserPayload()
                .username(faker.name().username())
                .email("test@email.com")
                .password("test123");
        userApiService.registerNewUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyCondition("id", not(isEmptyOrNullString())));

        userApiService.registerNewUser(user)
                .shouldHave(statusCode(500));
    }

}
