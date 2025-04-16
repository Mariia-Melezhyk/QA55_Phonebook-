package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    //login
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Oliver")
                .setLastName("Adam")
                .setPhone("01234567890")
                .setEmail("Karl@gmail.com")
                .setAddress("Rishon")
                .setDescription("QA"));
        clickOnSaveButton();
        Assert.assertTrue(isContactAdded("Oliver"));
    }

    @AfterMethod
    public void postCondition(){
        deleteContact();

    }

}
