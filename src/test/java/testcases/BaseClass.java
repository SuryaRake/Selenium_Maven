package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	WebDriver driver;
	XSSFWorkbook wbook;
	XSSFSheet wsheet;

	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void dataSetUp() throws IOException {

		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		wsheet = wbook.getSheet("Sheet1");

		report = new ExtentReports("ExtentReport.html");

	}

	@AfterTest
	public void dataClean() throws IOException {
		wbook.close();
		report.flush();
		report.close();
		System.out.println("Inside dataclean");

	}

	@BeforeMethod
	public void SetUp(Method method) {

		test = report.startTest(method.getName());

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		// create object for chromedriver

		driver = new ChromeDriver(); // WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://www.simplilearn.com/"); // using the object and get function calling the url

		// maximize the window
		driver.manage().window().maximize();

		// timeout

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	public void TearDown() {
		// close the browser

		report.endTest(test);

		driver.close();
	}

}
