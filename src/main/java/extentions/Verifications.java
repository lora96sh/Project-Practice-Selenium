package extentions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class Verifications extends CommonOps {


    public static void verifyTextInElement(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));

        assertEquals(elem.getText(), text);
    }
    public static void verifyTextInValue(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));

        assertEquals(elem.getAttribute("value"), text);
    }

    public static void numberOfElements(List<WebElement> elems, int number) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(),number);
    }

    public static boolean verifyElementIsNotExist(WebElement elem) {
        try {
            wait.until(ExpectedConditions.visibilityOf(elem));
            return false;
        } catch (TimeoutException e) {
            return true;
        }
    }
    public static boolean verifyElementIsExist(WebElement elem) {
        try {
            wait.until(ExpectedConditions.visibilityOf(elem));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}