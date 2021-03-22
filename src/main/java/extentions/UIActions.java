package extentions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class UIActions extends CommonOps {


    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    public static void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(text);
    }

    public static void updateDropDown(WebElement elem, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));

        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }
    public static void mouseHover(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));

    action.moveToElement(elem).build().perform();
    }

}
