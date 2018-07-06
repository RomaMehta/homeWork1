package mavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestSuite extends BaseTest {

    @Test // Test case -1
    public void verifyUserisOnTheHomePage(){
        String Expmsg = "Register";
        Assert.assertEquals(toGetText(By.linkText("Register")),Expmsg);
    }


@Test // Test Case -2
 public void verifyUserIsAbleToRegisterSucessfully() {

     /*//These are Elements to be clicked on
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-female")).click();*/
       clickonElement(By.linkText("Register"));
       clickonElement(By.id("gender-female"));

    // These are elements where text is entered
       /* driver.findElement(By.name("FirstName")).sendKeys("Rosalinda");
        driver.findElement(By.id("LastName")).sendKeys("McGrath");*/
       ToenterText(By.name("FirstName"), "Rosalinda");
       ToenterText(By.id("LastName"), "McGrath");

    // these are elements to be selected from drop-down menu
    SelectbyValue(By.xpath("//select[@name='DateOfBirthDay']"),"14");
    SelectbyVisibletext(By.xpath("//select[@name='DateOfBirthMonth']"),"November");
    SelectbyIndex(By.xpath("//select[@name='DateOfBirthYear']"),(14));


      /*  //Method for Dropdown menu - by Value, by visible text and by Index
    Select dayofbirth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
    dayofbirth.selectByValue("14");
    Select birthmonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
    birthmonth.selectByVisibleText("November");
    Select birthyear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
    birthyear.selectByIndex(14);*/

    String email = "rosalinda" + timeStamp() + "@gmail.com";
    ToenterText(By.id("Email"),email);

    ToenterText(By.id("Company"), "Rosa Pvt Ltd");
    clickonElement(By.id("Newsletter"));
    ToenterText(By.id("Password"),"Test1234");
    ToenterText(By.name("ConfirmPassword"), "Test1234");

    clickonElement(By.id("register-button"));

    String ExpText = "Your registration completed";
    // to compare the expected text and the actual text displayed
    Assert.assertEquals(toGetText(By.className("result")),ExpText);

    /*// Method to create TimeStamp - for dynamic Email id
    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());;
    System.out.println(fileName); - to check if method created was working
    //added the timestamp to the email id - concatenation
    //driver.findElement(By.id("Email")).sendKeys("rosalinda" + timeStamp+ "@gmail.com");*/

    }

    @Test // test case -3
    public void userIsAbleToCompareTwoProducts (){
        // to click on add to compare button for build your own computer
        clickonElement(By.xpath("//*[@title='Add to compare list']"));
        // to go back to the main page
        clickonElement(By.xpath("//*[@class='header-logo']/a/img"));
        //to click on add to compare button of virtual gift card
        clickonElement(By.xpath("//*[@class = 'product-grid home-page-product-grid']/div[2]/div[4]/div/div[2]/div[3]/div[2]/input[2]"));
        // to click to the product comparison link on the green flash bar
        clickonElement(By.linkText("product comparison"));
        String Expectedmsg = "Compare products";
        Assert.assertEquals(toGetText(By.xpath("//*[@class='page-title']/h1")),Expectedmsg);
    }

    @Test // Test case -4
    public void verifyUserIsAbleToClearCompareProductList(){
        clickonElement(By.xpath("//*[@title='Add to compare list']"));
        clickonElement(By.xpath("//*[@class='header-logo']/a/img"));
        clickonElement(By.xpath("//*[@class = 'product-grid home-page-product-grid']/div[2]/div[4]/div/div[2]/div[3]/div[2]/input[2]"));
        clickonElement(By.linkText("product comparison"));

        clickonElement(By.className("clear-list"));
        String Expectedmsg = "You have no items to compare.";
        Assert.assertEquals(toGetText(By.className("no-data")),Expectedmsg);
    }

    @Test // Test case -5
    public void verifyUserIsAbleToUseSortByAndDisplayDropDownMenuInBooksPage(){
        // to enter the Books Page
        clickonElement(By.linkText("Books"));
        // To use Sort by Drop-down menu - Price:low to High
        SelectbyVisibletext(By.id("products-orderby"),"Price: Low to High");
        // To use Display Drop-down menu
        SelectbyIndex(By.id("products-pagesize"),(0));

        /*to get the String element from the webpage and to convert into double using
        String number = "123,321";
        double value = Double.parseDouble( number.replace(",",".") );
        - this makes it easier to compare when doing assert*/
        String lowestPrice = toGetText(By.xpath("//*[@class='prices']/span[2]"));
        String highestPrice = toGetText(By.xpath("//div[3]/div/div[2]/div[3]/div[1]/span[2]"));
        double lowestPriceNum = Double.parseDouble(lowestPrice.replace("$",""));
        double highestPriceNum = Double.parseDouble(highestPrice.replace("$",""));

        Assert.assertTrue(lowestPriceNum<highestPriceNum);
        System.out.println(lowestPrice + " < " + highestPrice);
    }

    @Test // test case -6and7
    public void verifyUserIsAbleToAddAppleiCamToCartAndIsAbleToSeeTheProductInCart(){
        clickonElement(By.linkText("Electronics"));
        clickonElement(By.xpath("//*[@class = 'sub-category-item']/h2/a"));
        clickonElement(By.linkText("Apple iCam"));
        clickonElement(By.id("add-to-cart-button-17"));
        // to check the message on the green flash bar
        String expectedMesaage = "The product has been added to your shopping cart";
        Assert.assertEquals(toGetText(By.className("content")),expectedMesaage);

        // to check if product is visible in the shopping cart
        clickonElement(By.linkText("shopping cart"));
        String expText = "Apple iCam";
        Assert.assertEquals(toGetText(By.xpath("//*[@class='product']/a")),expText);
    }




}
