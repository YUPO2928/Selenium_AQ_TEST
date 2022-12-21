package day03_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_CssSelector {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


       // 1- https://www.amazon.com/ adresine gidin. ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        driver.get("https://www.amazon.com/");


       // 2- Sayfayi “refresh” yapin
        driver.navigate().refresh();

       // 3- Sayfa basliginin “Spend less” ifadesi icerdigini test edin.----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String actulaTitle = driver.getTitle();
        if(actulaTitle.contains("Spend less")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

       // 4- Gift Cards sekmesine basin.----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.cssSelector("a[href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']")).click();

       // 5- Birthday butonuna basin.-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //1.yol:
        driver.findElement(By.cssSelector("img[src='https://images-na.ssl-images-amazon.com/images/G/01/gift-certificates/consumer/2021/GCLP/Support/2x/Occ_Birthday_346x130.png']")).click();

        //2.yol:
             /*
            <img src="https://images-na.ssl-images-amazon.com/images/G/01/gift-certificates/consumer/2021/GCLP/Support/2x/Occ_Birthday_346x130.png" alt="Birthday">
            */
        //driver.findElement(By.cssSelector("img[alt='Birthday']")).click();

       // 6- Best Seller bolumunden ilk urunu tiklayin.------------------------------------------------------------------------------------------------------------------------------------------------------------------
        List<WebElement> bestSellerSection = driver.findElements(By.cssSelector(" img[alt='Amazon.com eGift Card']"));
        bestSellerSection.get(0).click();


       // 7- Gift card details’den 25 $’i secin.-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.cssSelector("span[id='a-autoid-28']")).click();

       // 8- Urun ucretinin 25$ oldugunu test edin.----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        WebElement ürünUcreti = driver.findElement(By.cssSelector("span[id='gc-live-preview-amount']"));
        if(ürünUcreti.getText().equals("$25.00")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        // 9- Sayfayi kapatin.-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        driver.close();

    }
}
