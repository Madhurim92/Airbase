import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filter {
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
        WebElement sortBy = driver.findElement(By.xpath("//span[normalize-space()='Featured']"));
        sortBy.click();
        WebElement highToLow = driver.findElement(By.xpath("//a[@id='s-result-sort-select_2']"));
        highToLow.click();
        checkPriceRange(driver, Integer.parseInt(minValue), Integer.parseInt(maxValue));
    }


    public static void checkPriceRange(WebDriver driver, Integer minValue, Integer maxValue) {
        // Check the price range of the elements

        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        ArrayList<Integer> listOfPrices = new ArrayList<>();
        for(int ii=0; ii<priceList.size(); ii++){
            int prices =  Integer.parseInt(priceList.get(ii).getText().replaceAll(",",""));
            listOfPrices.add(prices);
        }
        assert(!((Collections.max(listOfPrices) > minValue && Collections.max(listOfPrices) < maxValue) && (Collections.min(listOfPrices) > minValue && (Collections.min(listOfPrices) < maxValue)))) : "Prices displayed are not in the range";
    }

}
