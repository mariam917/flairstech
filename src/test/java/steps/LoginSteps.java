package steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OrangeHRMLogin;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {
    WebDriver driver;
    OrangeHRMLogin loginPage;

    @Given("I open the OrangeHRM login page")
    public void openLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new OrangeHRMLogin(driver);
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void verifyLogin() {
        assertTrue(loginPage.isDashboardDisplayed(), "Dashboard should be displayed after login");
        driver.quit();
    }
}
