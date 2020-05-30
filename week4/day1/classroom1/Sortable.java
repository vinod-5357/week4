package week4.day1.classroom1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

	

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://jqueryui.com/sortable/");


		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		
		
		WebElement link1 = driver.findElementByXPath("//li[text()='Item 1']");
		
		WebElement link4 =driver.findElementByXPath("//li[text()='Item 4']");
		
		Actions builder = new Actions(driver);
		
		/*
		 * builder.click(link1).clickAndHold().moveToElement(link4).release().perform();
		 */
		
		builder.dragAndDrop(link1, link4).perform();
		
		
	}

}
