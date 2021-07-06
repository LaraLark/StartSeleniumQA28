import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest {
    WebDriver wd;
    @BeforeMethod
    public void preCondition(){
      wd = new ChromeDriver() ;
      wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    @Test
    public void findElement(){
        List<WebElement> list = wd.findElements(By.tagName("a"));
        System.out.println(list.size());
        WebElement about = list.get(1);
        about.click();
        list.get(1).click();
        list.get(0).click();

    }
    @Test
    public void locatorTest(){
        List<WebElement> list = wd.findElements(By.tagName("a"));
        list.get(2).click();
       // By.tagName()
        wd.findElement(By.tagName("a"));
        wd.findElement(By.tagName("h1"));
        wd.findElement(By.tagName("input"));
        wd.findElement(By.tagName("button"));

        wd.findElement(By.cssSelector("a"));


      //  By.id()
        wd.findElement(By.id("root"));
        //id = #
        wd.findElement(By.cssSelector("#root"));
        wd.findElement(By.cssSelector("[id='root']"));

      //  By.className()
        wd.findElement(By.className("container"));
        wd.findElement(By.className("active"));
        wd.findElement(By.cssSelector("[class='active']"));
        //class = .
        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.cssSelector(".active"));

      // By.name
     //   wd.findElement(By.name("namename"));

        wd.findElement(By.cssSelector("[name='namename']"));
        //By.linkText
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));

        wd.findElement(By.cssSelector("[href='/home']"));
        //-------------------------

        wd.findElement(By.cssSelector("[placeholder='Password']"));
        //начинается ^=
        wd.findElement(By.cssSelector("[placeholder^=Pas']"));
        //заканчивается $=
        wd.findElement(By.cssSelector("[placeholder$='ord']"));
        //содержит *=
        wd.findElement(By.cssSelector("[placeholder*='sword']"));

    }
    @Test
    public void loginTest(){
        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> list = wd.findElements(By.tagName("input"));
        WebElement email = list.get(0);
        WebElement password = list.get(1);
        email.click();
        email.clear();
        email.sendKeys("mariam@gmail.com");

        password.click();
        password.clear();
        password.sendKeys("Mm123456$");

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(1).click();


    }

    @AfterMethod
    public void postCondition(){
     // wd.quit();



    }
}
