package week4.day1.classroom1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");



		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.snapdeal.com/");


		driver.manage().window().maximize();

		Thread.sleep(1000);


		WebElement men =driver.findElementByXPath("//div[@id='leftNavMenuRevamp']/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]");


		Actions builder= new Actions(driver);

		builder.moveToElement(men).click().perform();



		driver.findElementByXPath("(//span[text()='Shirts'])[2]").click();


		Thread.sleep(1000);


		WebElement First= driver.findElementByXPath("(//img[@class='product-image '])[1]");

		builder.moveToElement(First).perform();


		driver.findElementByXPath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]").click();


		driver.findElementByXPath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]").click();

		Thread.sleep(2000);

		driver.close();


	}

}
