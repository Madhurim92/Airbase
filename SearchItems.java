import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Set;

public class SearchItems {
    public static void OpenWebAndSearch(WebDriver driver, String itemToBeSearched) throws InterruptedException {
        // Launch Website

        Set<String> s = driver.getWindowHandles();
        ArrayList winlist = new ArrayList<>(s);
        driver.switchTo().window((String)winlist.get(0));
        driver.manage().window();

        driver.get("https://www.amazon.in/");
        Thread.sleep(10000);
        verifyPage(driver);

        // Search tab
        WebElement searchtab = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchtab.sendKeys(itemToBeSearched);
        WebElement buttonSearch = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
        buttonSearch.click();
    }
    // Check if the page is loaded
    public static void verifyPage(WebDriver driver) {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        assert (!j.executeScript("return document.readyState").toString().equals("complete")) : "Error loading the page";

        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String title = driver.getTitle();
        assert (!title.equalsIgnoreCase(expectedTitle)) : "Page Title mismatch";

    }

    public static void selectBrand(WebDriver driver, String brand) throws InterruptedException {
        // Select Brand
        WebElement brandName = driver.findElement(By.xpath("//li[@aria-label='"+brand+"']//input"));
        WebElement i = driver.findElement(By.xpath("//li[@aria-label='"+brand+"']//i"));
        boolean test = brandName.isSelected();
        if(!test) {
            i.click();
        }
        Thread.sleep(2000);
    }
}
