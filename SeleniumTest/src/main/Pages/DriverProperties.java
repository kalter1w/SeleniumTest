import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.awt.*;
import java.time.Duration;

public class DriverProperties {
private static WebDriver driver;
public static WebDriver GetBrowserDriver(Browser browser) {

switch (browser)
{
    case EDGE -> {
        System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/msedgedriver.exe");
         driver = new EdgeDriver();
        break;
    }
    case CHROME -> {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
         driver = new ChromeDriver();
        break;

    }
}
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        return driver;
    }
    public enum Browser
    {
        CHROME,EDGE
    }
}
