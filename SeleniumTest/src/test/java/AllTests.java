import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AllTests {

    WebDriver driver;

    @Test
    public void DriverInit() {
        driver = DriverProperties.GetBrowserDriver(DriverProperties.Browser.CHROME);
    }

    @Test(dependsOnMethods = {"DriverInit"}, alwaysRun = true)
    public void HomePageColoursTest() {
        SoftAssert asert = new SoftAssert();
        HomePage homepage = new HomePage(driver);
        homepage.OpenPage();
        homepage.AgePopUpConfirm();
        asert.assertFalse(homepage.ElementColorChange(homepage.GetElementHomeMenu()),"HomeButton change color on mouseover ");
        asert.assertTrue(homepage.ElementColorChange(homepage.GetElementProductsMenu()),"ProductButton change color on mouseover");
        asert.assertFalse(homepage.ElementColorChange(homepage.GetElementClientHubMenu()),"ClientHUBButton change color on mouseover");
        asert.assertTrue(homepage.ElementColorChange(homepage.GetElementCompanyMenu()),"CompanyButton change color on mouseover");
        asert.assertFalse(homepage.ElementColorChange(homepage.GetElementContactMenu()),"ContactButton change color on mouseover");
        asert.assertFalse(homepage.ElementColorChange(homepage.GetElementNewsHome()),"NewsButton change color on mouseover");
        homepage.MouseoverElement(homepage.GetElementProductsMenu());
        asert.assertFalse(homepage.ElementColorChange(homepage.GetBingoInProductList()),"BingoButton change color on mouseover");
        asert.assertAll();
   }

    @Test(dependsOnMethods = {"DriverInit"}, alwaysRun = true)
    public void HomePageToBingo() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        BingoPage bingoPage = homepage.GoToBingoFromProductList();
        bingoPage.ScrollTo(bingoPage.GetBingoVariants());
        Assert.assertTrue(bingoPage.TitleOfImgBingoVariants(bingoPage.ArrayOfBingoVatiants(9)));
        driver.quit();
    }
}

