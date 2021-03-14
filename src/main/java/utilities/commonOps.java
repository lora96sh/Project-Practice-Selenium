package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class commonOps extends Base {

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = initFirefoxDriver();

        } else if (browserType.equalsIgnoreCase("ie")) {
            driver = initIEDriver();

        } else throw new RuntimeException();
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/");
        return driver;

    }


    @BeforeClass
    public void startSession() {
        //this variable will be deleted when starting develop for mobile
        String platform = "web";
        if (platform.equalsIgnoreCase("web"))
            initBrowser("chrome");
        else
            throw new RuntimeException();
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }
}
