import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestCase4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String customerId = alertText.replaceAll("[^0-9]", "");
        alert.accept();
        driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search Customer']"));
        searchBox.sendKeys("John");
        boolean isCustomerDisplayed = driver.findElements(By.xpath("//td[contains(text(),'John') and following-sibling::td[contains(text(),'Doe')]]")).size() > 0;
        if (isCustomerDisplayed) {
            System.out.println("Newly added customer is displayed in the list.");
        }
        driver.quit();
    }
}