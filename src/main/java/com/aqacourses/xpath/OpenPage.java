package com.aqacourses.xpath;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class OpenPage {
    private WebDriver driver;

    @Before
    public void setUp() {
        /*
        Close enable-automation message
         */
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        /*
        initialization driver
         */
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);

        /*
        some settings for driver
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void openSupsystic() {
      /*
     Открываем эту страницу - https://supsystic.com/example/comparison-example/
Достаем цену для Samsung Galaxy S6 и печатаем в консоль
Достаем цену которая идет в следующем ряду и зачеркнута и печатаем в консоль
Находим разницу между этими ценами и печатаем в консоль
     */
        String URL = "https://supsystic.com/example/comparison-example/";
        driver.get(URL);
        String actualGalaxyPrice = driver.findElement(By.xpath("//div[@class='ptsEl ptsCol ptsElWithArea ptsCol-2']/descendant::span[contains(.,'$')]")).getAttribute("textContent");
        String priceGalaxy = driver.findElement(By.xpath("//div[@class='ptsColFooter']//span[contains(.,'$')]")).getAttribute("textContent");
        System.out.println("Текущая цена на телефон Samsung Galaxy - " + actualGalaxyPrice);
        System.out.println("Цена на телефон Samsung Galaxy - " + priceGalaxy);
        double actDo = Double.parseDouble(actualGalaxyPrice);
        double priceDo = Double.parseDouble(priceGalaxy);
//        System.out.println(actDo);                   //не понятно чего не выводится в консоль
//        System.out.println(priceDo);
        System.out.println("Разница в цене: "+(priceDo-actDo));

    }

    @Test
    public void openUnicode(){
        /*
        Открываем эту страницу https://unicode-table.com/ru/
Пишем XPath который достает нам символ - Q из таблицы и выводим в консоль
Пишем XPath который достает нам символ - & из таблицы и выводим в консоль
Пишем XPath который достает нам символ - A из таблицы и выводим в консоль
Можно написать один хпас как шаблон и потом видоизменять его для каждого символа.
         */
        String URL = "https://unicode-table.com/ru/";
        String element;

        driver.get(URL);
        element = driver.findElement(By.xpath("//li[@class='symb'][contains(.,'Q')]")).getAttribute("textContent");
        System.out.println(element);
        element = driver.findElement(By.xpath("//li[@class='symb'][contains(.,'&')]")).getAttribute("textContent");
        System.out.println(element);
        element = driver.findElement(By.xpath("//li[@class='symb'][contains(.,'A')]")).getAttribute("textContent");
        System.out.println(element);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
