package behaviors;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.InventoryPage;

public class InventoryBehavior {

    private InventoryPage inventoryPage;

    public InventoryBehavior(RemoteWebDriver remoteDriver) {
        inventoryPage = new InventoryPage(remoteDriver);
    }

    public Boolean isInventoryPageVisible() {
        return inventoryPage.isInventoryContainerVisible();
    }

    public Integer getNumberOfItems() {
     return inventoryPage.getNumberOfItems();
    }

}
