import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio14 {

    @Test
    public void findElementsInNetflixAR() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/ar/");

        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        System.out.println("La elementos h1 de la página son los siguientes:");
        for (WebElement h1 : h1List) {
            System.out.println(h1.getText());
        }
        System.out.println("");

        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        System.out.println("Los elementos h2 de la página son los siguientes:");
        for (WebElement h2 : h2List) {
            System.out.println(h2.getText());
        }
        System.out.println("");

        driver.navigate().refresh();

        List<WebElement> bttnList = driver.findElements(By.tagName("button"));
        System.out.println("Los botones presentes en la página son los siguientes:");
        for (WebElement bttn : bttnList) {
            System.out.println(bttn.getText());
        }
        System.out.println("");

        List<WebElement> divList = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div presentes en la página es de " + divList.size());
        System.out.println("");

        System.out.println("El título de la página es " + driver.getTitle());
        System.out.println("");

        List<WebElement> linkList = driver.findElements(By.tagName("link"));
        System.out.println("La cantidad de links presentes en la página es de " + linkList.size());
        System.out.println("");
    }
}
