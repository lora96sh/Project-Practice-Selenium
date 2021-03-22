package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Footer {


    @FindBy(how = How.ID, using = "newsletter-input")
    public WebElement txt_emailToSubscribe;

    @FindBy(how = How.NAME, using = "submitNewsletter")
    public WebElement btn_emailToSubscribe;

    @FindBy(how = How.XPATH, using = "//div[@id='columns']/p")
    public WebElement txt_alert;



//    This email address is already registered.
//    //div[@id="columns"]/p (alert)

}
