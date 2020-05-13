package pages;

import io.qameta.allure.Step;
import javafx.scene.input.InputMethodTextRun;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.Wait.waitUntilVisible;

@Log4j
public class LoginPage extends BasePage {

    @FindBy(xpath = "/html/body/div/main/div/div[3]/form/div[1]/div/div[2]/input")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/div/main/div/div[3]/form/div[2]/div/div[2]/input")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/div/main/div/div[3]/form/button")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/div[1]/main/div/div[3]/form/div[1]/div/div[3]/span")
    public WebElement errorMessage;

    @Step("Error message is displayed")
    public String getTextError() {
        waitUntilVisible(errorMessage);
        log.info("Error is displayed");
        return errorMessage.getText();
    }

    @Step("Input valid email: ")
    public void inputValidEmail() {
        waitUntilVisible(emailField);
        log.info("Email is visible");
        emailField.sendKeys("admin@admin.com");
        log.info("Email was entered");
    }

    @Step("Input valid password: ")
    public void inputValidPassword() {
        waitUntilVisible(passwordField);
        log.info("Password field is visible");
        passwordField.sendKeys("admin1234");
        log.info("Password was entered");
    }

    @Step("Input invalid password: ")
    public void inputInvalidPassword() {
        waitUntilVisible(passwordField);
        log.info("Password field is visible");
        passwordField.sendKeys("admin");
        log.info("Incorrect Password was entered");
    }

    @Step("Click on Login button ")
    public void clickLoginButton() {
        waitUntilVisible(loginButton);
        log.info("Login button is visible");
        loginButton.click();
        log.info("Login button is clicked");
    }
}
