package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {
    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");


    }

    @AfterClass
    public static void tearDown() {
       driver.close();
    }

    @Test
    public void test1() {

        // titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @Test
    public void test2() {
        // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@id='search'])[1]")).isEnabled());
    }

    @Test
    public void test3() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTitle="youtube";
        String actualTitle=driver.getTitle();
        Assert.assertNotEquals("wrong",expectedTitle, actualTitle);
       // Assert.assertFalse(driver.getTitle().contains("youtube"));;




    }

}

