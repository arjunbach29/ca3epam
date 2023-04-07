package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.Reporter;

public class mailtesting {
    WebDriver tester;



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
        tester.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("arjunbacharwar29@gmail.com");
        Thread.sleep(1000);
        tester.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        Thread.sleep(10000);
    }
    @AfterClass
    void closeTester () {
        tester.close();
    }
}












