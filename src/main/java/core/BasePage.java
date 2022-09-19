package core;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {

    public static final Integer POLLING_TIME = 2500;
    public static final Integer TIME_OUT = 50000;
    private RemoteWebDriver remoteWebDriver;

    public BasePage(RemoteWebDriver remoteDriver) {
        remoteWebDriver = remoteDriver;
        PageFactory.initElements(remoteWebDriver, this);
    }

    private void fluentWaitSelenium(Function fun, long pollingTime, long timeOut) {
        FluentWait fluent = new FluentWait(remoteWebDriver);
        fluent.ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofMillis(pollingTime))
                .withTimeout(Duration.ofMillis(timeOut))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        fluent.until(fun);
    }

    protected void click(WebElement element) {
        fluentWaitSelenium(ExpectedConditions.visibilityOf(element), POLLING_TIME, TIME_OUT);
        element.click();
    }

    protected void sendContent(WebElement element, String content) {
        fluentWaitSelenium(ExpectedConditions.visibilityOf(element), POLLING_TIME, TIME_OUT);
        element.sendKeys(content);
    }


    protected Boolean checkVisibilityOfElement(WebElement element) {
        Boolean elementIsPresent = true;
        try{
            fluentWaitSelenium(ExpectedConditions.visibilityOf(element), POLLING_TIME, TIME_OUT);
        } catch(NoSuchElementException exception) {
            elementIsPresent = false;
        }
        return elementIsPresent & element.isDisplayed();
    }




}
