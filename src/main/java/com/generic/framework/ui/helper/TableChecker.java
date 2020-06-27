package com.generic.framework.ui.helper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class TableChecker {
    public static void rowValidator(WebDriver driver, ExtentTest test, String table_xpath) {
        WebElement totalRecords = driver.findElement(By.xpath("//*[@id=\"total-records-count\"]")); // same for all tables
        String rows_on_screen = totalRecords.getText();
        int actual_rows = Integer.parseInt(rows_on_screen);


        System.out.println("Total Records On Screen (actual): " + actual_rows);
        test.log(Status.INFO, "Total Records On Screen (actual): " + actual_rows);

        WebElement grid = driver.findElement(By.xpath(table_xpath));
        String row_count = grid.getAttribute("aria-rowcount");
        int expected_rows = Integer.parseInt(row_count);
        expected_rows--; // counts the column names row as one row so we decrement
        System.out.println("Excepted Row Count : " + expected_rows);
        test.log(Status.INFO, "Expected Row Count : " + expected_rows);
        Assert.assertEquals(actual_rows, expected_rows);
        if (actual_rows == expected_rows) {
            test.log(Status.INFO, "The rows on screen (actual) equals the number of rows in the table (expected) for the given query");
        }

    }

    public static void rowValidatorWithoutXpath(WebDriver driver, ExtentTest test) {
        WebElement totalRecords = driver.findElement(By.xpath("//*[@id=\"total-records-count\"]")); // same for all tables
        String rows_on_screen = totalRecords.getText();
        int actual_rows = Integer.parseInt(rows_on_screen);


        System.out.println("Total Records On Screen (actual): " + actual_rows);
        test.log(Status.INFO, "Total Records On Screen (actual): " + actual_rows);

        WebElement grid = driver.findElement(By.xpath("//*[@id=\"query-search-result-table\"]/div/div/div[1]/div"));
        String row_count = grid.getAttribute("aria-rowcount");
        int expected_rows = Integer.parseInt(row_count);
        expected_rows--; // counts the column names row as one row so we decrement
        System.out.println("Excepted Row Count : " + expected_rows);
        test.log(Status.INFO, "Expected Row Count : " + expected_rows);
        Assert.assertEquals(actual_rows, expected_rows);
        if (actual_rows == expected_rows) {
            test.log(Status.INFO, "The rows on screen (actual) equals the number of rows in the table (expected) for the given query");
        }
    }


    public static void getColumnCount(WebDriver driver, ExtentTest test, String table_xpath) {
        WebElement grid = driver.findElement(By.xpath(table_xpath));
        String col_count = grid.getAttribute("aria-colcount");
        System.out.println("Column Count: " + col_count);
    }

    public static void getColumnCountAndNames(WebDriver driver, ExtentTest test) {
        WebElement column_names = driver.findElement(By.xpath("//*[@id=\"query-search-result-table\"]/div/div/div[1]/div/div[1]")); //xpath same for all

        String[] col_names = column_names.getText().split("\n");
        System.out.println("Column length: " + col_names.length);
        test.log(Status.INFO, "Column Count: " + col_names.length);
        for(int i = 0; i < col_names.length; i++) {
            int iter = i + 1;
            System.out.println(iter  + " column name: " + col_names[i]);
            test.log(Status.INFO, iter + " column name: " + col_names[i]);
        }
    }

}

// row extra code
//List<WebElement> one_row = grid.findElements(By.xpath("//*[@id=\"query-search-result-table\"]/div/div/div[1]/div/div[3]/div[2]/div/div/div[1]"));
//System.out.println("Size;" + one_row.size());

//System.out.println(grid.getText());
//*[@id="query-search-result-table"]/div/div/div[1]/div

        /*WebElement first_row = driver.findElement(By.xpath("//*[@id=\"query-search-result-table\"]/div/div/div[1]/div/div[3]/div[2]/div/div/div[4]"));
        System.out.println(first_row.getText());
        String first_row_id = first_row.getAttribute("row-index");

        int first_row_num = Integer.parseInt(first_row_id);
        for(int rowIndex = first_row_num; rowIndex < rows; rowIndex++) {
            String id = Integer.toString(rowIndex);
            if(driver.findElements(By.id(id)).size() == 0) {
                System.out.println("Error!");
                return;
            }
        }
        System.out.println("Successful");

        //System.out.println("Last Row Num: " + last_row_num + 1);

        /*try {
            WebElement last_row = driver.findElement(By.xpath("/html/body/div/div/div/main/div/div/div/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div[2]/div/div/div[100]"));
            String last_row_id = last_row.getAttribute("row-id");
            int last_row_num = Integer.parseInt(last_row_id);
            last_row_num += 1;
            System.out.println("row-id:" + last_row_num);
            Assert.assertEquals(rows, last_row_num);
            test.log(Status.INFO, "The records shown on screen is equal to no. of rows. Successful Validation");
            System.out.println("The records shown on screen is equal to no. of rows. Successful Validation");
        } catch (NoSuchElementException e) {
            test.log(Status.INFO, "The records shown on screen is NOT equal to no. of rows. Unsuccessful Validation");
            Assert.assertFalse(true);
        }*/

//String role = row_one.getAttribute("role");

//System.out.println("role:" + role);
//System.out.println("rowid:" + row_id);

//List<WebElement> list_rows = grid.findElements(By.tagName("div"));
//System.out.println(list_rows.size());
//ag-row ag-row-no-focus ag-row-odd ag-row-level-0 ag-row-position-absolute

//