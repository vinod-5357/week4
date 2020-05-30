package week4.day2.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.nykaa.com/");


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);

		WebElement brands= driver.findElementByXPath("//a[text()='brands']");

		Actions builder = new Actions(driver);

		Actions brand1 = builder.moveToElement(brands);

		brand1.perform();

		Thread.sleep(1000);

		WebElement popular= driver.findElementByXPath("//div[@class='BrandsCategoryHeading']//a[1]");
		Actions popularEle = builder.moveToElement(popular);

		popularEle.perform();

		Thread.sleep(1000);

		WebElement loreal = driver.findElementByXPath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']");

		Actions Loreal=builder.moveToElement(loreal);

		Loreal.click().perform();

		Thread.sleep(2000);

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> listHandles = new ArrayList<String>(windowHandles);

		String lorealwindow = listHandles.get(1);

		driver.switchTo().window(lorealwindow);

		Thread.sleep(2000);

		String title = driver.getTitle();

		System.out.println("title of new window :"+title);

		driver.findElementByXPath("//i[@class='fa fa-angle-down']").click();


		Thread.sleep(2000);

		driver.findElementByXPath("(//div[@class='control__indicator radio'])[4]").click();

		Thread.sleep(2000);

		driver.findElementByXPath("(//div[@class='filter-sidebar__filter-title pull-left'])[1]").click();

		Thread.sleep(2000);

		driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined']//div)[1]").click();

		Thread.sleep(2000);

		WebElement addToBag= driver.findElementByXPath("//div[@id='listingContainer']/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/a[1]/div[1]/div[2]");



		builder.moveToElement(addToBag).perform();

		driver.findElementByXPath("(//button[text()='ADD TO BAG'])[2]").click();


		Thread.sleep(2000);

		driver.findElementByXPath("//div[@class='AddBagIcon']").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//button[@type='button']//span[1]").click();

		Thread.sleep(1000);

		String text =
				driver.findElementByXPath("//div[text()='We are not accepting orders of subtotal less than 500']").getText();



		System.out.println("Following Error receiving by clicking on proceed :"+text);


	}

}
