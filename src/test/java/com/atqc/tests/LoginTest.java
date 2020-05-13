package com.atqc.tests;

import framework.AllureListener;
import framework.DriverActions;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProcessPage;

import static org.testng.Assert.assertEquals;

@Epic("Authorization")
@Feature("Login")
@Listeners(AllureListener.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;

/*    @Test(enabled = false)
    @Story("US-3 As organization admin I want to log in to the system so that I can use system")
    @TmsLink("25363")
    @Description("Test for login")
    @Issue("WO-77")
    public void openLoginPage() {

        DriverActions.open("https://test.app.workoptima.com/");
        loginPage = new LoginPage();
        loginPage.inputValidEmail();
        loginPage.inputValidPassword();
        loginPage.clickLoginButton();
        ProcessPage processPage = loginPage.clickLoginButton();
        Assert.assertEquals(ProcessPage.logoutButtonPresented(), "Title");
    }
*/
    @Test
    @Story("US-3 As organization admin I want to log in to the system so that I can use system")
    @TmsLink("WO-77")
    @Description("Test for error")
    public void openLoginPage() {

    DriverActions.open("https://test.app.workoptima.com/");
    loginPage = new LoginPage();
    loginPage.inputValidEmail();
    loginPage.inputInvalidPassword();
    loginPage.clickLoginButton();
    assertEquals(loginPage.getTextError(), "Email or Password is not correct");
}
}