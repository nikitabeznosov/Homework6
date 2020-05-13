package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.Wait.waitUntilVisible;

@Log4j
public class ProcessPage extends BasePage {

    @FindBy(xpath = "/html/body/div/main/div/header/button")
    private static WebElement logoutButton;

    @Step("Check logout button ")
    public static void logoutButtonPresented() {
        waitUntilVisible(logoutButton);
        log.info("Logout button is visible");
    }
}