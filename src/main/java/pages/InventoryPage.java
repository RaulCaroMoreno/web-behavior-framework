package pages;

import core.BasePage;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    public InventoryPage(RemoteWebDriver remoteWebDriver) {
        super(remoteWebDriver);
    }

    @FindBy(id = "inventory_container")
    WebElement inventoryContainer;

    @FindBy(xpath = "//div[@id='inventory_container']//div[@class='inventory_item']")
    List<WebElement> allInventoryItems;

    public Boolean isInventoryContainerVisible() {
        return checkVisibilityOfElement(inventoryContainer);
    }

    public Integer getNumberOfItems() {
        return allInventoryItems.size();
    }
}
