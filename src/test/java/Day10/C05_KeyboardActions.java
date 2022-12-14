package Day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        // once arama kutusuna click yapip
        // sonra harf harf Nutella yazisini yazdiralim
        // sonra da ENTER tusuna basalim
        actions.click(SearchBox).keyDown(Keys.SHIFT).sendKeys("n")
                .keyUp(Keys.SHIFT).sendKeys("u").sendKeys("t")
                .sendKeys("e").sendKeys("l").sendKeys("l").sendKeys("a")
                .sendKeys(Keys.ENTER).perform();// shift nasıl kaldı ise öyle devam ediyor küçük için
        // tekrar eski haline getirmek lazım
        Thread.sleep(3000);

    }
}
