package RamTestCases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import RamTestCases.ExtentReportBuilder.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Logout {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;
   
    
	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();
   
    public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();
    
    
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\LogoutReport.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\LogoutReport.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-LogoutReport");
		htmlReporter.config().setDocumentTitle("AutomationReport-LogoutReport");
		
	}
	
	
@BeforeClass
public void beforeClass() throws MalformedURLException, InterruptedException  {
	 
	ExtentTest parent = extent.createTest(getClass().getName());
    parentTest.set(parent);
    
  			DesiredCapabilities cap = new DesiredCapabilities();
		
		// Device configuration

	cap.setCapability("automationName", "Appium");
	cap.setCapability("platformName", "Android");
	cap.setCapability("platformVersion", "10");
	cap.setCapability("deviceName", "vivo 1907");
	//	cap.setCapability("udid", "8XXCCMUCKV7XIVRG");
//  cap.setCapability("autoGrantPermission", "true");
	cap.setCapability("appPackage", "com.ram.courier");
	cap.setCapability("appActivity", "com.ram.courier.activities.SplashScreen");
	cap.setCapability("noReset", "true");
	cap.setCapability("fullReset", "false");
//  cap.setCapability("app","C:/Users/nasreenk/Desktop/Diawi/RAMMobile_UatDebug-2.9.38.apk" );

	driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//	driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//	MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.RadioButton");
//  el1.click();
//  MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save_hub_id");
//  el2.click();
}

@BeforeMethod
public synchronized void beforeMethod(Method method) {
    ExtentTest child = parentTest.get().createNode(method.getName());
    test.set(child);
}

@AfterMethod
public synchronized void afterMethod(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE)
        test.get().fail(result.getThrowable());
    else if (result.getStatus() == ITestResult.SKIP)
        test.get().skip(result.getThrowable());
    else
        test.get().pass("Test passed");

    extent.flush();
}	
	
	
  @Test(description= "click on Logout Button",priority=0)
  public void CaseToVerifyLogoutBtn() {
	  MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_at_the_hub");
	  el1.click();
	  MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_logout");
	  el2.click();
	  MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
	  el3.click();
	  MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
	  el4.click();
	  
  }
  
	  @Test(description= "click on Logoutall Button",priority=1)
	  public void CaseToVerifyLogoutAllBtn() {
	  MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout_all");
	  el5.click();
	  MobileElement el6 = (MobileElement) driver.findElementById("android:id/button2");
	  el6.click();
	  
	  }
	  
	  @Test(description= "Select Member to Logout  ",priority=2)
	  public void SelectMembertoLogoutandClickOnNo() {
		  
		  
//	  MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
	  MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
	  el7.click();
	  MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
	  el8.click();
	  MobileElement el9 = (MobileElement) driver.findElementById("android:id/button2");
	  el9.click();
	  
	  
	  }
	  
	  
	  @Test(description= "Select Member to Logout  ",priority=3)
	  public void SelectMembertoLogoutandClickOnYes() {  
	  
	  MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
	  el10.click();
	  MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
	  el11.click();
	  MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_at_the_hub");
	  el12.click();
	  MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_logout");
	  el13.click();
	  MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
	  el14.click();  
	  
	  //addd change
	  
	  
  }
}
