import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {
    // 1. Amazon.com'a gideceğiz.
    // 2. Arama kutusuna "baby stroller"
    // 3. 2. Sıradaki ürüne tıklayacağız.
    // 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
    // 5. Ürünün ortalama puanını (5 üzerinden) alacağız.



    @Test
    public void test1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller"+ Keys.ENTER);

        WebElement ikinciSiradaUrun = driver.findElement(By.xpath("( //a[@class='a-link-normal a-text-normal'] )[2]"));
        ikinciSiradaUrun.click();
        WebElement urunFiyati = driver.findElement(By.id("priceblock_ourprice_row"));
        System.out.println(urunFiyati.getText());


     /*   WebElement stroll = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        stroll.click();

        String fiyat = driver.findElement(By.id("price_inside_buybox")).getText();
        System.out.println("Urunun fiyati : "+fiyat);

        String puan = driver.findElement(By.id("averageCustomerReviews")).getText();
        System.out.println("Urunun puanlamasi : "+puan);*/

    }

    @Test
    public void test2(){

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.navigate().to("http://www.google.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement searchGoogle = driver.findElement(By.xpath("//input[@name='q']"));
            searchGoogle.sendKeys("Kemal Ozden");
            searchGoogle.submit();

            WebElement toplamSayi = driver.findElement(By.id("result-stats"));
            System.out.println(toplamSayi.getText());

    }


}
