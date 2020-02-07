package MavenProject.Assignment_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelReader;

public class RegisterationOfMultipleUsers {
	
	@Test(dataProvider="getdata")
	
	public void registertest(String Fname, String Lname, String Phone, String Email,String AddressLine1, String AddressLine2,String City, String Province, String PostalCode,String Country,String UserName, String Password,String ConfirmPassword) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		driver.findElement(By.name("firstName")).sendKeys(Fname);
		driver.findElement(By.name("lastName")).sendKeys(Lname);
		driver.findElement(By.name("phone")).sendKeys(Phone);
		driver.findElement(By.id("userName")).sendKeys(Email);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")).sendKeys(AddressLine1);
        driver.findElement(By.name("address2")).sendKeys(AddressLine2);
	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")).sendKeys(City);
	    driver.findElement(By.name("state")).sendKeys(Province);
	    driver.findElement(By.name("postalCode")).sendKeys(PostalCode);
	    WebElement element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select"));
	    Select sel = new Select(element);
	    sel.selectByVisibleText(Country);
	    driver.findElement(By.id("email")).sendKeys(Email);
	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).sendKeys(Password);
	    driver.findElement(By.name("confirmPassword")).sendKeys(ConfirmPassword);
	    driver.findElement(By.name("register")).click();

}
  @DataProvider(name="getdata",parallel=true)
  
  @Test
  
  public Object[][] getdata(){
	  ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\Resources\\TestData.xlsx");
		String sheetName = "Sheet1";
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		System.out.println("Data---" + excel.getCellData(sheetName, 0, 1));
		System.out.println("Total rows are" + rowNum + "----------Total cols are" + colNum);
		Object[][] data = new Object[rowNum - 1][colNum];
		for (int rows = 2; rows <= rowNum; rows++) {
		for (int cols = 0; cols < colNum; cols++) {
		data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);
		}
		}
		return data;
		
	  
  }
	
	
	
	
	
	
}