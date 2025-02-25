import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); 
        WebDriver driver = new ChromeDriver();

        try {
            
            driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

           
            WebElement bankManagerLoginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
            bankManagerLoginButton.click();

            
            WebElement customersButton = driver.findElement(By.xpath("//button[@ng-click='showCustomers()']"));
            customersButton.click();

           
            boolean isFirstNameColumnPresent = driver.findElement(By.xpath("//th[contains(text(), 'First Name')]")).isDisplayed();
            boolean isLastNameColumnPresent = driver.findElement(By.xpath("//th[contains(text(), 'Last Name')]")).isDisplayed();
            boolean isPostCodeColumnPresent = driver.findElement(By.xpath("//th[contains(text(), 'Post Code')]")).isDisplayed();
            boolean isAccountNumberColumnPresent = driver.findElement(By.xpath("//th[contains(text(), 'Account Number')]")).isDisplayed();
            boolean isDeleteCustomerColumnPresent = driver.findElement(By.xpath("//th[contains(text(), 'Delete Customer')]")).isDisplayed();

            if (isFirstNameColumnPresent && isLastNameColumnPresent && isPostCodeColumnPresent &&
                isAccountNumberColumnPresent && isDeleteCustomerColumnPresent) {
                System.out.println("All expected columns are present.");
            } else {
                System.out.println("Some columns are missing.");
            }

            
            WebElement deleteButton = driver.findElement(By.xpath("//td[contains(text(), 'Ron')]//following-sibling::td[contains(text(), 'Weasley')]//following-sibling::td//button"));
            deleteButton.click();

           
            boolean isRonWeasleyDeleted = driver.findElements(By.xpath("//td[contains(text(), 'Ron')]//following-sibling::td[contains(text(), 'Weasley')]")).isEmpty();

            if (isRonWeasleyDeleted) {
                System.out.println("Ron Weasley has been successfully deleted.");
            } else {
                System.out.println("Ron Weasley is still present in the customer list.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            driver.quit();
        }
    }
}
