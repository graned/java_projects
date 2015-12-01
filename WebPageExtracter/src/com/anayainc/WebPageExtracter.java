/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anayainc;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.io.FileChannelRandomAccessSource;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.TiffImage;
import com.thoughtworks.selenium.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author jose.villagrana
 */
public class WebPageExtracter {
     public static void main(String[] args) throws Exception {
     // The Firefox driver supports javascript 
     WebDriver driver = new FirefoxDriver();
        
     // Go to the Google Suggest home page
     driver.get("http://afsitsm.service-now.com/");
     driver.manage().window().maximize();
     /**
      * LOG IN ACTIONS
      */
     WebElement element = driver.findElement(By.id("userNameInput"));
     element.sendKeys("j.anaya.villagrana");
     element = driver.findElement(By.id("passwordInput"));
     element.sendKeys("1123581321Ed*");
     element = driver.findElement(By.id("submitButton"));
     element.click();
     /**
      * END OF LOG IN
      */
     
     
     
     // Sleep until the div we want is visible or 5 seconds is over
     //        long end = System.currentTimeMillis() + 5000;
     //        while (System.currentTimeMillis() < end) {
     //            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));
     //
     //            // If results have been returned, the results are displayed in a drop down.
     //            if (resultsDiv.isDisplayed()) {
     //              break;
     //            }
     //        }
     //
     //        // And now list the suggestions
     //        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
     //        
     //        for (WebElement suggestion : allSuggestions) {
     //            System.out.println(suggestion.getText());
     //        }

     //driver.quit();
     }
}

