package com.Upgenix.pages;

import com.Upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public void BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id='login']")
    public WebElement loginFormControl;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordFormControl;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement login;

    @FindBy(xpath = "//p")
    public WebElement alertMessage;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement userButton;



    public static WebElement clickButton(String button) {
        BasePage basePage = new UpgenixLoginPage();

        switch (button) {
            case "login":
                return basePage.login;
            case "userButton":
                return basePage.userButton;
            default:
                System.out.println("Button doesn't exist");
                return null;
        }

    }


}
