package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1_JobBoardTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Before("@JobBoard_activity")
    public void initilize()
    {
    	System.setProperty("webdriver.gecko.driver", "C:\\IBM\\SDET\\CucumberProject\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 60);
    }
    
    @After("@JobBoard_activity")
    public void closeBrowser()
    {
    	driver.close();
    }
    
	
	  String
	  url="https://alchemy.hguy.co/jobs/wp-login.php?loggedout=true&wp_lang=en_US";
	  
	  @Given("^User is on Alchemey the Login Page$") 
	  public void login() {
		  driver.get(url); driver.findElement(By.id("user_login")).sendKeys("root");
		  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd",Keys.ENTER); 
		  }
	  
	  @When("^User clicks on Add New button and Add New User$") 
	  public void addNewUser() { 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='WordPress Events and News']")));
		WebElement  addUser=driver.findElement(By.xpath("//div[text()='Users']"));
		wait.until(ExpectedConditions.elementToBeClickable(addUser));
		addUser.click(); 
		driver.findElement(By.linkText("Add New")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("createusersub")));
		driver.findElement(By.id("user_login")).sendKeys("TestUser132");
		driver.findElement(By.id("email")).sendKeys("TestUser132@yopmail.com");
		driver.findElement(By.id("first_name")).sendKeys("FNTest");
		driver.findElement(By.id("last_name")).sendKeys("LNTest");
		driver.findElement(By.xpath("//button[text()='Show password']")).click();
		driver.findElement(By.id("pass1")).clear();
		driver.findElement(By.id("pass1")).sendKeys("Me229159@");
		driver.findElement(By.name("pw_weak")).click();
		driver.findElement(By.id("createusersub")).click();
	  }
	  
	  @Then("^Verify the user was created$") 
	  public void VerifyUser() {
	  
		  wait.until(ExpectedConditions.elementToBeClickable(By.id("user-search-input")));
		  driver.findElement(By.id("user-search-input")).sendKeys("TestUser132",Keys.ENTER); 
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='TestUser132@yopmail.com']")));
		  if(driver.findElement(By.xpath("//a[text()='TestUser132@yopmail.com']")).getText().equals("TestUser132@yopmail.com")) 
		  {
			  System.out.println("User Created Successfully"); 
		  }else {
			  System.out.println("User Not Created");
			  } 
		 }
	  
	 
    @Given("^User is on Alchemey jobs site$")
    public void jobPage()
    {
    	driver.get("https://alchemy.hguy.co/jobs/");
    	
    }
    
    @When("^User searches for job$")
    public void searchJob() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Jobs")));
    	driver.findElement(By.linkText("Jobs")).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='search_keywords']")));
    	driver.findElement(By.id("search_keywords")).sendKeys("Test Engineer",Keys.ENTER);
    	List<WebElement> jobType=driver.findElements(By.xpath("//input[contains(@id,'job_type')]"));
    	
    	for(WebElement job:jobType)
    	{
    		String value=job.getAttribute("value");
    		if(!value.equals("full-time"))
    		{
    			job.click();
    		}
    	}
    	
    	
    }
    @Then("^Apply for job$")
    public void applyJob() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='button']")));
    	driver.findElement(By.xpath("//h3[text()='Automation test Specialist']")).click();
    	String jobTitle=driver.findElement(By.className("entry-title")).getText();
    	System.out.println("Job Title:" +jobTitle);
    	driver.findElement(By.xpath("//input[contains(@class,'application_button')]")).click();
    	String appDetails=driver.findElement(By.className("application_details")).getText();
    	System.out.println("Application Details:"+appDetails);
    }
   
    
    @When("^Post Job tiltle as \"(.*)\" Description as \"(.*)\" email as \"(.*)\"$")
    public void postJob(String jobTitle, String description, String email) {
    	driver.findElement(By.linkText("Post a Job")).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("create_account_email")));
    	driver.findElement(By.id("create_account_email")).sendKeys(email);
    	driver.findElement(By.id("job_title")).sendKeys(jobTitle);
    	driver.switchTo().frame("job_description_ifr");
    	driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(description);
    	driver.switchTo().defaultContent();
    	driver.findElement(By.id("application")).sendKeys(email);
    	driver.findElement(By.id("company_name")).sendKeys("IBM");
    	driver.findElement(By.name("submit_job")).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
    	driver.findElement(By.name("continue")).click();
    }
    
    @Then("^Verify Job with tiltle \"(.*)\" is listing$")
    public void verifyJobPosting(String jobTitle) {
    	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("click here")));
    	driver.findElement(By.linkText("click here")).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.className("entry-title")));
    	String actualjobTittle=driver.findElement(By.className("entry-title")).getText();
    	assertEquals(jobTitle, actualjobTittle);
    }
    
    
}
