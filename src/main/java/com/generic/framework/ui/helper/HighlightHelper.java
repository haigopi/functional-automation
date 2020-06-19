package com.generic.framework.ui.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightHelper {
    public static void highLightElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor)driver;

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

        try
        {
            Thread.sleep(1 * 1000);
        }

        catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }

        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

    }
}
