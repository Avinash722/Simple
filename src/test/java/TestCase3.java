import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestCase3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
        boolean areColumnsPresent = driver.findElements(By.xpath("//tr/th[contains(text(),'First Name') or contains(text(),'Last Name') or contains(text(),'Post Code') or contains(text(),'Account Number') or contains(text(),'Delete Customer')]")).size() == 5;
        if (areColumnsPresent) {
            System.out.println("All required columns are present.");
        }
        WebElement deleteButton = driver.findElement(By.xpath("//td[contains(text(),'Ron')]/following-sibling::td[contains(text(),'Weasly')]/following-sibling::td/button"));
        deleteButton.click();
        boolean isCustomerDeleted = driver.findElements(By.xpath("//td[contains(text(),'Ron') and following-sibling::td[contains(text(),'Weasly')]]")).size() == 0;
        if (isCustomerDeleted) {
            System.out.println("Customer Ron Weasly is deleted.");
        }
        driver.quit();
    }
}
