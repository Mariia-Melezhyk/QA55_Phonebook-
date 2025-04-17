package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

@BeforeMethod
    public void precondition(){
    app.clickOnLoginLink();
    app.fillRegisterLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
    app.clickOnLoginButton();

    app.clickOnAddLink();
    app.fillContactForm(new Contact()
            .setName("Oliver")
            .setLastName("Adam")
            .setPhone("01234567890")
            .setEmail("Karl@gmail.com")
            .setAddress("Rishon")
            .setDescription("QA"));
    app.clickOnSaveButton();
}
@Test
    public void deleteContactTest(){
    int sizeBefore = app.sizeOfContacts();
    app.deleteContact();
    app.pause(1000);
    int sizeAfter = app.sizeOfContacts();
    Assert.assertEquals(sizeAfter,sizeBefore -1);

}


}
