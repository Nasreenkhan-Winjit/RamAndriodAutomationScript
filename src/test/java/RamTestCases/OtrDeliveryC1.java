package RamTestCases;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

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

public class OtrDeliveryC1 {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;


	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();


	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\DeliveryC1Report.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\DeliveryC1Report.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-DeliveryC1Report");
		htmlReporter.config().setDocumentTitle("AutomationReport-DeliveryC1Report");

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


	@Test(description= "To verify home screen",priority= 0)

	public void VerifyNextBtn () throws InterruptedException {

		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_deliveries");
		el2.click();

		driver.findElementById("com.ram.courier:id/btn_next_deliveries").click();

		driver.findElementById("android:id/button1").click();
		
	}

	@Test(description= "Enter Invalid Parcel No.",priority= 1)

	public void DeliveryCase1InvalidParcel () throws InterruptedException {

		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el2.sendKeys("A0350538");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("android:id/button1");
		el3.click();
		
	}
		
	@Test(description= "Enter In valid Parcel",priority= 2)

	public void DeliveryvalidParcelNo () throws InterruptedException {	
		
		
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el4.sendKeys("A0350538.001");
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el5.click();
	}
	
	@Test(description= "Verify Delivery Button",priority= 3)

	public void TapOnDeliveryBtnCompleteProcess () throws InterruptedException {	
		
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
		el8.click();
		MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_name");
		el15.sendKeys("AutoTest");
		MobileElement Proceedbtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		Proceedbtn.click();
	}
	
	@Test(description= "No Dilivery Button",priority= 4)

	public void NonDeliveryCompleteProcess () throws InterruptedException {	

		MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
		el6.click();
		driver.findElementById("com.ram.courier:id/btn_next_deliveries").click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el7.sendKeys("AFRI02-00021571.001");
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el8.click();
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el10.sendKeys("AFRI02-00021571.001");
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el12.click();
		MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
		el13.click();
		MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
		el14.click();
		MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el15.click();
		MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
		el16.click();
		MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el17.click();
		MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
		el18.click();
		MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el19.click();
		MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
		el20.click();
		MobileElement el21 = (MobileElement) driver.findElementById("android:id/button1");
		el21.click();
		
		
	}	
	
	@Test(description= "GroupDelivery",priority= 5)

	public void GroupDelivery() throws InterruptedException {	

	
	MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/cbAgree");
	el1.click();
	driver.findElementById("com.ram.courier:id/btn_next_deliveries").click();
	MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
	el2.click();
	MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el4.sendKeys("PLAT05-90023456.001");
	MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el5.click();
	MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el6.sendKeys("PLAT05-92234567.001");
	MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el7.click();
	MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el8.sendKeys("PLAT05-94123456.001");
	MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el9.click();
	MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	el10.click();
	MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
	el11.click();
	MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
	el12.click();
	MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
	el13.sendKeys("Autotest");
	MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	el14.click();
	
	
	}
	
	
}
