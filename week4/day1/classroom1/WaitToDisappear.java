package week4.day1.classroom1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitToDisappear {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/disapper.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wait= new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("strong")));

		String text = driver.findElementByTagName("strong").getText();

		System.out.println(text);



	}

}
