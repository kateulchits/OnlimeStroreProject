import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class LitecartTest {
    WebDriver driver;
    Actions builder;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        builder = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void openRubberDucks() {
        WebElement rubberDucksPage = driver.findElement(By.xpath("//*[@class=\"category-1\"]"));
        rubberDucksPage.click();

        String rubberDucksTtile = driver.getTitle();
        Assert.assertEquals(rubberDucksTtile, "Rubber Ducks | My Store1");
    }

    @Test
    public void openDeliveryInformation() {
        WebElement deliveryInformationPage = driver.findElement(By.xpath("//*[@class=\"page-2\"]"));
        deliveryInformationPage.click();

        String deliveryInformationTitle = driver.getTitle();
        Assert.assertEquals(deliveryInformationTitle, "Delivery Information | My Store1");
    }

    @Test
    public void openTermsAndConditions() {
        WebElement openTermAndConditionsPage = driver.findElement(By.xpath("//*[@class=\"page-4\"]"));
        openTermAndConditionsPage.click();

        String openTermAndConditionsTitle = driver.getTitle();
        Assert.assertEquals(openTermAndConditionsTitle, "Terms & Conditions | My Store1");
    }

    @Test
    public void actionTest() {
        WebElement newCustomers = driver.findElement(By.xpath("//a[text()=\"New customers click here\"]"));
        builder.contextClick(newCustomers).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
    }

}
