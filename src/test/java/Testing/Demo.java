package Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static WebDriver driver;
	public static Actions operation;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	public static String CPT99091, CPT99474, CPT99453, CPT99454;

	@Test
	public static void test1() throws InterruptedException {

		WebDriverManager.chromedriver().driverVersion("131.0.6778.86").setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://fitpeo.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {

			WebElement Revenuecalculator = driver.findElement(By.xpath("//*[text()='Revenue Calculator']"));
			operation = new Actions(driver);
			operation.moveToElement(Revenuecalculator).click().perform();
			Thread.sleep(3000);

		} catch (Exception e1) {
			driver.findElement(By.xpath("//*[@to='/revenue-calculator']")).click();
			e1.printStackTrace();
		}

		// Scroll Down to the Slider section
		scrolltoelement(250);
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//*[@title='Close message']")).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			WebElement slider = driver.findElement(By.xpath("(//input[@id=':r0:'])[1]"));
			slider.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(3000);
			slider.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(3000);
			slider.sendKeys("560");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scrolltoelement(550);
		Thread.sleep(3000);

		CPT99091 = driver.findElement(By.xpath(
				"(//*[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1s3unkt'])[1]"))
				.getText();
		System.out.println("Select cpt num is :" + CPT99091);

		driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
		Thread.sleep(2000);

		CPT99453 = driver.findElement(By.xpath(
				"(//*[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1s3unkt'])[2]"))
				.getText();
		System.out.println("Select cpt num is :" + CPT99453);
		driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
		Thread.sleep(2000);

		String CPT99454 = driver.findElement(By.xpath(
				"(//*[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1s3unkt'])[3]"))
				.getText();
		System.out.println("Select cpt num is :" + CPT99454);

		driver.findElement(By.xpath("(//*[@type='checkbox'])[3]")).click();
		Thread.sleep(2000);

		scrolltoelement(500);
		Thread.sleep(3000);

		CPT99474 = driver.findElement(By.xpath(
				"(//*[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1s3unkt'])[8]"))
				.getText();
		System.out.println("Select cpt num is :" + CPT99474);
		driver.findElement(By.xpath("(//*[@type='checkbox'])[8]")).click();
		Thread.sleep(2000);

		String TRR_Per_Month = driver.findElement(By.xpath("(//p)[8]")).getText().trim();
		System.out.println("Total Recurring Reimbursement for all Patients Per Month: :" + TRR_Per_Month);

		String extractedNumber = TRR_Per_Month.replaceAll("[^0-9]", "");
		System.out.println("Extracted Number: " + extractedNumber);

		Thread.sleep(2000);
		 driver.quit();

	}

	public static void scrolltoelement(int value) {
		try {
			js.executeScript("window.scrollTo(0, " + value + ")");
			Thread.sleep(2000);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
