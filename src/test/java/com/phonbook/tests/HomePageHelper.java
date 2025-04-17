package com.phonbook.tests;

import org.openqa.selenium.By;

public class HomePageHelper extends BaseHelper {
    public boolean isHomeComponentPresent(){
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }
}
