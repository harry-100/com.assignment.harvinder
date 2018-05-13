package com.base;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import javax.mail.MessagingException;
	import javax.mail.internet.AddressException;

	import org.apache.commons.io.FileUtils;
	import org.apache.log4j.Logger;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.*;
 
import org.testng.annotations.DataProvider;



	public class BaseClass {

		public static Properties config = new Properties();
		
		public static WebDriver driver;
	//	public static Logger app_logs = Logger.getLogger("BaseClass");
		
	//	@BeforeSuite()
		@BeforeClass()
		public static void init() throws IOException {
				
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
					config.load(fis);
			//		app_logs.debug("loading the config property file");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\harvi\\eclipse-workspace\\com.assignment.harvinder\\src\\test\\resources\\browser_drivers\\chromedriver.exe");
				
				driver = new ChromeDriver();
				driver.get(config.getProperty("testsiteURL"));
				driver.manage().window().maximize();

				// Global implicit Wait
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			
		}

	//	@AfterSuite()
		@AfterClass()
		public static void tearDown() throws AddressException, MessagingException, IOException {
			//MonitoringMail mail = new MonitoringMail();
			String fileName = getRandomString(10) + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\harvi\\eclipse-workspace\\com.assignment.harvinder\\src\\test\\resources\\screenshots\\" +fileName));
			//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
			//		TestConfig.attachmentPath, TestConfig.attachmentName);
			driver.quit();
		}
		
		public static String getRandomString(int length) {
			StringBuilder sb = new StringBuilder();
			String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			for (int i = 0; i < length; i++) {
				int index = (int) (Math.random() * characters.length());
				sb.append(characters.charAt(index));
			}
			return sb.toString();
		}
		
	/*	@DataProvider()
		public Object[][] getData() {
			String sheetName = "LoginTest";
			int rows = excel.getRowCount(sheetName);
			int cols = excel.getColumnCount(sheetName);
			Object data[][] = new Object[rows - 1][cols];
			for (int rowNum = 2; rowNum <= rows; rowNum++) {

				for (int colNum = 0; colNum < cols; colNum++) {
					data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				}
			}
			return data;
		
		}
		
		
	}  */
}
