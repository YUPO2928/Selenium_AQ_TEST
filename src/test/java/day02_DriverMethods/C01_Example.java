package day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Example {

    public static void main(String[] args) {

        /*
        -----EXAMPLE-------
        İlk önce browser'ı maximize yapalım sonra tüm sayfa için bekleme süresi olarak 15 sn belirtelim.
        Sırasıyla amazon ve facebook sayfalarına gidelim.
        Amazon sayfasına tekrar dönelim.
        Amazon sayfasının Url'inin  https://www.amazon.com/ adresine eşit olduğunu test edelim.
        Sayfanın konumunu ve pozisyonunu yazdıralım.
        Sayfanın konumunu ve size'nı istediğimiz şekilde ayarlayalım.
        ve istediğimiz şekilde olduğunu test edelim.
        ve Sayfayı kapatalım.

         */

            System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe" );
            WebDriver driver = new ChromeDriver();


        // İlk önce browser'ı maximize yapalım sonra tüm sayfa için bekleme süresi olarak 15 sn belirtelim.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Sırasıyla amazon, facebook ve youtube sayfalarına gidelim.
        driver.get("https://www.amazon.com");
        driver.get("https://www.facebook.com");
        driver.get("https://www.youtube.com");

        // Amazon sayfasına tekrar dönelim.
        driver.navigate().back();
        driver.navigate().back();

        // Amazon sayfasının Url'inin  https://www.amazon.com/ adresine eşit olduğunu test edelim.
        String ActualUrl =  driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";

        if (ActualUrl.equals(expectedUrl)){
            System.out.println("Url TESTI PASSED");
        }else System.out.println("Url TESTI FAILED");

        // Sayfanın konumunu ve pozisyonunu yazdıralım.
        System.out.println("Sayfanın Sıze'ı :" + driver.manage().window().getSize());
        System.out.println("Sayafanın Pozisyonu :"+ driver.manage().window().getPosition());

        // Sayfanın konumunu ve size'nı istediğimiz şekilde ayarlayalım.
        driver.manage().window().setSize(new Dimension(600,600));
        driver.manage().window().setPosition(new Point(50,50));

        System.out.println("Sayfanın Yeni Sıze'ı :" + driver.manage().window().getSize());
        System.out.println("Sayafanın Yeni Pozisyonu :"+ driver.manage().window().getPosition());


        // ve istediğimiz şekilde olduğunu test edelim.
        Dimension actualYeniSize = driver.manage().window().getSize();
        if(actualYeniSize.getWidth()==600 && actualYeniSize.getHeight()==600){
            System.out.println("Size TESTI PASSED");
        }else System.out.println("Size TESTI FAILED");

        Point actualYeniKonum = driver.manage().window().getPosition();
        if(actualYeniKonum.getX()==50 && actualYeniKonum.getY()==50){
            System.out.println("Konum TESTI PASSED");
        }else System.out.println("Konum TESTI FAILED");

        // ve Sayfayı kapatalım.
        driver.close();
















    }
}
