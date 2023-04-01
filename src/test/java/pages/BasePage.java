package pages;

import config.browser_factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
    /*
     * Method to wait until a specific element by id appears
     */
    public static void waitElementBy(By by, int time) throws Exception {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntilElementPresence(By by, int time) throws Exception {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static int wait(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (Exception e) {
            System.err.println("Fail while trying to use wait method");
        }
        return miliseconds;
    }
    public static boolean checkBoxIsActive(By by) throws Exception {
        return DriverFactory.getDriver().findElement(by).isSelected();
    }
    public static boolean verifyIfElementsIsVisible(By by)throws Exception{
        Boolean isPresent = DriverFactory.getDriver().findElements(by).size() > 0;
        return isPresent;
    }
    /*
     * Method to save elements in a list
     */
    public static List<WebElement> findElements(By by) throws Exception {
        return DriverFactory.getDriver().findElements(by);
    }
    public static void clearField(By by) throws Exception {
        DriverFactory.getDriver().findElement(by).clear();
    }
    public static void switchToIFrame(String id)throws Exception{
        DriverFactory.getDriver().switchTo().frame(id);
    }
    public static void switchToDefaultContent()throws Exception{
        DriverFactory.getDriver().switchTo().defaultContent();
    }
    /*
     * Method to get current date time from America/New_York
     */
    public static String currentDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/New_York"));
        return dtf.format(now);
    }
    public static String currentDateTimeWithoutHour(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/New_York"));
        return dtf.format(now);
    }

    /*
     * Method to scroll until element is visible
     */
    public static void scrollToElement(By by) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        WebElement element = DriverFactory.getDriver().findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void scrollTo(String pixels) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("window.scrollBy(0,"+pixels+")", "");
    }

    public static void scrollToTheBottom() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public static void scrollToTheTop() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }
}
