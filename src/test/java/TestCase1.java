import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        
        
        WebDriver driver = new ChromeDriver();
        
        
        driver.get("https://magento.softwaretestingboard.com/");
        
        
        driver.findElement(By.xpath("//span[text()='Men']")).click();
        driver.findElement(By.xpath("//a[text()='Tops']")).click();
        driver.findElement(By.xpath("//a[text()='Tees']")).click();

        
        driver.findElement(By.xpath("//a[@id='ui-id-21']//span[contains(text(),'Tees')] ")).click();

        
        driver.findElement(By.xpath("(//a[@class='product-item-link'])[1]")).click();
        driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();  
       
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();  
        
        WebElement cartTotal = driver.findElement(By.xpath("//span[@class='price']"));
        System.out.println("Total price in the cart: " + cartTotal.getText());  
        
       
        driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();

        
        driver.quit();
    }
}
