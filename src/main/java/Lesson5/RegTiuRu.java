package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegTiuRu {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://moskva.tiu.ru/");


        WebDriverWait WebDriverWait = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//button[contains(text(),'Зарегистрироваться')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("George");
        driver.findElement(By.id("registrationEmail")).click();
        driver.findElement(By.id("registrationEmail")).sendKeys("000bgru000@gmail.com");
        driver.findElement(By.id("createPassword")).click();
        driver.findElement(By.id("createPassword")).sendKeys("George");
        driver.findElement(By.id("registrationConfirmButton")).click();

        Thread.sleep(5000);
        driver.quit();

        String bodyText;
        bodyText = driver.findElement(By.xpath("//div[contains(text(),'Данный email уже зарегистрирован')]")).getText();
        Assert.assertTrue("Тест пройден", bodyText.contains("Данный email уже зарегистрирован"));

    }



}
