import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TestCase2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()='Women']" )).click();
        driver.findElement(By.xpath("//a[text()='Jackets']" )).click();
        List<WebElement> products = driver.findElements(By.xpath("//li[contains(@class,'product-item')]"));
        System.out.println("Total products displayed: " + products.size());
        double totalPrice = 0;
        for (WebElement product : products) {
            String productName = product.findElement(By.cssSelector(".product-item-link")).getText();
            String productPrice = product.findElement(By.cssSelector(".price-wrapper .price")).getText().replace("$", "");
            double price = Double.parseDouble(productPrice);
            totalPrice += price;
            System.out.println("Product: " + productName + ", Price: " + price);
        }
        System.out.println("Total sum of all product prices: " + totalPrice);
        driver.quit();
    }
}