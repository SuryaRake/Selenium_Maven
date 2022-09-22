package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class SimplilearnLogin extends BaseClass{
	
	@Test
	public void Test1() {
		test.log(LogStatus.INFO, "Test1 Started");
		
		//Invalid login test case, passing values as parameters.
		
		LoginPage lp = new LoginPage(driver); // Once I create an object of this class, the consturtur will be called immediately. driver value is coming from base class. This will be passed to my constructor
			lp.login("suryaksatheesan@erty.ij", "rtyrtyW@e45");
		
	
		
		//validation of error message
		
		WebElement errormsg = driver.findElement(By.xpath("//div[@id='error_box']"));
		
		
		
		String ActError = errormsg.getText(); // ACtual error message fetched and saved to ActErr
		String ExpError = "Please provide valid email address."; //Expected msg also saved
		
		Assert.assertEquals(ActError, ExpError);
		/*
		if(ActError.equals(ExpError)) {   			//comparing actual and expected
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		*/
		
		//have to find out all hyperlinks on this page 
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The number of links in the page is " + links.size());
		
		//iterate through list and print the attribute having href
		
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getAttribute("href"));
		}
		
	}
	
	@Test
	@Parameters({"uname", "pwd"})
	public void Test2(String Username, String Password) {
		
		test.log(LogStatus.INFO, "Test2 Started");
		
		//valid login test case, passing values from testng.xml
		
		LoginPage lp = new LoginPage(driver); // Once I create an object of this class, the consturtur will be called immediately. driver value is coming from base class. This will be passed to my constructor
		lp.login(Username, Password);
		
	}
	
	@Test
	
	public void Test3() {
		
		test.log(LogStatus.INFO, "Test3 Started");
		
		String UserName = wsheet.getRow(1).getCell(0).getStringCellValue();
		String Password = wsheet.getRow(1).getCell(1).getStringCellValue();
		
		//valid login test case, passing values from excel
		
		LoginPage lp = new LoginPage(driver); // Once I create an object of this class, the consturtur will be called immediately. driver value is coming from base class. This will be passed to my constructor
		lp.login(UserName, Password);
		
	}
	

}
