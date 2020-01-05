package com.socks.ui.test;

import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import com.socks.ui.MainPage;
import com.socks.ui.UserLoggedPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TestLogin extends BaseUiTest{

    private final UserApiService userApiService = new UserApiService();
    @Test
    public void userCanLoginWithValidCredentials(){

        UserPayload user = new UserPayload()
                .username(randomAlphanumeric(6))
                .email("test@email.com")
                .password("test123");
        userApiService.registerNewUser(user).shouldHave(statusCode(200));
        MainPage.open()
                .loginAs(user.username(),user.password());
        UserLoggedPage userLoggedPage=  at(UserLoggedPage.class);
        userLoggedPage.logoutBtn().shouldHave(text("Logout"));
        userLoggedPage.userName().shouldHave(text("Logged in as"));
    }
}
