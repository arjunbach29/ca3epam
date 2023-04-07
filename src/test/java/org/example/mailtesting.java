package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class mailtesting {
    WebDriver tester;
    private Properties prop;

    @BeforeTest
    public void beforeTest() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("resources/config.properties");
        prop.load(fis);
    }



    @BeforeClass
    @Parameters({"Browser", "Url"})
    public void mailtest (String browser, String link){

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tester = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            tester = new EdgeDriver();
        }
        tester.get(link);
        tester.manage().window().maximize();

    }
    @Test
    public void accessmail() throws InterruptedException {
        tester.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(prop.getProperty("username"));
        Thread.sleep(1000);
        tester.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        Thread.sleep(10000);
    }
    @AfterClass
    void closeTester () {
        tester.close();
    }
}












