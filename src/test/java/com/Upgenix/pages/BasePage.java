package com.Upgenix.pages;

import com.Upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public void UpgenixLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "//*[@id='login']")
    public WebElement loginFormControl;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordFormControl;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement log;


}
