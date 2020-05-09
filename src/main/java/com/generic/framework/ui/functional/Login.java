package com.generic.framework.ui.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Login {

    public void doLogin(WebDriver driver){
        driver.get("https://a4data-qe.netlify.app");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys("superadmin");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("password")).clear();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("password")).sendKeys("Design_20");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span")).click();
        WebElement span = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button/span"));
        WebElement btn = driver.findElement(By.xpath("//div[@id='gatsby-focus-wrapper']/div/main/div/main/div/form/button"));

        span.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // 2. How do I know I actually Logged In?
        driver.findElement(By.xpath("//*[text()='Logout']"));
    }

}
