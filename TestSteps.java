package StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps {
    WebDriver driver;
     @Given ("Launch the url")
     public void launch_the_url() {
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
     }
        
        @When ("^user enter the \"(.*)\" and \"(.*)\"valid credentials$") 
        public void valid_credentials(String user,String password) {
            driver.findElement(By.id("username")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i")).click();
        }
       
        @Then ("user is redirected to the profile page")
        public void redirects_page() throws InterruptedException {
            Thread.sleep(2000);
            System.out.println(driver.getTitle());
        }
        /*@When ("user enter the invalid credentials")
          public void invalid_credentials() {
            //driver.findElement(By.id("username")).sendKeys("tosmith");
            driver.findElement(By.id("password")).sendKeys("SupeSecretPassword!");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i")).click();
        }
        
        @Then ("user desplay an error message")
        public void error_message() throws InterruptedException {
            Thread.sleep(2000);
            String message=driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
            System.out.println(message);
        }*/
}