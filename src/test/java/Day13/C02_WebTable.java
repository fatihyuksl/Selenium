package Day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {
    @Test
    public void test1() {
     /////  login( ) metodun oluşturun ve oturum açın.
        login();
        ////Tüm table body’sinin boyutunu(sutun sayisi) bulun.
      List<WebElement> sutunBaslıklarıListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sütünsayisi: "+sutunBaslıklarıListesi.size());
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumbody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumbody.getText());
        //● printRows( ) metodu oluşturun //tr
        //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " + satirlarListesi.size());
        //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each: satirlarListesi) {
            System.out.println(each.getText());
           // satirlarListesi.forEach(t-> System.out.println(t.getText()));
        }
        //          ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each: cellList
        ) {
            System.out.println(each.getText());
        }
        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size() ; i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
        List<WebElement> emailSutunListesi=
                driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each: emailSutunListesi) {
            System.out.println(each.getText());
        }

    }

    public void login() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));//
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

    }
}
