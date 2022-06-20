import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class HomePage {

    private WebDriver driver;
    private Actions actions;
    private String HomePageURL = "https://www.pragmaticplay.com/en#";
    private By agePopUp = By.id("game_pop");
    private By agePopUpConfirmation = By.className("top-btn");
    private By clientHubMenu = By.xpath("//*[@id=\"menu-item-23582\"]/a");
    private By homeMenu = By.xpath("//*[@id=\"menu-item-1185\"]/a");
    private By newsMenu = By.xpath("//*[@id=\"menu-item-9841\"]/a");
    private By contactMenu = By.xpath("//*[@id=\"menu-item-1820\"]/a");
    private By productsMenu = By.xpath("//*[@id=\"menu-item-200\"]/a");
    private By companyMenu = By.xpath("//*[@id=\"menu-item-57201\"]/a");
    private By bingoInProductList = By.xpath("//*[@id=\"menu-item-11081\"]/a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void OpenPage() {
        driver.get(HomePageURL);
        driver.manage().window().maximize();
    }

    public boolean AgePopUpIsVisible() {
        return driver.findElement(agePopUp).isEnabled();
    }

    public void AgePopUpConfirm() {
        if (AgePopUpIsVisible() == true) {
            driver.findElement(agePopUpConfirmation).click();
        }
    }

    public WebElement GetElementClientHubMenu() {
        return driver.findElement(clientHubMenu);
    }

    public WebElement GetElementNewsHome() {
        return driver.findElement(newsMenu);
    }

    public WebElement GetElementContactMenu() {
        return driver.findElement(contactMenu);
    }

    public WebElement GetElementHomeMenu() {
        return driver.findElement(homeMenu);
    }

    public WebElement GetElementProductsMenu() {
        return driver.findElement(productsMenu);
    }

    public WebElement GetElementCompanyMenu() {
        return driver.findElement(companyMenu);
    }

    public WebElement GetBingoInProductList() {
        return driver.findElement(bingoInProductList);
    }

    public void MouseoverElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }

    public boolean ElementColorChange(WebElement webElement) {
        boolean result;
        String colorBefore = webElement.getCssValue("color");
        MouseoverElement(webElement);
        String colorAfter = webElement.getCssValue("color");
        return colorAfter.equals(colorBefore);
    }
    public  BingoPage GoToBingoFromProductList(){
        MouseoverElement(GetElementProductsMenu());
        GetBingoInProductList().click();
        return new BingoPage(driver);
    }
}
