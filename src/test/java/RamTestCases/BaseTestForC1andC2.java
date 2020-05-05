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

public class BaseTestForC1andC2 {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;
   
    
	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();
   
    public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();
    
    
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\BaseTestforC1NC2Report.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\BaseTestforC1NC2Report.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-BaseTestforC1NC2Report");
		htmlReporter.config().setDocumentTitle("AutomationReport-BaseTestforC1NC2Report");
		
	}
	
	
@BeforeClass
public void beforeClass() throws MalformedURLException, InterruptedException  {
	 
	ExtentTest parent = extent.createTest(getClass().getName());
    parentTest.set(parent);
    
  			DesiredCapabilities cap = new DesiredCapabilities();
		
		// Device configuration
		
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");	
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "Vivo");
		cap.setCapability("udid", "8SSCCMUCKV7SIVRG");  
		cap.setCapability("autoGrantPermission", "true");
		cap.setCapability("appPackage", "com.ram.courier");
		 cap.setCapability("appActivity", "com.ram.courier.activities.SplashScreen");
		 cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");
//		cap.setCapability("app","C:/Users/nasreenk/Desktop/Diawi/RAMMobile_UatDebug-2.9.23-2.apk" );
	
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
//	driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//	MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.RadioButton");
//el1.click();
//MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save_hub_id");
//el2.click();
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
	
@Test(description= "To verify home screen",priority= 0)

public void AtTheHub () throws InterruptedException {
	Thread.sleep(2000);
	MobileElement ATTheHub = (MobileElement) driver.findElementById("com.ram.courier:id/ll_at_the_hub");
	ATTheHub.isEnabled();
	 

	 driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
		
		//// Permission
//			 driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//			 driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//			 driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//			 driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			
}

  @Test(description= "validate Login by entering 12", priority = 1 )
  
  public void PreRequisiteforC1andC2OTHModule() throws InterruptedException {
	  
	  
	  MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_login");
	  el1.click();
	 
	  MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/edt_ram_employee_id");
	  el7.sendKeys("7301310157081");
	  MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login");
	  el8.click();
	  
	  MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_crew_members");
	  el9.click();
	  MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ram_id");
	  el10.click();
	  MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/et_sa_no");
	  el13.sendKeys("7009155154085");
	  MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_member");
	  el14.click();
	 	  
	  MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_to_scan");
	  el15.click();
	  

	  MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ds");
	  el18.click();

	 
	  MobileElement el22 = (MobileElement) driver.findElementById("com.ram.courier:id/et_ds_no");
	  el22.sendKeys("DDISA15816827824");
	  MobileElement el23 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_ds_no");
	  el23.click();
	  MobileElement el24 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	  el24.click();
	  MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	  el25.click();

	  MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/et_total_parcels");
	  el29.sendKeys("18");
	 	  
	  MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/proceed_for_further_sheet");
	  el30.click();
	  
	  MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/et_registration_no");
	  el34.sendKeys("CL08FRGP");
	  MobileElement el35 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_veh_no");
	  el35.click();
	  
	  MobileElement el36 = (MobileElement) driver.findElementById("com.ram.courier:id/et_odometer_reading");
	  el36.sendKeys("123456");
	  MobileElement el37 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_veh_no");
	  el37.click();
	  
	  MobileElement el38 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_on_the_road");
	  el38.click();
	  MobileElement el39 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
	  el39.click();
	 
	 
  }
	
}


