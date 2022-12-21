package day04_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Test01 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Ödev
    //-Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");

    //-Arama kutusunu locate ediniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

    //-Arama kutusunun tagName'inin input olduğunu test ediniz.
        String actualTagName = aramaKutusu.getTagName();
        if(actualTagName.equals("input")) {
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //-Arama kutusunun name atributu'nun değerinin field-keywords olduğunu test ediniz
        String actualAttributeName = aramaKutusu.getAttribute("name");
        String expectedAttributeName = "field-keywords";
        if (actualAttributeName.equals(expectedAttributeName)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");


        //-Sayfayı kapatınız






    }


}
