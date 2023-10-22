package sauceDemo.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class all {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("On the login page sauceDemo")
    public void on_the_login_page_sauce_demo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("user input a registered username")
    public void user_input_a_registered_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input a registered password")
    public void user_input_a_registered_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @Then("user is on the dashboard product page")
    public void user_is_on_the_dashboard_product_page() {
        driver.findElement(By.xpath("//*[@id='inventory_sidebar_link']"));
        String username = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(username,"Products");
        driver.close();
    }

    @And("user input unregistered password")
    public void input_unregistered_password() {
        driver.findElement(By.id("password")).sendKeys("12345");
    }

    @Then("user get an error message")
    public void user_get_an_error_message() {
        String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @When("I input (.*) as username$")
    public void user_input_tdd_selenium_gmail_com_as_email(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("I input (.*) as password$")
    public void user_input_tdd_selenium_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click login button")
    public void i_click_login_button() {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @Then("I verify (.*) login result$")
    public void user_verify_success_login_result(String status) {
        if(status.equals("success")){ //Assert success login
            driver.findElement(By.xpath("//*[@id='inventory_sidebar_link']"));
            String username = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
            Assert.assertEquals(username,"Products");
        } else {
            // Assert error message
            String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
            Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");
        }
        driver.close();
    }

    @And("user click Add to cart button on the product")
    public void user_click_Add_to_cart_button_on_the_product() {
        WebElement addProductButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addProductButton.click();
    }

    @And("user click Cart icon on the top right")
    public void user_click_Cart_icon_on_the_top_right() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
    }

    @And("click button Checkout")
    public void clickButtonCheckout() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @And("I click button Checkout to redirect fill the shipping information data")
    public void I_click_button_Checkout_to_redirect_fill_the_shipping_information_data() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @Then("user redirect to Your Cart product added")
    public void user_redirect_to_Your_Cart_product_added() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
        driver.close();
    }

    @And("I input (.*) as first name$")
    public void iInputFirstNameAsFirstName(String firstname) {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
    }

    @And("I input (.*) as last name$")
    public void iInputLastNameAsLastName(String lastname) {
        driver.findElement(By.id("last-name")).sendKeys(lastname);
    }

    @And("I input (.*) as zip code$")
    public void iInputPostalCodeAsZipCode(String zipcode) {
        driver.findElement(By.id("postal-code")).sendKeys(zipcode);
    }

    @And("click Continue button")
    public void clickContinueButton() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @And("I click Finish button")
    public void iClickFinishButton() {
        driver.findElement(By.xpath("//*[@id='finish']")).click();
    }

    @Then("I verify (.*) redirect to complete Checkout page$")
    public void iVerifyStatusRedirectToCompleteCheckoutPage(String status) {

        if (status.equals("success")){
            WebElement checkoutCompletePage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
            Assert.assertTrue("Checkout: Complete!", checkoutCompletePage.isDisplayed());
            driver.close();

        }
    }

    @And("I click Continue button without fill the form")
    public void I_click_Continue_button_without_fill_the_form() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @Then("I verify failed to checkout product with warning message appear")
    public void I_verify_failed_to_checkout_product_with_warning_message_appear() {
        WebElement errorMessageForm = driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3"));
        Assert.assertTrue("Error: First Name is required", errorMessageForm.isDisplayed());
        driver.close();

    }

    @And("click sidebar menu on the top left")
    public void click_sidebar_menu_on_the_top_left() {
        WebElement clickBurger = driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']"));
        clickBurger.click();
    }

    @And("click Menu Logout")
    public void clickMenuLogout() {
        WebElement clickLogout = driver.findElement(By.xpath("//*[@id='logout_sidebar_link']"));
        clickLogout.click();
    }

    @Then("user back to login page sauceDemo")
    public void userBackToLoginPageSauceDemo() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        driver.close();
    }

    @Then("I verify (.*) logout result redirect to login page sauceDemo$")
    public void iVerifyStatusLogoutResultRedirectToLoginPageSauceDemo(String status) {
        if (status.equals("success")){ //Assert success login
            String loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
            Assert.assertEquals(loginPageAssert, "Swag Labs");
            driver.close();
        }
    }

}
