package week4.day2.classroom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Classroom3 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Thread.sleep(2000);

		driver.findElementByXPath("(//button[@class='btn btn-primary'])[1]").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();

		String trainWindow = driver.getWindowHandle();

		Set<String> TrainAndFlight = driver.getWindowHandles();

		List<String> listHandles = new ArrayList<String>(TrainAndFlight);

		String flightWindow = listHandles.get(1);

		driver.switchTo().window(flightWindow);

		Thread.sleep(3000);

		WebElement checkbox = driver.findElementById("agree");

		Actions builder = new Actions(driver);

		builder.click(checkbox).perform();

		driver.findElementByXPath("//button[text()='Continue ']").click();

		File source = driver.getScreenshotAs(OutputType.FILE);

		File target = new File("./snaps/test.png");

		FileUtils.copyFile(source, target);

		WebDriver window = driver.switchTo().window(trainWindow);

		window.close();

	}

}
