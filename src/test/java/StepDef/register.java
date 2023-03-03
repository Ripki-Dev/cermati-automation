package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class register {
    WebDriver driver;
    public static String URL = "https://www.cermati.com";
    public void openWeb(String path){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL+path);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void quitWeb(){
        driver.close();
        driver.quit();
    }
    @Given("User go to path {string}")
    public void userGoToPath(String path) {
        openWeb(path);
    }

    @Then("User validate in register page")
    public void userValidateInRegisterPage() {
//        driver.findElement(By.cssSelector("h1[class='header_2xOrt AppHeader_card__header-title__9bScY mx-auto text-color-gray-dark']")).isDisplayed();
        String get_txt = driver.findElement(By.cssSelector("div[class='AppHeader_card__hPYXS background-primary'] h1[class='header_2xOrt AppHeader_card__header-title__9bScY mx-auto text-color-gray-dark']")).getText();
        Assert.assertEquals("Daftar Akun", get_txt);
    }

    @Given("User fill email with {string}")
    public void userFillEmailWith(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("User fill No Handphone {string}")
    public void userFillNoHandphone(String hp) {
        driver.findElement(By.id("mobilePhone")).sendKeys(hp);
    }

    @And("User fill Kata Sandi {string}")
    public void userFillKataSandi(String pwd) {
        driver.findElement(By.id("password")).sendKeys(pwd);
    }

    @And("User fill ulangi kata sandi {string}")
    public void userFillUlangiKataSandi(String pwd) {
        driver.findElement(By.id("confirmPassword")).sendKeys(pwd);
    }

    @And("User fill Nama Depan {string}")
    public void userFillNamaDepan(String firstName) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    @And("User fill Nama Belakang {string}")
    public void userFillNamaBelakang(String lastName) {
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    @And("User fill Kota {string}")
    public void userFillKota(String city) {
        driver.findElement(By.id("cityAndProvince")).sendKeys(city, Keys.ENTER);
    }

    @When("User check persetujuan")
    public void userCheckPersetujuan() {
        boolean status = driver.findElement(By.id("terms-and-condition")).isSelected();
        System.out.println(status);
    }

    @Then("User click button Daftar")
    public void userClickButtonDaftar() {
        driver.findElement(By.cssSelector("button[class='btn_SGZcZ btn-track btn--action_kallT RegistrationForm_form-container__button__rqOgr']")).click();
        quitWeb();
    }
}
