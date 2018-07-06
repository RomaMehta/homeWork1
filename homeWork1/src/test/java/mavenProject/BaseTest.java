package mavenProject;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utils{

    @BeforeMethod

    //Reusable method - to open browser and website - each time the testcase is run
    public void toopenbrowser()
    {System.setProperty("webdriver.chrome.driver","src\\test\\Resoruces\\BrowserDriver\\chromedriver.exe");

        // to open browser
        driver = new ChromeDriver();

        // Implicity wait - for the entire program
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        // to maximize browser window
        driver.manage().window().maximize();

        // to open the website
        driver.get("http://demo.nopcommerce.com/");}

    @AfterMethod
    public void toCloseBrowser(){
        driver.quit();
    }





}
