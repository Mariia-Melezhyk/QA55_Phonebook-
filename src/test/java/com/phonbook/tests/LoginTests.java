package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        app.clickOnLoginLink();
        app.fillRegisterLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        app.clickOnLoginButton();
        Assert.assertTrue(app.isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeWithoutEmailTest(){
        app.clickOnLoginLink();
        app.fillRegisterLoginForm(new User().setPassword("Nnoa12345$"));
        app.clickOnLoginButton();
        Assert.assertTrue(app.isAlertDisplayed());
    }

}
