import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Set;

public class AddToCart {
    public static void addToCartandVerify(WebDriver driver) throws InterruptedException {
        // Open the 1st element
        WebElement item = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        item.click();

        // Window Handler for the next 
        Set<String> s = driver.getWindowHandles();
        ArrayList winlist = new ArrayList<>(s);
        driver.switchTo().window((String)winlist.get(1));

        String productname = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println("ProductPage " + productname);
        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addToCart.click();
        Thread.sleep(2000);

        // Go to the cart page
        WebElement closePop = driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']"));
        closePop.click();
        WebElement cartPage = driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
        cartPage.click();
        String cartname = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base sc-product-title sc-grid-item-product-title']")).getText();

        System.out.println("CartName " + cartname);
        assert (!productname.equalsIgnoreCase(cartname)) : "Add to cart failed";

        driver.close();
    }

}
