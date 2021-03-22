package workflows;

import extentions.UIActions;
import page.objects.Header;
import utilities.CommonOps;

public class WebFlows extends CommonOps {

    public static void login(String mail, String pass) {
        UIActions.click(header.login);
        UIActions.updateText(signin.txt_registeredUserEmail, mail);
        UIActions.updateText(signin.txt_registeredUserPassword, pass);
        UIActions.click(signin.btn_loginSubmit);
    }

    public static void logout() {
        UIActions.click(header.logout);
    }

    public static void registToSubscribe(String email) {
        UIActions.updateText(footer.txt_emailToSubscribe, email);
        UIActions.click(footer.btn_emailToSubscribe);
    }

}
