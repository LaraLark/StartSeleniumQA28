import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class W3schools {

    WebDriver wd;
    @BeforeMethod
    public void preCondition(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");


    }
    @Test
    public void w3schoolsTest(){
        //numbers of rows
        List<WebElement> rows = wd.findElements(By.cssSelector("table#customers tr"));
        int numberRofRows = rows.size();
        System.out.println("Rows in table" +"-" + numberRofRows);
        //numbers of columns
        List<WebElement> columns = wd.findElements(By.cssSelector("tr:first-child th"));
        System.out.println("Columns in table" +"-" + columns.size());
        //print rows number 3
        List<WebElement>thirdRows = wd.findElements(By.cssSelector("tr:nth-child(3)"));
        for(WebElement el:thirdRows){
            System.out.println(el.getText());
        }
        //print last columns
        List<WebElement>lastColumm = wd.findElements(By.cssSelector("td:last-child"));
        for(WebElement el:lastColumm){
            System.out.println(el.getText());
        }
        //print Maria Anders
        String text = wd.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)")).getText();
        System.out.println(text);
    }
    @AfterMethod
    public void postCondition(){
        wd.close();

    }
}
