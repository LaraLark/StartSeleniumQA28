import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactTest {
    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

    }
    @Test
    public void loginTest(){
        List<WebElement> list = wd.findElements(By.tagName("a"));
        int last = list.size() - 1;
        System.out.println(list.size());
        WebElement element = list.get(last);
        element.click();

    }
    @Test
    public void loginTestByCss(){
        wd.findElement(By.cssSelector("[href='/login']")).click();
        wd.findElement(By.cssSelector("input[placeholder='Email']")).click();
        wd.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        wd.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("mariam@gmail.com");

        wd.findElement(By.cssSelector("input[placeholder='Password']")).click();
        wd.findElement(By.cssSelector("input[placeholder='Password']")).clear();
        wd.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Mm123456$");
        wd.findElement(By.cssSelector("div[class$='login_login__3EHKB'] button:nth-child(4)")).click();

    }
    @Test
    public void loginTestCW(){
        wd.findElement(By.cssSelector("[href='/login']")).click();
        WebElement email = wd.findElement(By.cssSelector("input[placeholder='Email']"));
        email.click();
        email.clear();
        email.sendKeys("mariam@gmail.com");

        WebElement password = wd. findElement(By.cssSelector("input[placeholder='Password']"));
        password.click();
        password.clear();
        password.sendKeys("Mm123456$");

        wd.findElement(By.cssSelector("div[class$='login_login__3EHKB'] button:nth-child(4)")).click();


    }
    @AfterMethod
    public void postCondition(){
        //wd.quit();

    }



}
