package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header {

    @FindBy(how = How.XPATH, using = "//div/a[@class='account']")
    public WebElement user_name;


    @FindBy(how = How.CLASS_NAME, using = "login")
    public WebElement login;


    @FindBy(how = How.CLASS_NAME, using = "logout")
    public WebElement logout;


    @FindBy(how = How.LINK_TEXT, using = "Contact us")
    public WebElement contactUs;

    @FindBy(how = How.CLASS_NAME, using = "img-responsive")
    public WebElement saleImg;


    @FindBy(how = How.CLASS_NAME, using = "logo img-responsive")
    public WebElement logo;

    @FindBy(how = How.ID, using = "search_query_top")
    public WebElement txt_search;

    @FindBy(how = How.NAME, using = "submit_search")
    public WebElement btn_submitSearch;


    @FindBy(how = How.XPATH, using = "//div[@class='shopping_cart']/a")
    public WebElement cart;


    @FindBy(how = How.CLASS_NAME, using = "ajax_cart_block_remove_link")
    public WebElement btn_removeItem;


    @FindBy(how = How.ID, using = "button_order_cart")
    public WebElement btn_checkout;


    @FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']/ul/li[3]")
    public WebElement btn_Tshirts;

    @FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']/ul/li[2]")
    public WebElement btn_dresses;

    @FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']/ul/li[1]")
    public WebElement btn_Women;
}
