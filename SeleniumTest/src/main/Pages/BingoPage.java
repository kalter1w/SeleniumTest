import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;


    public class BingoPage {

        private WebDriver driver;
        private Actions actions;
        private By bingoVariants = By.xpath("/html/body/div[2]/section/div[2]/div[2]/div[1]");
        private By sliderArrowRight = By.className("right-arrow");

        private  String BingoPageURL = "https://www.pragmaticplay.com/en/bingo/";
        public void OpenPage() {
            driver.get(BingoPageURL);
            driver.manage().window().maximize();
        }
        public BingoPage(WebDriver driver) {
            this.driver = driver;
            this.actions = new Actions(driver);
        }
        public WebElement GetBingoVariants()
        {
            return driver.findElement(bingoVariants);
        }
        public void ScrollTo(WebElement webElement)
        {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
        }
        public WebElement[] ArrayOfBingoVatiants(int countOfVariants) throws InterruptedException {
            WebElement [] arrayOfVariants ;
            arrayOfVariants = new WebElement[countOfVariants];
            for(int i=0; i<=countOfVariants-1;i++)
            {
                arrayOfVariants[i] = driver.findElement(By.className("slick-active"));
                driver.findElement(sliderArrowRight).click();
                Thread.sleep(500);
            }
            return arrayOfVariants;
        }
        public boolean TitleOfImgBingoVariants(WebElement[] webElementsArray)
        {
            boolean Success=true;
            for(int i=8; i>=0;i--)
           {
               String title = webElementsArray[i].getText();
               String src = webElementsArray[i].getAttribute("textContent").replaceAll(title,"").trim().replaceAll("-"," ");
               if(src.contains(title) == false)
               {
                   Success =false;
                   break;
               }
           }
            return Success;
        }
        public void Test()
        {
            WebElement e = driver.findElement(By.className("slick-active"));
            e.getAttribute("textContent").replaceAll(e.getText(),"").trim().replaceAll("-"," ").contains(e.getText());
        }
    }


