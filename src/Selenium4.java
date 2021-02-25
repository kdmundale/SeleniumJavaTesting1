import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium4 {
	
	public static void pause(int x) {
		
		int y = x * 1000;
		
		try {
			Thread.sleep(y);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/kmundale/Downloads/chromedriver");
		driver=new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php"); //opens window to google
		driver.manage().window().maximize(); //maximizes window
		driver.findElement(By.className("login")).sendKeys(Keys.RETURN);
		pause(2);
		driver.findElement(By.name("email")).sendKeys("kate@email.com");
		driver.findElement(By.name("passwd")).sendKeys("Boombats123");
		driver.findElement(By.name("SubmitLogin")).sendKeys(Keys.RETURN);
		pause(1);
		List<WebElement> l= driver.findElements(By.xpath("//*[contains(text(),'kate boombats')]"));
	      // verify list size
	      if ( l.size() > 0){
	         System.out.println("you are logged in");
	      } else {
	         System.out.println("you are NOT logged in");
	      }
	     Actions actions = new Actions(driver);
	        //Retrieve WebElement 'Music' to perform mouse hover 
	     WebElement mainMenu = driver.findElement(By.linkText("DRESSES"));
	     actions.moveToElement(mainMenu).build().perform();
	     
	     pause(2);
	     
	     WebDriverWait wait = new WebDriverWait(driver, 1); 
	     wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SUMMER DRESSES")));  
	     //identify menu option from the resulting menu display and click
	     WebElement menuOption = driver.findElement(By.linkText("SUMMER DRESSES"));
	     menuOption.click();
	     
	     pause(1);
	     
	     Select sort = new Select(driver.findElement(By.id("selectProductSort")));
			sort.selectByIndex(1);
		
		 pause(1);
		 
		WebElement  dress= driver.findElement(By.xpath(".//div[@id='center_column']/ul/li")); 
		actions.moveToElement(dress).build().perform(); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add to cart")));
		WebElement menuOption2 = driver.findElement(By.linkText("Add to cart"));
	    menuOption2.click();
	    List<WebElement> l2= driver.findElements(By.xpath("//*[contains(text(),'Product successfully added to your cart')]"));
	      // verify list size
	      if ( l.size() > 0){
	         System.out.println("it worked!");
	      } else {
	         System.out.println("didn't work");
	      }
	    
	    pause(2);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='layer_cart']/div/div/div/a[@title='Proceed to checkout']")));
	    
	    WebElement menuOption3 = driver.findElement(By.xpath("//div[@id='layer_cart']/div/div/div/a[@title='Proceed to checkout']"));
	   
	    wait.until(ExpectedConditions.elementToBeClickable(menuOption3));
	   
	    menuOption3.click(); 
	    
	    pause(2);
	    
	    WebElement add1 = driver.findElement(By.xpath("//a[contains(@id, 'cart_quantity_up')]"));
	    add1.click();
	    
	    List<WebElement> prodQty= driver.findElements(By.xpath("//input[@value='2']"));
	      // verify list size
	      if ( prodQty.size() > 0){
	         System.out.println("it worked!");
	      } else {
	         System.out.println("didn't work");
	      }
	    
	    pause(2);
	    System.out.println("1");
	    WebElement next = driver.findElement(By.linkText("Proceed to checkout"));
	    next.click();
	   
	    pause(2);
	    
	    System.out.println("2");
	    WebElement next2 = driver.findElement(By.xpath("//button[@name='processAddress']"));
	    next2.click();
	    
	    
	    pause(2);
	    
	    System.out.println("3");
	    WebElement agree = driver.findElement(By.xpath("//input[@name='cgv']"));
	    agree.click();
	    
	    pause(2);
	    
	    System.out.println("4");
	    WebElement next3 = driver.findElement(By.xpath("//button[@name='processCarrier']"));
	    next3.click();
	    
	    pause(2);
	    
	    System.out.println("5");
	    WebElement next4 = driver.findElement(By.xpath("//a[@title='Pay by check.']"));
	    next4.click();
	    
	    pause(2);
	    
	    System.out.println("6");
	    WebElement next5 = driver.findElement(By.xpath("//span[contains(text(), 'I confirm my order')]"));
	    next5.click();
	    
	    pause(2);
	    
	    System.out.println("7");
	    List<WebElement> complete = driver.findElements(By.xpath("//*[text()[contains(.,'Your order on My Store is complete.')]]"));
	      // verify list size
	      if ( complete.size() > 0){
	         System.out.println("it worked!");
	      } else {
	         System.out.println("didn't work");
	      }
	    
	    pause(2);
	    
	    System.out.println("8");
	    WebElement next6 = driver.findElement(By.xpath("//a[@title='Back to orders']"));
	    next6.click();
	    
	    pause(2);
	    driver.quit();
	}
}
