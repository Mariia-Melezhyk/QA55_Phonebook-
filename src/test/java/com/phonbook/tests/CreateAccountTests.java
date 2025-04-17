package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase{

    SoftAssert softAssert=new SoftAssert();
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        //int i=(int)((System.currentTimeMillis()/1000)%3600);
        app.clickOnLoginLink();
        app.fillRegisterLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        app.clickOnRegistrationButton();
        Assert.assertTrue(app.isSignOutButtonPresent());
    }
    @Test
    public void existedUserRegistrationNegatineTest(){
        app.clickOnLoginLink();
        app.fillRegisterLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        app.clickOnRegistrationButton();
        softAssert.assertTrue(app.isAlertDisplayed());
        softAssert.assertTrue(isErrorMessagePresent());
        softAssert.assertAll();
    }

}
