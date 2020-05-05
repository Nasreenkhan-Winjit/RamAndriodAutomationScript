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

public class OtrCollection {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;


	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();


	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\CollectionReport.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\CollectionReport.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-CollectionReport");
		htmlReporter.config().setDocumentTitle("AutomationReport-CollectionReport");

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

	@Test(description= "Click on Rturn to Hub icon for pending collection, popup will appear click 'ok' ",priority= 0)

	public void CaseToVerifyRejectCollection() throws InterruptedException {

	MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
	el1.click();
	MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_collections");
	el2.click();
	MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.support.v7.app.ActionBar.Tab[@content-desc=\"Pending(3)\"]/android.widget.TextView");
	el3.click();
	MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
	el4.click();
	MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
	el5.click();
	MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_reject");
	el6.click();
	MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_reason2");
	el7.click();
	
	
	
	}
	
	@Test(description= "Click on Next Button ' ",priority= 1)

	public void CaseToVerifyNextBtn() throws InterruptedException {	
	
	MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("Pending(2)");
	el8.click();
	el8.click();
	MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
	el9.click();
	MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
	
	el10.click();
	
	}
	
	
	
	@Test(description= "Click on Next Button ' ",priority= 1)

	public void CaseToVerifyAcceptCollection() throws InterruptedException {	
	
	
	MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
	el11.click();
	MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
	el12.click();
	MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_accept");
	el13.click();
	
	
	
	}
	
	@Test(description= "Click on Next Button ' ",priority= 1)

	public void CaseToVerifySelectConsignmentforMissedCollection() throws InterruptedException {	
	
	
	MobileElement el14 = (MobileElement) driver.findElementByAccessibilityId("Collection");
	el14.click();
	MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
	el15.click();
	MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
	el16.click();
	MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_missed");
	el17.click();
	MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
	el18.click();
	}
	
	@Test(description= "Reason-Collection Alredy collected ' ",priority= 1)

	public void CaseToVerifySelectConsignmentforMissedCollectionReason1n2() throws InterruptedException {	
	
	
	MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
	el19.click();
	MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_missing_collection");
	el20.click();
	MobileElement el21 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
	el21.click();
	MobileElement el22 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
	el22.click();
	MobileElement el23 = (MobileElement) driver.findElementById("com.ram.courier:id/et_sender_name");
	el23.sendKeys("AutoTest");
	MobileElement el24 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_missing_collection");
	el24.click();
	MobileElement el25 = (MobileElement) driver.findElementById("android:id/button1");
	el25.click();
	}
	
	@Test(description= "Reason-Collection Alredy collected ' ",priority= 1)

	public void CaseToVerifySelectConsignmentforMissedCollectionReason3() throws InterruptedException {	
	
	MobileElement el26 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
	el26.click();
	MobileElement el27 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
	el27.click();
	MobileElement el28 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
	el28.click();
	MobileElement el29 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
	el29.click();
	
	
	
	
	MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el30.sendKeys("SASIAA1234567");
	MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_missing_collection");
	el31.click();
	}
	
	@Test(description= "Reason-Collection Alredy collected on cancel button' ",priority= 1)

	public void CaseToVerifySelectConsignmentNFollowCollectionProcessCancelBtn() throws InterruptedException {	
	
	
	
	MobileElement el32 = (MobileElement) driver.findElementByAccessibilityId("Pending(1)");
	el32.click();
	MobileElement el33 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
	el33.click();
	MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
	el34.click();
	MobileElement el35 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_accept");
	el35.click();
	MobileElement el36 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
	el36.click();
	MobileElement el37 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
	el37.click();
	MobileElement el38 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_collect");
	el38.click();
	MobileElement el39 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el39.click();
	MobileElement el40 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el40.sendKeys("112");
	MobileElement el41 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_waybill");
	el41.click();
	MobileElement el42 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el42.sendKeys("SASDSFSFFF12.001");
	MobileElement el43 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_waybill");
	el43.click();
	MobileElement el44 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	el44.click();
	MobileElement el45 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_cancel");
	el45.click();
	
	}
	
	
	@Test(description= "Reason-Collection Alredy collected on Yes button' ",priority= 1)

	public void CaseToVerifySelectConsignmentNFollowCollectionProcessYesBtn() throws InterruptedException {	
	
	
	MobileElement el46 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	el46.click();
	MobileElement el47 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_yes");
	el47.click();
	MobileElement el48 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el48.sendKeys("SASDSFSFFF12.002");
	MobileElement el49 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_waybill");
	el49.click();
	MobileElement el50 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	el50.click();
	}
	
	
	@Test(description= "Reason-Collection Alredy collected on No button' ",priority= 1)

	public void CaseToVerifySelectConsignmentNFollowCollectionProcessNoBtn() throws InterruptedException {	
	
	
	
	MobileElement el51 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
	el51.click();
	MobileElement el52 = (MobileElement) driver.findElementById("com.ram.courier:id/et_collected_from");
	el52.sendKeys("AutoCollect");
	MobileElement el53 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save");
	el53.click();
	MobileElement el54 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
	el54.click();
	MobileElement el55 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
	el55.click();
	MobileElement el56 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
	el56.click();
	MobileElement el57 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
	el57.click();
	}
}
