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

public class OtrDeliveryC3 {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;


	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();


	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\DeliveryClass3Report.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\DeliveryClass3Report.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-DeliveryClass3Report");
		htmlReporter.config().setDocumentTitle("AutomationReport-DeliveryClass3Report");

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
		//			 cap.setCapability("noReset", "true");
		//			cap.setCapability("fullReset", "false");


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


	@Test(description= "Deliver with rule No 1 and 2 Invalid case",priority= 0)

	public void DeliverywithRule1and2() throws InterruptedException {
		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_deliveries");
		el2.click();
		MobileElement waybill = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		waybill.sendKeys("EMER01-40005432.001");
		MobileElement addbtn  = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		addbtn.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_zero");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_eight");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("android:id/button1");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Shutter");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementById("com.android.camera:id/done_button");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_two");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
		el10.click();
		
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp");
		el11.sendKeys("4624");
		MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el12.click();
		MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
		el13.sendKeys("autoTest");
		MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/signature_pad");
		el14.click();
		MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_dnt_hv_sign");
		el15.click();
		MobileElement el16 = (MobileElement) driver.findElementById("android:id/button1");
		el16.click();
		MobileElement el17 = (MobileElement) driver.findElementByAccessibilityId("Shutter");
		el17.click();
		MobileElement el18 = (MobileElement) driver.findElementById("com.android.camera:id/done_button");
		el18.click();
		MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el19.click();
	}
	
	
		@Test(description= "perform non delivery and deliver that parcel",priority= 1)

		public void DeliverywithUsingdrivingLicencestep1() throws InterruptedException {
		/// non dilever
		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el1.sendKeys("HBZB01-20054324.001");
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_address_one");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
		el11.click();
		
		}
		
		
		@Test(description= "perform non delivery and deliver that parcel",priority= 2)

		public void DeliverywithUsingdrivingLicencestep2() throws InterruptedException {
		
		// deliver from non deliver and id driver licence
		MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el3.sendKeys("HBZB01-20054324.001");
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_zero");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_one");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_no_sa_id");
		el8.click();
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el11.click();
		MobileElement el21 = (MobileElement) driver.findElementByAccessibilityId("Shutter");
		el21.click();
		MobileElement el31 = (MobileElement) driver.findElementById("com.android.camera:id/done_button");
		el31.click();
		MobileElement el41 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el41.click();
		MobileElement el51 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
		el51.click();
		MobileElement el61 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
		el61.sendKeys("testdriver");
		MobileElement el71 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el71.click();
		
		}
		
		@Test(description= "perform non delivery and deliver that parcel",priority= 3)

		public void NonDelivery() throws InterruptedException {
		// non dilivry 
		//and pin 
		MobileElement el111 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el111.sendKeys("ONAI01-40005432.001");
		MobileElement el211 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el211.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_zero");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_eight");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_yes");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
		el12.click();
		MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
		el13.click();
		MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
		el14.click();
		
		}
		
		@Test(description= "perform non delivery and deliver that parcel",priority= 4)

		public void DeliveryWithRule16() throws InterruptedException {
		// pin
		MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el15.sendKeys("RAMS02-20054321.001");
		MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el16.click();
		MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el17.click();
		MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp_16");
		el18.sendKeys("123432");
		MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el19.click();
		MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
		el20.click();
		el20.sendKeys("testauto");
		MobileElement el21 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el21.click();
	}
	
	
	
 
}
