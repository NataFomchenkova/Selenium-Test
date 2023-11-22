package core;

import org.openqa.selenium.chrome.ChromeDriver;

abstract public class BasePage {
    protected static ChromeDriver driver;

    public static void setDriver(ChromeDriver webDriver) {
        driver = webDriver;
    }
}
