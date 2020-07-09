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


	@Test(description= "Deliver with rule No 1 and 2 Invalid case",priority= 0)

	public void DeliveryWithRuleNO1N2(){

		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_deliveries");
		el2.click();
		MobileElement addwaybillNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		addwaybillNo.sendKeys("RW1833599.001");
		MobileElement addparcelbtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		addparcelbtn.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp_16");
		el4.sendKeys("1245444");
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_zero");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_one");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_one");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_green_sa_id");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("Shutter");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementById("com.android.camera:id/done_button");
		el12.click();
		MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp");
		el13.sendKeys("12412");
		MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el14.click();
	}


	@Test(description= "perform non delivery and deliver that parcel",priority= 1)

	public void DeliverywithUsingdrivingLicencestep2() throws InterruptedException {



	}

	@Test(description= "perform non delivery and deliver that parcel",priority= 2)

	public void DeliverywithRule16() throws InterruptedException {



		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_deliveries");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el3.sendKeys("AVNI01-U0000021.001");
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("android:id/button1");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp_16");
		el7.sendKeys("1254545");
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
		el9.click();
		MobileElement entervalidOTP = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp_16");
		entervalidOTP .sendKeys("1254545");
		MobileElement proceedtoscan = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		proceedtoscan.click();




	}


}
