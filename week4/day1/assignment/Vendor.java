package week4.day1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Vendor {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://acme-test.uipath.com/account/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");

		driver.findElementById("password").sendKeys("leaf@12");

		driver.findElementById("buttonLogin").click();

		WebElement vendor=  driver.findElementByXPath("(//button[@class='btn btn-default btn-lg'])[4]");

		Actions builder= new Actions(driver);

		builder.moveToElement(vendor);


		driver.findElementByLinkText("Search for Vendor").click();


		driver.findElementById("vendorName").sendKeys("Blue Lagoon");

		driver.findElementById("buttonSearch").click();


		String text = driver.findElementByXPath("//table/tbody/tr[2]/td[5]").getText();

		System.out.println("Country name of vendor :"+text);

	}

}
