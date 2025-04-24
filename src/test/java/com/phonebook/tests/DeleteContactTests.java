package com.phonebook.tests;

import com.phonebook.data.Contactdata;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

@BeforeMethod
    public void precondition(){

    if(!app.getUser().isLoginLinkPresent()){
        app.getUser().clickOnSignOutButton();
    }
    app.getUser().clickOnLoginLink();
    app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
    app.getUser().clickOnLoginButton();

    app.getContact().clickOnAddLink();
    app.getContact().fillContactForm(new Contact()
            .setName(Contactdata.Name)
            .setLastName(Contactdata.LAST_Name)
            .setPhone(Contactdata.PHONE)
            .setEmail(Contactdata.EMAIL)
            .setAddress(Contactdata.ADRESS)
            .setDescription(Contactdata.DESCRIPTION));
    app.getContact().clickOnSaveButton();
}
@Test
    public void deleteContactTest(){
    int sizeBefore = app.getContact().sizeOfContacts();
    app.getContact().deleteContact();
    app.getContact().pause(1000);
    int sizeAfter = app.getContact().sizeOfContacts();
    Assert.assertEquals(sizeAfter,sizeBefore -1);

}


}
