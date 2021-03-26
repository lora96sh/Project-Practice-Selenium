package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }


    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = initFirefoxDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            driver = initIEDriver();

        } else throw new RuntimeException();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        driver.get(getData("url"));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initObjects();
        action = new Actions(driver);
        softAsser = new SoftAssert();
    }
public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
}
    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }



    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;

    }


    @BeforeClass
    public void startSession() {
        if (getData("PlatformName").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
//        else if(getData("PlatformName").equalsIgnoreCase("mobile"))
//            initMobile();
        else
            throw new RuntimeException();
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }

    @AfterMethod
    public void afterMethod() {
        driver.get(getData("url"));
    }

}