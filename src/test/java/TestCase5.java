import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestCase5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://computer-database.gatling.io/computers?p=0&s=companyName&d=desc");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement filterBox = driver.findElement(By.id("searchbox"));
        filterBox.click();
        String tooltipText = filterBox.getAttribute("validationMessage");
        if (tooltipText.equals("Please fill out this field.")) {
            System.out.println("Tooltip message verified.");
        }
        driver.findElement(By.id("add")).click();
        
        driver.findElement(By.id("name")).sendKeys("Test Computer");
        
        driver.findElement(By.id("introduced")).sendKeys("2024-02-25");
        driver.findElement(By.id("discontinued")).sendKeys("2025-02-25");
        WebElement companyDropdown = driver.findElement(By.id("company"));
        companyDropdown.findElement(By.xpath("//option[@value='1']")).click();
        driver.findElement(By.cssSelector("input.btn.primary")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Test Computer')]")));
        System.out.println("pass.");
        boolean isComputerDisplayed = driver.findElements(By.xpath("//a[contains(text(),'Test Computer')]")).size() > 0;
        if (isComputerDisplayed) {
            System.out.println("Newly created computer is displayed in the listing page.");
        }
        driver.quit();
    }
}