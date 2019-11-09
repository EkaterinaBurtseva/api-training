package com.socks.tests;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsersTest {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI ="";
    }

   @Test
    public void newUserRegistrationTest(){

    }

}
