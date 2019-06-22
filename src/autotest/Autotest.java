package autotest;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver; 


/**
 *
 * @author Dagmawi
 */
public class Autotest {  
    /**     
     * @param args the command line arguments   
     */ 
    static PrintWriter out = null;
    public static void main(String[] args) throws InterruptedException {  
        // Create a new instance of the Firefox driver         
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        WebDriver driver;    
        
        int total = 0;
        driver = new FirefoxDriver();   
        //Launch the some site
        driver.get("https://portal.aait.edu.et/"); 
        // Print a Log In message to the screen 
        System.out.println("Successfully opened the website localhost"); 
        
        WebElement atr = driver.findElement(By.id("UserName")); 
//        WebElement pwd = driver.findElement(By.xpath(".//*[@id='inputPassword']")); 
//        
        atr.sendKeys("ATR/0756/09");
        
        WebElement pwd = driver.findElement(By.id("Password")); 
        
        pwd.sendKeys("2209");
//        
        driver.findElement(By.xpath("//*[@id='home']/div[2]/div[2]/form/div[4]/div/button")).click(); 
//        

        driver.findElement(By.xpath("/html/body/nav/div[3]/ul/li[4]/a")).click();
        Thread.sleep(500);
        
        driver.findElement(By.xpath("//*[@id=\"m2\"]/ul/li[1]/a")).click();
        Thread.sleep(1000);
        WebElement table = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/table"));
        
        

        System.out.println(table.getText()); 
        try{
        FileWriter report = new FileWriter("GradeReport.txt",true);
            BufferedWriter vbuffer = new BufferedWriter(report);
            out = new PrintWriter(vbuffer);
            
            out.println(table.getText());
            
            out.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
        Thread.sleep(10000);
        
        
        Thread.sleep(100000);
       
        driver.quit();
    }   
} 
