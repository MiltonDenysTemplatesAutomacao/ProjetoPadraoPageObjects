package pages;

import config.browser_factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * This file contains the BasePage class, which is used as a base page for other page classes.
 * It provides helpful methods for interacting with page elements, such as clicking buttons and inserting text into input fields.
 */

public class BasePage {

    protected static List<WebElement> listOfElements;

    public static void write(By by, String text) throws Exception {
        DriverFactory.getDriver().findElement(by).clear();
        DriverFactory.getDriver().findElement(by).sendKeys(text);
    }
    public static void click(By by) throws Exception{
        DriverFactory.getDriver().findElement(by).click();
    }

    // Get the list of elements with the specified tag inside the element specified by the "by" selector
    public static List<WebElement> elementsList(By by, String tag) throws Exception {
        WebElement table = DriverFactory.getDriver().findElement(by);
        return table.findElements(By.tagName(tag));
    }
    public static void scrollToElement(By by) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        WebElement element = DriverFactory.getDriver().findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static String getText(By by) throws Exception {
        return DriverFactory.getDriver().findElement(by).getText();
    }

    /*
     * Method to select an element from a list by css and tag
     */
    public static void selectElementsList(By by, String tag) throws Exception {
        listOfElements = elementsList(by, tag);
    }
    public static void clickOnListOfElements(String value) throws Exception {
        for (int i = 0; i < listOfElements.size(); i++) {
            if (listOfElements.get(i).getText().equals(value)) {
                listOfElements.get(i).click();
                break;
            }
        }
    }
    public static void waitUntilElementToBeSelected(By by, int time) throws Exception {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
