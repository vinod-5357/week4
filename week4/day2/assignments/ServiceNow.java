package week4.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dev60453.service-now.com/");


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		
		
		WebElement filters = driver.findElementById("filter");
		
		Thread.sleep(5000);
		
		
		filters.sendKeys("change");
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("(//div[text()='Create New'])[3]").click();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("gsft_main");
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//div[@class='container-fluid wizard-container']//a)[1]").click();
		
		Thread.sleep(2000);
		
		WebElement number=  driver.findElementByXPath("//input[@id='change_request.number']");
		
		String text= number.getAttribute("value");
		
		Thread.sleep(2000);
		
		System.out.println("Number :"+text);
		
		
		driver.findElementByXPath("//input[@id='change_request.short_description']").sendKeys("test");
		
	
		
		
		driver.findElementByXPath("//button[@id='sysverb_insert_bottom']").click();
		
		
		
		Thread.sleep(2000);
		
		WebElement input= driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']");
		
		input.sendKeys(text,Keys.ENTER);
		
		Thread.sleep(2000);
		
		
		WebElement preview= driver.findElementByXPath("(//a[@data-list_id='change_request'])[10]");
		
		String text1 = preview.getAttribute("data-popover-title");
		
		System.out.println("Number to verify :"+text1);
		

		
		if(text.contains(text1)) {
			
			System.out.println("Successfully created");
		}
		
		else {
			
			System.out.println("Not created correctly");
		}
		

	}

}
