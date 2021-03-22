package sanity;


import extentions.UIActions;
import extentions.Verifications;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

public class PracticeSite extends CommonOps {

    @Test
    public void test01_verifyUserNameInHeader() {
        WebFlows.login("lorashamshoom@hotmail.com", "LORALORA");
        Verifications.verifyTextInElement(header.user_name, "lora shamshoom");
    }

    @Test
    public void test02_verifyLogout() {
        test01_verifyUserNameInHeader();
        WebFlows.logout();
        Verifications.verifyElementIsNotExist(header.user_name);
    }

    @Test
    public void test03_verifyTshirtsButton() {
        UIActions.click(header.btn_Tshirts);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='page-heading product-listing']/span[1]")).getText(), "T-SHIRTS ");

    }

    @Test
    public void test03_verifyDressesButton() {
        UIActions.click(header.btn_dresses);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='page-heading product-listing']/span[1]")).getText(), "DRESSES ");

    }

    @Test
    public void test03_verifyWomenButton() {
        UIActions.click(header.btn_Women);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='page-heading product-listing']/span[1]")).getText(), "WOMEN ");

    }

    @Test
    public void test04_verifySubscribe() {
        // this email should be change to a new email every time we run the test
        WebFlows.registToSubscribe("kkkkk@gmail.com");
        Verifications.verifyElementIsExist(footer.txt_alert);
        Verifications.verifyTextInElement(footer.txt_alert, "Newsletter : You have successfully subscribed to this newsletter.");
        Verifications.verifyTextInValue(footer.txt_emailToSubscribe,"You have successfully subscribed to this newsletter.");


    }

    @Test
    public void test04_verifyRepeatedSubscribe() {
        WebFlows.registToSubscribe("loras@gmail.com");
        Verifications.verifyElementIsExist(footer.txt_alert);
        Verifications.verifyTextInValue(footer.txt_emailToSubscribe,"This email address is already registered.");
        Verifications.verifyTextInElement(footer.txt_alert, "Newsletter : This email address is already registered.");
    }


}
