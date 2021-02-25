import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2 {
	
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
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/kmundale/Downloads/chromedriver");
		driver=new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php"); //opens window to google
		driver.manage().window().maximize(); //maximizes window 
		driver.findElement(By.className("login")).sendKeys(Keys.RETURN); //types IMBD in the searchbar
		pause(2);
		driver.findElement(By.name("email_create")).sendKeys("kate2@email.com");
		driver.findElement(By.name("SubmitCreate")).sendKeys(Keys.RETURN);
		pause(2);
		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.name("customer_firstname")).sendKeys("kate");
		driver.findElement(By.name("customer_lastname")).sendKeys("boombats");
		driver.findElement(By.name("passwd")).sendKeys("Boombats123");
		driver.findElement(By.name("days")).sendKeys("20");
		driver.findElement(By.name("months")).sendKeys("Boombats123");
		Select days = new Select(driver.findElement(By.name("days")));
		days.selectByIndex(20);
		Select months = new Select(driver.findElement(By.name("months")));
		months.selectByIndex(2);
		Select years = new Select(driver.findElement(By.name("years")));
		years.selectByIndex(40);
		driver.findElement(By.name("company")).sendKeys("Whatevs");
		driver.findElement(By.name("address1")).sendKeys("123 Sesamee Street");
		driver.findElement(By.name("city")).sendKeys("Lancaster");
		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByIndex(37);
		driver.findElement(By.name("postcode")).sendKeys("17602");
		driver.findElement(By.name("phone_mobile")).sendKeys("11234567");
		driver.findElement(By.name("alias")).sendKeys("theCastle");
		driver.findElement(By.name("submitAccount")).sendKeys(Keys.RETURN);
		pause(2);
		List<WebElement> l= driver.findElements(By.xpath("//*[text()[contains(.,'kate boombats')]]"));
	      // verify list size
	      if ( l.size() > 0){
	         System.out.println("you are logged in");
	      } else {
	         System.out.println("you are NOT logged in");
	      }
	   }

	}
	


