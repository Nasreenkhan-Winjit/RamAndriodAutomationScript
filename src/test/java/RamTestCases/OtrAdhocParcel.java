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

public class OtrAdhocParcel {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;


	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();


	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\AdhocParcel.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\AdhocParcel.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-AdhocParcel");
		htmlReporter.config().setDocumentTitle("AutomationReport-AdhocParcel");

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
		//		cap.setCapability("udid", "8XXCCMUCKV7XIVRG");
//		cap.setCapability("autoGrantPermission", "true");
		cap.setCapability("appPackage", "com.ram.courier");
		cap.setCapability("appActivity", "com.ram.courier.activities.SplashScreen");
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");


		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		//		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		//		MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.RadioButton");
		//	el1.click();
		//	MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save_hub_id");
		//	el2.click();
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

	@Test(description= "Click on proceed btn without check clicking on checkbox",priority= 0)

	public void AdhocParcelInvalidProceedBtn () throws InterruptedException {
	
		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_adhoc_collection");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
		el4.click();
	}
		
		
	@Test(description= "Click on proceed btn without check clicking on checkbox",priority= 1)

	public void AdhocParcelInvalidParcelID () throws InterruptedException {	
		
				
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el6.sendKeys("SAISA123456");
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el7.click();
	}
	
	
	
	@Test(description= "Added two parcel ",priority= 2)

	public void AdhocParcelValidParcelID () throws InterruptedException {	
		
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el8.sendKeys("SAISA1234567.001");
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el10.sendKeys("SAISA1234567.002");
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el12.click();
	}
		
	@Test(description= "Added two parcel and Confirm No. of Parcel ",priority= 3)

	public void AdhocParcelValidParcelConfirmation () throws InterruptedException {		
		
		MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/et_parcel_count");
		el13.click();
		el13.sendKeys("2");
		MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/et_sender_name");
		el14.sendKeys("AutoTest");
		MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save");
		el15.click();
		
	}
	
	
	@Test(description= "Invalid case try to add existing parcel",priority= 4)

	public void AddExistingParcel () throws InterruptedException {		
			
	MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_adhoc_collection");
	el1.click();
	
	MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el4.sendKeys("MOTC01-20054322.001");
	MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el5.click();
	MobileElement el6 = (MobileElement) driver.findElementById("android:id/button1");
	el6.click();
	MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el7.sendKeys("HBZB01-20054324.001");
	MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el8.click();
	MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
	el9.click();


	
	}

//	#COL00197014
@Test(description= "When user want to addhoc parcel #COL",priority= 5)

public void AddParcelWithCOL () throws InterruptedException {

	MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el7.sendKeys("#COL00197014.001");
	MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el8.click();
	MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
	el9.click();

	MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el10.sendKeys("COL00897014.001");
	MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el11.click();
	MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
	el12.click();

}
	
	@Test(description= "Add New Parcel ",priority= 6)

	public void AddNewParcel () throws InterruptedException {
	
	MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el10.sendKeys("SIDDSA01231.001");
	MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el11.click();
	MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	el12.click();
	}
	
	@Test(description= "Invalid caseto confirm No. of Parcel",priority= 7)

	public void InvalidConfirmNoOfParcel () throws InterruptedException {	
	
	
	MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/et_sender_name");
	el13.sendKeys("AutoSender");
	MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save");
	el14.click();
	}
	
	
	@Test(description= "Valid ConfirmNo. of Parcel",priority= 8)

	public void ValidConfirmNoOfParcel () throws InterruptedException {	
		
		
	MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/et_parcel_count");
	el15.sendKeys("1");
	MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/et_sender_name");
	el16.clear();
	MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save");
	el17.click();
	MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/et_sender_name");
	el18.sendKeys("Autosender");
	MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save");
	el19.click();
}

	@Test(description= "Validate collection turned to geen when add from AdhocParcel ",priority=9 )

	public void ValidateCollectionfromAdhocParcel () throws InterruptedException {

		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_adhoc_collection");
		el1.click();
		// ADD waybill Number from collection screen
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el2.sendKeys("RW1833183111.001");
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/et_parcel_count");
		el5.click();
		el5.sendKeys("1");
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/et_sender_name");
		el6.sendKeys("Tester");
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_collections");
		el8.click();

}
}
