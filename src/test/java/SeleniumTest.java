import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {  //tests for https://the-internet.herokuapp.com/

    @Test
    public void firstSeleniumTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        for(WebElement element : elements) {
            System.out.println(element.getText());
        }
        WebElement dragAndDropHref = driver.findElement(By.linkText("Drag and Drop"));
        dragAndDropHref.click();
        driver.quit();
    }
}
