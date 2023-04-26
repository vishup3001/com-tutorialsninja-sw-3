package Utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method is use to click on any element
     *
     * @param by
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method is use to send value on any element
     *
     * @param by
     * @param text
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method is used to get text from any element
     *
     * @param by
     * @return
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method is used to get attributive of value
     *
     * @param by
     * @return
     */
    public String getAttributeValueFromElement(By by) {
        return driver.findElement(by).getAttribute("value");
    }

    /**
     * This method is used to verify to element
     *
     * @param firstText
     * @param secondText
     */
    public void verifyTwoTextMessage(String firstText, String secondText) {

        Assert.assertEquals(firstText, secondText);
    }

    /**
     * This method is used to verify to element
     *
     * @param firstText
     * @param secondText
     */
    public void verifyTwoTextMessage(int firstText, int secondText) {

        Assert.assertEquals(firstText, secondText);
    }

    /**
     * This method is used to  select value from drop down
     *
     * @param by
     * @param text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);
    }

    /**
     * This method is used to  select radio button
     *
     * @param by
     */
    public void selectRadioButton(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method is used to select CheckBox
     *
     * @param by
     */
    public void selectCheckBox(By by) {

        WebElement checkBox = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox);
        actions.perform();
        if (checkBox.isSelected()) {

        } else {
            checkBox.click();
        }
    }

    /**
     * This method is used to mouseHover and click
     *
     * @param by
     * @throws InterruptedException
     */
    public void mouseHoverAndClick(By by) throws InterruptedException {
        WebElement desktops = driver.findElement(by);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(desktops).click().build().perform();
    }

    /**
     * This method is used to mouseHover
     *
     * @param by
     * @throws InterruptedException
     */
    public void mouseHover(By by) throws InterruptedException {
        WebElement desktops = driver.findElement(by);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(desktops).build().perform();
    }
}
