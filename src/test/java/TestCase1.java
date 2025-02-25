import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestCase1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement menMenu = driver.findElement(By.xpath("//span[text()='Men']"));
        actions.moveToElement(menMenu).perform();
        
        WebElement top= driver.findElement(By.xpath("(//span[contains(text(),'Tops')])[1]"));
        actions.moveToElement(top).perform();
        
        System.out.println("pass");
        
        
        driver.findElement(By.xpath("(//span[contains(text(),'Tees')])[2]")).click();
        driver.findElement(By.xpath("//div[@aria-label='Black']//input")).click();
        List<WebElement> products = driver.findElements(By.xpath("//li[contains(@class,'product-item')]"));
        double totalPrice = 0;
        for (int i = 0; i < 3; i++) {
            WebElement product = products.get(i);
            String productPrice = product.findElement(By.cssSelector(".price-wrapper .price")).getText().replace("$", "");
            double price = Double.parseDouble(productPrice);
            totalPrice += price;
            product.findElement(By.cssSelector(".tocart")).click();
        }
        driver.findElement(By.xpath("//a[contains(@class,'showcart')]")).click();
        WebElement totalElement = driver.findElement(By.cssSelector(".grand.totals .price"));
        double displayedTotal = Double.parseDouble(totalElement.getText().replace("$", ""));
        if (displayedTotal == totalPrice) {
            System.out.println("Total price verified.");
        }
        driver.findElement(By.xpath("//button[contains(text(),'Proceed to Checkout')]")).click();
        driver.quit();
    }
}