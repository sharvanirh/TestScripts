package MavenProject.Assignment_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class RegisterationPage {
	WebDriver driver;
	@BeforeClass
		
		public void openBrowser() {
			driver=new ChromeDriver();
			driver.get("http://newtours.demoaut.com/mercuryregister.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
	
	@Test
	
	public void Register() {
		driver.findElement(By.name("firstName")).sendKeys("Sharvani");
		driver.findElement(By.name("lastName")).sendKeys("R H");
		driver.findElement(By.name("phone")).sendKeys("6478600579");
		driver.findElement(By.id("userName")).sendKeys("sharvanihiremath73@gmail.com");
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")).sendKeys("Unit-702");
        driver.findElement(By.name("address2")).sendKeys("110, St Clair Ave W");
	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")).sendKeys("Toronto");
	    driver.findElement(By.name("state")).sendKeys("Ontario");
	    driver.findElement(By.name("postalCode")).sendKeys("M4V 1N4");
	    WebElement element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select"));
	    Select sel = new Select(element);
	    sel.selectByValue("32");
	    driver.findElement(By.id("email")).sendKeys("sharvanihiremath73@gmail.com");
	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).sendKeys("passcode");
	    driver.findElement(By.name("confirmPassword")).sendKeys("passcode");
	    driver.findElement(By.name("register")).click();
	    String expectedvalue="Thank you for registering. You may now sign-in using the user name and password you've just entered.";
	    WebElement element1=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]"));
	    String Actualvalue=element1.getText();
	    Assert.assertEquals("Registeration Failed", expectedvalue, Actualvalue);
	    
	
	}
	
	
	
	
	
	
	
	@AfterClass

	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
