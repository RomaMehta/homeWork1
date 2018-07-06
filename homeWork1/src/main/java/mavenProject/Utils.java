package mavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {

    // for Elements to be clicked on
    public static void clickonElement(By by)
    {
        driver.findElement(by).click();
    }

    // for Elements where text needs to be entered
    public static void ToenterText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    // For selecting from Drop-down menu - by Value
    public static void SelectbyValue(By element, String num)
    {
        new Select(driver.findElement(element)).selectByValue(num);
    }

    // For selecting from Drop-down menu - by Visible Text
    public static void SelectbyVisibletext(By element, String text)
    {
        new Select(driver.findElement(element)).selectByVisibleText(text);
    }

    // For selecting from Drop-down menu - by Index
    public static void SelectbyIndex(By element, int num)
    {
        new Select(driver.findElement(element)).selectByIndex(num);
    }

    // For making dynamic email id - using TimeStamp
    public static String timeStamp()
    {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmSS");
        return format.format(new Date());
    }

    // To get Actual text from the element
    public static String toGetText(By by)
    {
       return driver.findElement(by).getText();
    }



}
