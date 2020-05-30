package week4.day1.classroom1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlert {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/alertappear.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//button[text()='Click to get Alert']").click();

		WebDriverWait wait= new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();


		String text = alert.getText();

		System.out.println(text);

		alert.accept();







	}

}
