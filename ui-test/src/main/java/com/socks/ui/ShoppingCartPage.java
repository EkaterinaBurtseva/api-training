package com.socks.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage {
    public SelenideElement totalAmount() {
        return $("");
    }

    @Step
    public static ShoppingCartPage open() {
        Selenide.open("/basket.html");

        return new ShoppingCartPage();
    }

    @Step
    public ShoppingCartPage deleteItem() {
        $("#cart-list > tr > td:nth-child(8) > a > i").click();

        return this;
    }
}
