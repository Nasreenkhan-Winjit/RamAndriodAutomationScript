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

public class OtrHandoverParcel {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;


	public ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();


	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\HandoverParcel.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\HandoverParcel.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-HandoverParcel");
		htmlReporter.config().setDocumentTitle("AutomationReport-HandoverParcel");

	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException, InterruptedException {

		ExtentTest parent = extent.createTest(getClass().getName());
		parentTest.set(parent);

		DesiredCapabilities cap = new DesiredCapabilities();

		// Device configuration

		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("deviceName", "vivo 1907");
		cap.setCapability("udid", "8XXCCMUCKV7XIVRG");
//		cap.setCapability("autoGrantPermission", "true");
		cap.setCapability("appPackage", "com.ram.courier");
		cap.setCapability("appActivity", "com.ram.courier.activities.SplashScreen");
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");


		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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


	@Test(description = "Tap on Next btn without check clicking on CheckBox", priority = 0)

	public void HPVerifyNextBtn() throws InterruptedException {

		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el1.click();

		MobileElement el22 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
		el22.click();

//	MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//	el4.click();
//	MobileElement el13 = (MobileElement) driver.findElementById("android:id/button1");
//	el13.click();
//
	}


	@Test(description = "Click On Proceed btn", priority = 1)

	public void InValidHPProceedbtn() throws InterruptedException {

		MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el5.sendKeys("A0350538.001");
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el7.click();
		driver.findElementById("android:id/button1").click();

	}

	@Test(description = "Validate with sign", priority = 2)

	public void InValidHPProceedsameNameWithoutSign() throws InterruptedException {

		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
		el12.click();
		MobileElement el13 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
		el13.click();
		MobileElement el14 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el14.click();
		MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
		el15.click();
		MobileElement el16 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
		el16.click();
		MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
		el17.click();
		MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
		el18.click();
		MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el19.click();
		MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
		el20.click();
		MobileElement el21 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
		el21.click();
		MobileElement el22 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el22.click();
		MobileElement el23 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]");
		el23.click();
		MobileElement el24 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
		el24.click();
		MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
		el25.click();
		MobileElement el26 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el26.click();
		MobileElement el27 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
		el27.click();
		MobileElement el28 = (MobileElement) driver.findElementById("android:id/button1");
		el28.click();
		MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
		el29.click();
	}

//	@Test(description= "Valid Parcel ID",priority= 3)
//
//	public void ValidHPParcel () throws InterruptedException {


//		MobileElement el161 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
//		el161.click();
//		MobileElement el171 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
//		el171.click();
//		MobileElement el181 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
//		el181.click();
//		MobileElement el191 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//		el191.click();
//		MobileElement el201 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
//		el201.click();
//		MobileElement el211 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
//		el211.click();
//		MobileElement el221 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//		el221.click();
//		MobileElement el231 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]");
//		el231.click();
//		MobileElement el241 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
//		el241.click();
//		MobileElement el251= (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
//		el251.click();
//		MobileElement el261 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//		el261.click();
//		MobileElement el271 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
//		el271.click();
//		MobileElement el281 = (MobileElement) driver.findElementById("android:id/button1");
//		el281.click();
//		MobileElement el291 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
//		el291.click();
//	}


	@Test(description = "Validate with second ID", priority = 3)

	public void ValidHPParcelasignstep1() throws InterruptedException {

		MobileElement el26 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el26.click();
		MobileElement el27 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
		el27.click();
		MobileElement el28 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el28.click();
		MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
		el29.click();
		MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el30.click();

	}


	@Test(description = "Validate assign Step2", priority = 4)

	public void ValidHPParcelasignstep2() throws InterruptedException {

		MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el31.sendKeys("AFRI02-00021571.001");
		MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el32.click();
		MobileElement el33 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el33.click();
		MobileElement el34 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout");
		el34.click();
		MobileElement el35 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el35.click();
		MobileElement el36 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
		el36.click();
		MobileElement el37 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el37.click();
		MobileElement el38 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
		el38.click();
		MobileElement el291 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
		el291.click();

	}

	@Test(description = "Validate assign Step2", priority = 5)
	public void GRVParcelToHandover() {

		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el5.click();
		el5.sendKeys("J2081929.001");
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
		el12.click();
		MobileElement el13 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
		el13.click();
		MobileElement el14 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
		el14.click();
		MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
		el15.click();
		MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el16.click();
		MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el17.click();
		el17.click();
		MobileElement el18 = (MobileElement) driver.findElementById("android:id/button1");
		el18.click();
		MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
		el19.click();
		el19.sendKeys("Tester");
	}
	@Test(description = "Validate assign Step2", priority = 6)
	public void DeliverHandoverParcel() {
		MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/et_time_of_delivery_mm");
		el20.click();
		MobileElement el21 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.Button[1]");
		el21.click();
		MobileElement el22 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.Button[1]");
		el22.click();
		MobileElement el23 = (MobileElement) driver.findElementById("android:id/button1");
		el23.click();
		MobileElement el24 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
		el24.click();
//		MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_grv");
//		el25.click();
		MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_five");
		el25.click();
		MobileElement el26 = (MobileElement) driver.findElementById("com.ram.courier:id/et_grv_no");
		el26.click();
		el26.sendKeys("TesterGRV1234");
		MobileElement el27 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receivers_name");
		el27.sendKeys("GRVReceiver");
		MobileElement el28 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan");
		el28.click();
//		MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_invoice");
		MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_six");
		el29.click();
//		MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
		el30.click();
		MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
		el31.click();

	}


	@Test(description = "Validate assign Step2", priority = 7)
	public void DeliverGrpHandoverParcel() {
		MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el32.click();
		MobileElement el33 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
		el33.click();
		MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el34.click();
		MobileElement el35 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
		el35.click();
		MobileElement el36 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el36.click();
		MobileElement el37 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el37.click();
		el37.sendKeys("CELLC11663226.001");
		MobileElement el38 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el38.click();
		MobileElement el39 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el39.sendKeys("CELLC11663226.002");
		MobileElement el40 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el40.click();
		MobileElement el41 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el41.sendKeys("CELLC11663226.003");
		MobileElement el42 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el42.click();
		MobileElement el43 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el43.sendKeys("CELLC11663226.004");
		MobileElement el44 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el44.click();
		el44.click();
		MobileElement el45 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el45.click();
		MobileElement el46 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
		el46.click();
		MobileElement el47 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el47.click();
		MobileElement el48 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
		el48.click();
		MobileElement el49 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el49.click();
		MobileElement el50 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");

		el50.click();


	}
	@Test(description = "Validate assign Step2", priority = 8)
	public void EnterReceiverName() {
		MobileElement el51 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
		el51.click();
		MobileElement el52 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
		el52.click();
		MobileElement el53 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
		el53.click();
		MobileElement el54 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el54.click();
		MobileElement el55 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		el55.click();
		MobileElement el56 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout");
		el56.click();
		MobileElement el58 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout");
		el58.click();
		MobileElement el119 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
		el119.click();
		el119.sendKeys("GrpTester");
		MobileElement el62 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
		el62.click();

	}


	@Test(description = "Validate assign Step2", priority = 9)
	public void EnterHandoverParcel2() {
		MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
		el31.click();
		MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el32.click();
		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el4.click();
		el4.sendKeys("W0707910.001");
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
		el11.click();
	}

	@Test(description = "Validate assign Step2", priority = 10)
	public void EnterReceiverNametoDeliverHandoverPrcl() {

	MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
el12.click();
	MobileElement el13 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
el13.click();
	MobileElement el14 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
el14.click();
	MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
el15.click();
	MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
el16.click();
	MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
el17.click();
el17.sendKeys("RAMDelivery");
	MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
el18.click();


}

}
