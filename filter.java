import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class filter {
    public static void priceRange(WebDriver driver, String minValue, String maxValue) {

        // Give price range
        WebElement minPrice = driver.findElement(By.xpath("//input[@id='low-price']"));
        minPrice.sendKeys(minValue);
        WebElement maxPrice = driver.findElement(By.xpath("//input[@id='high-price']"));
        maxPrice.sendKeys(maxValue);
        //Click on the Go button
        WebElement gobutton = driver.findElement(By.xpath("//input[@class=\"a-button-input\"]"));
        gobutton.click();

        // Sort the prices
        //WebElement sortBy = driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']"));
        //WebElement sortBy = driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
        WebElement sortBy = driver.findElement(By.xpath("//span[normalize-space()='Featured']"));
        sortBy.click();
        WebElement highToLow = driver.findElement(By.xpath("//a[@id='s-result-sort-select_2']"));
        highToLow.click();
        checkPriceRange(driver);
    }


    public static void checkPriceRange(WebDriver driver) {
        // Check the price range of the elements

        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        ArrayList<Integer> listOfPrices = new ArrayList<>();
        for(int ii=0; ii<priceList.size(); ii++){
            int prices =  Integer.parseInt(priceList.get(ii).getText().replaceAll(",",""));
            listOfPrices.add(prices);
        }
        assert(!((Collections.max(listOfPrices) > 1000 && Collections.max(listOfPrices) < 5000) && (Collections.min(listOfPrices) > 1000 && (Collections.min(listOfPrices) < 5000)))) : "Prices displayed are not in the range";
 /*
        if ((Collections.max(listOfPrices) > 1000 && Collections.max(listOfPrices) < 5000) && (Collections.min(listOfPrices) > 1000 && (Collections.min(listOfPrices) < 5000))) {
            System.out.println("Prices displayed are within the range");
        }
        else {
            System.out.println("Prices displayed are not within the  range");
        }
   */
    }

}
