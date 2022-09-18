package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Page class doesnot know what is the value of driver. It will throw nullpointer exception as we are not passing the value for driver. 
	//we need to initialize the webdriver here. But if we create a a new instance of 
		//webdriver it wont use the same instance from Base class. I need same instance of driver. 
		//Hence using a parametrized constructor using the same driver.
	//Create a constructor for the page class. 
	//driver value is coming from my base class
	
	
	public LoginPage(WebDriver basedriver) {
		this.driver = basedriver;
		PageFactory.initElements(basedriver, this);
	}
	
	
	WebDriver driver;
	
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement paswrd;
	
	@FindBy(className = "rememberMe")
	WebElement remebr;
	
	@FindBy(name = "btn_login")
	WebElement loginbtn;
	
	
	
	public void login(String UserVal, String PaswdVal) {
		
		// click on the identified locator
		loginlink.click();

		// Identify username field
		

		// enter the user name to the identified space
		UserName.sendKeys(UserVal);

		// identify password space
	

		// enter the password
		paswrd.sendKeys(PaswdVal);

		// click on remember me check box
		
		remebr.click();

		// click on login button
		
		loginbtn.click();
	}

}
