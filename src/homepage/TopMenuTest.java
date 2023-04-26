package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        // close all windows
        closeBrowser();
    }

    /**
     * This method is used to select menu
     * @param menu
     */
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//nav[@id='menu']//a[normalize-space()='" + menu + "']"));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        String menuName = "Show AllDesktops";
        // Mouse hover on “Desktops” Tab and click
        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        // call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu(menuName);
        String expectedMessage = "Desktops";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']"));
        // Verify the text ‘Desktops’
        verifyTwoTextMessage(expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        // Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu(menuName);

        String expectedMessage = "Laptops & Notebooks";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        // Verify the text ‘Laptops & Notebooks’
        verifyTwoTextMessage(expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        String menuName = "Show AllComponents";
        // Mouse hover on “Components” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Components']"));
        // call selectMenu method and pass the menu = “Show All Components”
        selectMenu(menuName);

        String expectedMessage = "Components";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Components']"));
        // Verify the text ‘Components’
        verifyTwoTextMessage(expectedMessage, actualMessage);

    }


}
