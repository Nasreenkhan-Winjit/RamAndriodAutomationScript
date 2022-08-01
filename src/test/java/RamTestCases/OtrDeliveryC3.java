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
		cap.setCapability("platformVersion", "10");
		cap.setCapability("deviceName", "vivo 1907");
		cap.setCapability("udid", "192.168.0.2:5555");
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


	@Test(description= "Step 1",priority= 0)

	public void prerequisiteStep1forRule16() throws InterruptedException {
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

	@Test(description= "Login with Rule 16 manifest  ", priority = 1 )

	public void prerequisiteStep2forRule16() throws InterruptedException {


		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_login");
		el1.click();

		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/edt_ram_employee_id");
		el7.sendKeys("8802246238084");
		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login");
		el8.click();

		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_crew_members");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ram_id");
		el10.click();
		MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/et_sa_no");
		el13.sendKeys("9512136290082");
		MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_member");
		el14.click();

		MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_to_scan");
		el15.click();


		MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ds");
		el18.click();


		MobileElement el22 = (MobileElement) driver.findElementById("com.ram.courier:id/et_ds_no");
		el22.sendKeys("DDISA15917878517");
		MobileElement el23 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_ds_no");
		el23.click();
		MobileElement el24 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el24.click();
		MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el25.click();

		MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/et_total_parcels");
		el29.sendKeys("5");

		MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/proceed_for_further_sheet");
		el30.click();

		MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/et_registration_no");
		el34.sendKeys("CL08FRGP");
		MobileElement el35 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_veh_no");
		el35.click();

		MobileElement el36 = (MobileElement) driver.findElementById("com.ram.courier:id/et_odometer_reading");
		el36.sendKeys("1234560000");
		MobileElement el37 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_veh_no");
		el37.click();

		MobileElement el38 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_on_the_road");
		el38.click();
		MobileElement el39 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
		el39.click();


	}

	@Test(description= "Deliver with rule No 1 and 2 Invalid case",priority= 2)

	public void enterPODRule16Waybill() {

		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_deliveries");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el3.click();
		el3.sendKeys("AVNI01-U0000020.001");
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el5.click();
		el5.click();
		MobileElement el7 = (MobileElement) driver.findElementById("android:id/button1");
		el7.click();
	}

	@Test(description= "Deliver with rule No 1 and 2 Invalid case",priority= 3)

	public void enterInvalidPIN() {


		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp_16");
		el8.click();
		el8.sendKeys("12414");
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el9.click();

	}

	@Test(description= "Deliver with rule No 1 and 2 Invalid case",priority= 4)

	public void enterValidPIN() {

		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
		el10.click();

		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp_16");
		el11.clear();
		el11.sendKeys("7536");
		MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el12.click();
		MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_fname");
		el13.click();
		el13.sendKeys("PODTesterFN");

		MobileElement lastName = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_lname");
		lastName.sendKeys("PODDeliveryLN");

		MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el14.click();



	}
	@Test(description= "perform non delivery and deliver that parcel",priority= 5)

	public void NonDeliverywithRule16Rain() throws InterruptedException {
		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el1.click();
		el1.sendKeys("AVNI01-U0000021.001");
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("android:id/button1");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp_16");
		el6.click();
		el6.sendKeys("57241");
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el7.click();
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_yes");
		el9.click();
		MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
		el14.click();
		MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el15.click();
		MobileElement el16 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]");
		el16.click();
		MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el17.click();
		MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
		el18.click();
		MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el19.click();
		MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
		el20.click();
		MobileElement el21 = (MobileElement) driver.findElementById("android:id/button1");
		el21.click();

	}

	@Test(description= "perform non delivery and deliver that parcel",priority= 6)

	public void NonDeliverywithNoRequiremnet() throws InterruptedException {
//		MobileElement el119 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//		el119.click();

		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el11.sendKeys("RW1833599.001");
		MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el12.click();
		MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
		el13.click();
		MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
		el14.click();
		MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el15.click();
		MobileElement el16 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]");
		el16.click();
		MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el17.click();
		MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
		el18.click();
		MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el19.click();
		MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
		el20.click();
		MobileElement el21 = (MobileElement) driver.findElementById("android:id/button1");
		el21.click();
	}
}
