package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Signin {

    @FindBy(how = How.ID, using = "email")
    public WebElement txt_registeredUserEmail;


    @FindBy(how = How.ID, using = "passwd")
    public WebElement txt_registeredUserPassword;


    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement btn_loginSubmit;

    @FindBy(how = How.ID, using = "email_create")
    public WebElement txt_emailCreate;

    @FindBy(how = How.ID, using = "SubmitCreate")
    public WebElement BTN_SubmitCreate;

}


