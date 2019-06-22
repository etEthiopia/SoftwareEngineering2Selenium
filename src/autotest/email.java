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
public class email {  
    /**     
     * @param args the command line arguments   
     */ 
    static PrintWriter out = null;
    static String email = "";
    static String password = "";
    public static void main(String[] args) throws InterruptedException {  
        // Create a new instance of the Firefox driver         
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        WebDriver driver;    
        int total = 0;
        driver = new FirefoxDriver();   
        //Launch the some site
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"); 
        // Print a Log In message to the screen 
        System.out.println("Successfully opened the website localhost"); 
        
        WebElement atr = driver.findElement(By.id("identifierId")); 
//        WebElement pwd = driver.findElement(By.xpath(".//*[@id='inputPassword']")); 
//        
        atr.sendKeys(email);
//        pwd.sendKeys("123123");
//        
        driver.findElement(By.id("identifierNext")).click(); 
//        

        System.out.println("id next"); 

        Thread.sleep(5000);

        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys(password);
        
        driver.findElement(By.id("passwordNext")).click(); 
        
        
        Thread.sleep(5000);
        
    WebElement number = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[2]/div[1]/span/div[1]/span/span[2]"));
  
        for (int j = 0; j < 25; j++) {
            List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zA zE']"));
            
            total += unreademeil.size();
            for (int i = 0; i < unreademeil.size(); i++) {
                System.out.println("Unread email from: " + unreademeil.get(i).getText());
                try{
        FileWriter report = new FileWriter("Mails.txt",true);
            BufferedWriter vbuffer = new BufferedWriter(report);
            out = new PrintWriter(vbuffer);
            
            out.println(unreademeil);
            
            out.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
            }
            driver.findElement(By.xpath("//*[@id=':k1']")).click();
            Thread.sleep(2000);
        }
        
        
        
        
        Thread.sleep(1000000);
 
       
        driver.quit();
    }   
} 
