package MavenProject.Assignment_Selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PurchaseTicket {
		WebDriver driver;
		@BeforeClass
			
			public void openBrowser() {
				driver=new ChromeDriver();
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}
		
		
		@Test
		
		public void purchaseTicket() throws InterruptedException {
			driver.get("http://newtours.demoaut.com/mercurywelcome.php");
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("mercury");
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("mercury");
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")).click();
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
		    //Selecting no of passengers from dropdown
		    WebElement PassengerCount = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select"));
		    Select sel = new Select(PassengerCount);
		    sel.selectByIndex(1);
		    //Selecting departing City
		    WebElement DepartCity=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select"));
		    Select sel1 = new Select(DepartCity);
		    sel1.selectByValue("New York");
		      
		    List<WebElement> elements= sel1.getOptions();
		    for(WebElement element: elements) {
		    	
		    	System.out.println("Source city"+element.getText());
		    }
		    
		    int ActualCountofSourceCities = elements.size();
		    int ExpectedCountofCities = 10;
		    Assert.assertEquals("Source Cities Count Mismatch: ", ExpectedCountofCities, ActualCountofSourceCities);
		    
		    
		    //Selecting Date
		    WebElement Month = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[1]"));
		    Select Sel2 = new Select(Month);
		    Sel2.selectByVisibleText("April");
		    WebElement Date = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[2]"));
		    Select sel3 = new Select(Date);
		    sel3.selectByValue("10");
		    
		    //Selecting Arriving City
		    WebElement ArriveCity= driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select"));
		    Select sel4 = new Select(ArriveCity);
		    sel4.selectByIndex(6);
		    
		    List<WebElement> elements1 = sel4.getOptions();
		    for(WebElement element1 : elements1) {
		    	
		    	System.out.println("Arriving city: "+element1.getText());
		    }
		    
		    int ActualCountOfArrivingCities=10;
		    int ExpectedCountOfArrivingCities=elements1.size();
		    Assert.assertEquals("Arriving Cities Count Mismatch",ExpectedCountOfArrivingCities,ActualCountOfArrivingCities);
		    
		    
		    
		    //Selecting Service Class
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();
		    //Selecting Airlines
		    WebElement Airlines = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select"));
		    Select sel5=new Select(Airlines);
		    sel5.selectByIndex(2);
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input")).click();
		    //Selecting Airlines with price
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[9]/td[1]/input")).click();
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input")).click();
		    //driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input")).click();
		    Thread.sleep(3000);
		    //Filling name, address and other details
		    driver.findElement(By.name("passFirst0")).sendKeys("sharvani");
		    driver.findElement(By.name("passLast0")).sendKeys("R H");
		    WebElement Meal1=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[3]/select"));
		    Select sel6 = new Select(Meal1);
		    sel6.selectByValue("VGML");
		    
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td/table/tbody/tr[2]/td[1]/input")).sendKeys("Roshan");
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("H C");
		    WebElement Meal2 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td/table/tbody/tr[2]/td[3]/select"));
		    Select sel7 = new Select(Meal2);
		    sel7.selectByVisibleText("Low Calorie");
		    
		    
		    //Card Details
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("234765897345678");
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[1]/input")).sendKeys("Roshan");
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[3]/input")).sendKeys("H C");
		    WebElement expirymonth = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[3]/select[1]"));
		    Select sel8=new Select(expirymonth);
		    sel8.selectByIndex(4);
		   WebElement expiryyear= driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td/table/tbody/tr[2]/td[3]/select[2]"));
		    Select sel9 = new Select(expiryyear);
		    sel9.selectByIndex(11);
		    
		    //Billing Address
		    WebElement address = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input"));
		    address.clear();
		    address.sendKeys("Unit-702");
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/input")).sendKeys("St Clair Ave West");
		    WebElement City =driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/input"));
		    City.clear();
		    City.sendKeys("Toronto");
		    WebElement postalcode= driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[13]/td[2]/input[2]"));
		    postalcode.clear();
		    postalcode.sendKeys("M4V 1N4");
		    WebElement Country = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/select"));
		    Select sel10 = new Select(Country);
		    sel10.selectByValue("32");
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).click();
		    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[24]/td/input")).click();
		    
		}
	
		
		/*@AfterClass

		public void closeBrowser() {
			driver.close();
			driver.quit();
		}*/

}
