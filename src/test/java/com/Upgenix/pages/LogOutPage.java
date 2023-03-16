package com.Upgenix.pages;

import com.Upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends BasePage{

    public LogOutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
