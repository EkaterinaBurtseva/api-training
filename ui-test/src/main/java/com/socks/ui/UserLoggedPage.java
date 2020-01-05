package com.socks.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UserLoggedPage {
    public SelenideElement logoutBtn() {
        return $("#logout>a");
    }

    public SelenideElement userName() {
        return $("#howdy>a");
    }
}
