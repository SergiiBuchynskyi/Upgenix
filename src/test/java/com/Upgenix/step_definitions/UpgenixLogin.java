package com.Upgenix.step_definitions;

import com.Upgenix.pages.BasePage;
import com.Upgenix.pages.UpgenixLoginPage;
import com.Upgenix.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpgenixLogin {

    UpgenixLoginPage upgenixLoginPage = new UpgenixLoginPage();
    int countFailedAccounts = 0;


    @When("user enters {string} and {string} in range of {int} to {int}")
    public void userEntersLoginAndPasswordInRangeOfStartToEnd(String login, String password, int start, int end) {
        for (int i = start; i <= end; i++) {
            upgenixLoginPage.loginFormControl.sendKeys(login + i + "@info.com");
            upgenixLoginPage.passwordFormControl.sendKeys(password);
            upgenixLoginPage.login.click();

            if (Driver.getDriver().getTitle().contains("Odoo")) {
                upgenixLoginPage.logOutStep1.click();
                upgenixLoginPage.logOutStep2.click();
            } else {
                System.out.println(login + i + "@info.com" + " - " + password + " is invalid credentials!");
                upgenixLoginPage.loginFormControl.clear();
                upgenixLoginPage.passwordFormControl.clear();
                countFailedAccounts++;
            }
        }

        System.out.println("Total accounts invalid: " + countFailedAccounts);
        Assert.assertEquals(0, countFailedAccounts);
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get("https://qa.upgenix.net/");
    }

    @When("User enter invalids credentials for SalesManager")
    public void userEnterInvalidsCredentialsForSalesManager() {
        upgenixLoginPage.loginFormControl.sendKeys("Invalid");
        upgenixLoginPage.passwordFormControl.sendKeys("Invalid");


    }


    @And("user clicks on the {string} button")
    public void userClickOnTheButton(String str) {
        BasePage.clickButton(str).click();
    }

    @Then("user see {string}")
    public void userSee(String exp) {
        String actual = upgenixLoginPage.alertMessage.getText();
        Assert.assertEquals(actual, exp);

    }

    @When("User leaves login field empty and enters password")
    public void userLeavesLoginFieldEmptyAndEntersPassword() {
        upgenixLoginPage.passwordFormControl.sendKeys("qwerty");
    }

    @When("User enter any password")
    public void userEnterAnyPassword() {
        upgenixLoginPage.passwordFormControl.sendKeys("qwerty");

    }

    @Then("User should see the password in bullet signs by default while typing like ****")
    public void userShouldSeeThePasswordInBulletSignsByDefaultWhileTypingLike() {
        String act = upgenixLoginPage.passwordFormControl.getAttribute("type");
        Assert.assertEquals("password", act);
    }

    @When("User enter valid credentials for SalesManager \\(e.g., username: {string}, password: {string})")
    public void userEnterValidCredentialsForSalesManagerEGUsernamePassword(String login, String password) {
        upgenixLoginPage.login.sendKeys(login);
        upgenixLoginPage.passwordFormControl.sendKeys(password);

    }

    @Then("user press ENTER after typing password")
    public void userPressENTERAfterTypingPassword() {
        upgenixLoginPage.passwordFormControl.sendKeys(Keys.ENTER);

    }

    @Then("user logins and redirected to home page")
    public void userLoginsAndRedirectedToHomePage() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("upgenix.net"));
    }

    @Then("user see {string}.")
    public void userSeePopUp(String exp) {
        // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));

        //String actual = upgenixLoginPage.loginFormControl.getAttribute("validationMessage");
        //String actual = Driver.getDriver().findElement(By.name("login")).getAttribute("validationMessage");
        //String actual = upgenixLoginPage.loginFormControl.getAttribute("validationMessage");
        //Alert alert = Driver.getDriver().switchTo().alert();

        // Get the text from the alert
        //String actual = alert.getText();
        //System.out.println(Driver.getDriver().getWindowHandles().toString());
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        //jsExecutor.executeScript("window.setTimeout(function() { alert('Popup message'); }, 3000);");
        //String actual = Driver.getDriver().switchTo().alert().getText();

        //Assert.assertEquals(actual, exp);

    }
}
