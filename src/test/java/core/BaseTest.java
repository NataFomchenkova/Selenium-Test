package core;

import core.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
    protected ChromeDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BasePage.setDriver(driver);
        //System.out.println("Before");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
        //System.out.println("After");
    }
}

