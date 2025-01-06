import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import java.time.Duration;

public class SeleniumTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rushi\\Downloads\\softwareengineering\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("file:///C:/Users/rushi/Downloads/software%20engineering/index.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement inputA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("a")));
            WebElement inputB = driver.findElement(By.id("b"));
            WebElement inputC = driver.findElement(By.id("c"));

            inputA.sendKeys("-2");
            inputB.sendKeys("3");
            inputC.sendKeys("1");

            WebElement plotButton = driver.findElement(By.id("plot"));
            plotButton.click();

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();

            // Wait explicitly for the graph to be present and visible
            WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("graph")));
            System.out.println("Graph is now visible.");

            // Keep the browser open for 1 minute to observe the graph
            Thread.sleep(60000);

            if (graph.isDisplayed()) {
                System.out.println("Test Passed: Graph is displayed successfully!");
            } else {
                System.out.println("Test Failed: Graph is not displayed.");
            }

        } catch (TimeoutException e) {
            System.out.println("Element not found within the timeout period.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
