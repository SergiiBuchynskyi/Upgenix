package com.Upgenix.step_definitions;

import com.Upgenix.pages.UpgenixLoginPage;
import com.Upgenix.utilities.BrowserUtils;
import com.Upgenix.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.owasp.html.Handler;

import java.security.Key;

public class UpgenixLogOut {
    UpgenixLoginPage upgenixLoginPage = new UpgenixLoginPage();

    @Given("user is already logged in")
    public void userIsAlreadyLoggedIn() {
        Driver.getDriver().get("https://qa.upgenix.net/");
        upgenixLoginPage.loginFormControl.sendKeys("salesmanager15@info.com");
        upgenixLoginPage.passwordFormControl.sendKeys("salesmanager" + Keys.ENTER);
    }

    @When("user log out")
    public void userClicksUserNameAndLogOut() {
        System.out.println(upgenixLoginPage.logOutStep2.toString());
        upgenixLoginPage.logOutStep1.click();
        upgenixLoginPage.logOutStep2.click();


    }


    @Then("user is redirected to home page")
    public void
    userIsRedirectedToHomePage() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("qa.upgenix.net"));

    }

    @When("user clicks userName and log out and user is redirected to home page")
    public void userClicksUserNameAndLogOutAndUserIsRedirectedToHomePage() {
    }

    @Then("user press step back button and user can not go to the home page again")
    public void userPressStepBackButtonAndUserCanNotGoToTheHomePageAgain() {
        Driver.getDriver().navigate().back();
        //check if Element present
        //boolean size = Driver.getDriver().findElements(By.xpath("//span[@class='oe_topbar_name']")).size() != 0;
        Assert.assertFalse(BrowserUtils.isDisplayedElementXpath(upgenixLoginPage.logOutStep1));
    }

    @When("User closes all tabs")
    public void userClosesAllTabs() {
        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            String pageTitle = Driver.getDriver().getTitle();
            if (pageTitle == null || pageTitle.trim().isEmpty()) {
                Driver.getDriver().switchTo().window(windowHandle).close();
            }

        }
    }

    @And("user navigates to home page again")
    public void userNavigatesToHomePageAgain() {
        Driver.getDriver().get("https://qa.upgenix.net/");

    }

    @Then("user has to be logged out")
    public void userHasToBeLoggedOut() {
        System.out.println(BrowserUtils.isDisplayedElementXpath(upgenixLoginPage.logOutStep1)? "True": "False");
        Assert.assertFalse(BrowserUtils.isDisplayedElementXpath(upgenixLoginPage.logOutStep1));
    }


}
