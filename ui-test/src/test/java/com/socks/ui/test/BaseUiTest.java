package com.socks.ui.test;

import com.codeborne.selenide.Selenide;
import com.socks.api.ProjectConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;

public class BaseUiTest {
    @BeforeSuite
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
        //Configuration.baseUrl=config.baseUrl();
    }

    protected <T> T at(Class<T> pageClass){
        return Selenide.page(pageClass);
    }
}
