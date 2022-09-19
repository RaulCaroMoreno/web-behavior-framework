package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(name = "login-button")
    WebElement submitButton;

    public LoginPage(RemoteWebDriver remoteDriver) {
        super(remoteDriver);
    }

    public void setUsername(String user) {
        sendContent(username, user);
    }

    public void setPassword(String user) {
        sendContent(password, user);
    }

    public void clickSubmitButton( ){
        click(submitButton);
    }

}
