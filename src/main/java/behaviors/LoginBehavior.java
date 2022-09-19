package behaviors;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.LoginPage;

public class LoginBehavior {

    private LoginPage loginPage;

    public LoginBehavior(RemoteWebDriver remoteDriver) {
        loginPage = new LoginPage(remoteDriver);
    }

    public void loginWithGivenUserPass(String user, String pass) {
        loginPage.setUsername(user);
        loginPage.setPassword(pass);
        loginPage.clickSubmitButton();
    }

}
