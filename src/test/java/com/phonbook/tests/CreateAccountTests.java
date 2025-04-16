package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        //int i=(int)((System.currentTimeMillis()/1000)%3600);

        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void existedUserRegistrationNegatineTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());
    }

}
