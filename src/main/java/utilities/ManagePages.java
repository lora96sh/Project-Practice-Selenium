package utilities;

import org.openqa.selenium.support.PageFactory;
import page.objects.Signin;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

public class ManagePages extends Base {

    public static void initObjects() {
        signin = PageFactory.initElements(driver, page.objects.Signin.class);
        header = PageFactory.initElements(driver, page.objects.Header.class);
        footer = PageFactory.initElements(driver, page.objects.Footer.class);
    }


}
