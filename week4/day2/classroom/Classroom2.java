package week4.day2.classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Classroom2 {

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

		Thread.sleep(3000);

		/*
		 * WebDriverWait wait= new WebDriverWait(driver, 10);
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//input[@data-original-title='My Homepage 15']")));
		 */


		String title = driver.getTitle();

		System.out.println("Title of the page :"+title);

		Thread.sleep(5000);

		driver.close();








	}

}
