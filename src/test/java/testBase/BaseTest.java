package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	public  static WebDriver driver;
	public Logger logger=LogManager.getLogger(this.getClass());
	public Properties p;
	@BeforeClass(groups= {"sanity","master","regression"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException {
		FileInputStream file=new FileInputStream(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		if(p.getProperty("environment").equals("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			switch(os) {
			case "windows":capabilities.setPlatform(Platform.WIN11);break;
			case "mac":capabilities.setPlatform(Platform.MAC);break;
			case "linux":capabilities.setPlatform(Platform.LINUX);break;
			default: System.out.println("Invalid platfrom name");return;
			}
			switch(br) {
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge" :capabilities.setBrowserName("MicrosoftEdge");break;
			case"firefox":capabilities.setBrowserName("firefox");break;
			default:System.out.println("Invalid browser name");return;
			}
			 URL hubUrl = URI.create("http://192.168.62.243:4444/wd/hub").toURL();
			driver=new RemoteWebDriver(hubUrl,capabilities);
		}
		if(p.getProperty("environment").equals("local")) {
		switch(br){
			case "chrome": driver=new ChromeDriver();break;
			case "edge" : driver=new EdgeDriver();break;
			case "firefox" : driver= new FirefoxDriver();break;
			default : System.out.println("Invalid browser name");return;
		}
		}
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
	}
	@AfterClass(groups= {"sanity","master","regression"})
	public void tearDown() {
		driver.quit();
	}
	public String randomString() {
		return RandomStringUtils.secure().nextAlphabetic(6);
	}
	public String randomNumber() {
		
		return RandomStringUtils.secure().nextNumeric(10);	
	}
	public String passWord() {
		String random_str=RandomStringUtils.secure().nextAlphabetic(3);
		String random_num=RandomStringUtils.secure().nextNumeric(3);
		return random_str+random_num;
	}
	public String captureScreenshot(String tname) {
		String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
	File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
	File targetFile=new File(targetFilePath);
    try {
		FileUtils.copyFile(sourcefile, targetFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return targetFilePath;
	}
	
}
