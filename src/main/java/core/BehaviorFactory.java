package core;

import behaviors.LoginBehavior;
import behaviors.InventoryBehavior;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BehaviorFactory {

    private LoginBehavior loginBehavior;
    private InventoryBehavior inventoryBehavior;

    public BehaviorFactory(RemoteWebDriver remoteDriver) {
        loginBehavior = new LoginBehavior(remoteDriver);
        inventoryBehavior = new InventoryBehavior(remoteDriver);
    }

    public LoginBehavior getLoginBehavior() {
        return loginBehavior;
    }

    public InventoryBehavior getInventoryBehavior() {
        return inventoryBehavior;
    }

}
