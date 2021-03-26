package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import page.objects.Footer;
import page.objects.Header;
import page.objects.Signin;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAsser;

    //page objects
    protected static Signin signin;
    protected static Header header;
    protected static Footer footer;
}
