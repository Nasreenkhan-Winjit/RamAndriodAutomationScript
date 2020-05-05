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

public class OtrDeleiveryC2 {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;


	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();


	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\DeliveryClass2Report.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\DeliveryClass2Report.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-DeliveryClass2Report");
		htmlReporter.config().setDocumentTitle("AutomationReport-DeliveryClass2Report");

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


	@Test(description= "Deliver with rule No7 Invalid case",priority= 0)

	public void DeliverywithRuleNo7Step1() throws InterruptedException {

		MobileElement OTH_icon = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		OTH_icon.click();
		MobileElement taponDevIcon = (MobileElement) driver.findElementById("com.ram.courier:id/ll_deliveries");
		taponDevIcon.click();
		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el1.sendKeys("W0707910.001");
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_seven");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
		el5.click();


	}

	@Test(description= "Validate OTP field with invalid case",priority= 1)

	public void DeliverywithRuleNo7Step2InvalidOTP() throws InterruptedException {



		driver.findElementById("com.ram.courier:id/et_otp").sendKeys("1181");

		driver.findElementById("com.ram.courier:id/et_otp").clear();

	}

	@Test(description= "Delivery with Rule No7Step3 Valid OTP",priority= 2)

	public void DeliverywithRuleNo7Step3ValidOTP() throws InterruptedException {	

		driver.findElementById("com.ram.courier:id/et_otp").sendKeys("11819");
		driver.findElementById("com.ram.courier:id/btn_scan_proceed").click();
		driver.findElementById("com.ram.courier:id/et_receiver_name").sendKeys("AutoTest");
		driver.findElementById("com.ram.courier:id/btn_proceed").click();

	}




	@Test(description= "GRV Delivery cover rule 5 and 6",priority= 3)

	public void GRVDeliverywithrule5and6 () throws InterruptedException {	



		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el3.sendKeys("J2081929.001");
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_grv");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/et_grv_no");
		el7.click();
		el7.sendKeys("GRV123456");
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receivers_name");
		el8.sendKeys("AutoGrvReceiver");
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_invoice");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el11.click();

	}

	//Validate Back Btn
	@Test(description= "Validate Back Button",priority= 4)

	public void ValidateBackBtn () throws InterruptedException {	
		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el1.sendKeys("J9858033.001");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_back");
		el4.click();
	}




	//GRV only Rule 5

	@Test(description= "GRV Delivery Rule 5",priority= 5)

	public void GRVdeliveryrule5 () throws InterruptedException {	

		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el1.sendKeys("J9858033.001");
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_grv");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp");
		el6.sendKeys("1392");
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/et_name");
		el8.sendKeys("AutoName");
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/et_email");
		el9.click();
		el9.sendKeys("AutoName@mail.com");
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/et_contact_no");
		el10.click();
		el10.sendKeys("12345666");
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el12.click();

	}

	// WithRule No.1and 3
	@Test(description= "Delivery Rule 1 and 3 ",priority= 6)

	public void DeliveryRule1and3 () throws InterruptedException {	


		
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el3.sendKeys("K1781740.001");
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_zero");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_one");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp");
		el9.sendKeys("7857");
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
		el11.sendKeys("AutoTestName");
		MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el12.click();
		MobileElement el13 = (MobileElement) driver.findElementById("android:id/button1");
		el13.click();
		MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el14.click();

	}



	//Rule No.14and 19

	@Test(description= "PAXI Invalid Case",priority= 7)

	public void Paxirule14and19Invalid () throws InterruptedException {	


		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el1.sendKeys("PEPA03-91234569.001");
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("android:id/button1");
		el6.click();
	}

	@Test(description= "PAXI valid with 14 and 19",priority= 8)

	public void Paxirule14and19Valid () throws InterruptedException {	
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/et_cdn_number");
		el10.sendKeys("CDN 0000 0018");
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el11.click();
	}


	// Rule No.12

	@Test(description= "Knock n Drop rule 12 invalid",priority= 9)

	public void KnockNdropInValid () throws InterruptedException {
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el3.sendKeys("RW18220294.001");
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_available");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_place_vacant");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_ok");
		el8.click();

	}

	@Test(description= "Knock n Drop rule 12 invalid",priority= 10)

	public void KnockNdropValid () throws InterruptedException {
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_yes");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_place_vacant");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el11.click();
	}


	

}
