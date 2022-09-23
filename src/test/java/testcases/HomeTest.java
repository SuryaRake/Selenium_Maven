package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HomeTest extends BaseClass{
	
	@Test
	public void Test1() {
		test.log(LogStatus.INFO, "HomeTest Started");
		
		System.out.println("Inside home testcase");
		
	}

}
