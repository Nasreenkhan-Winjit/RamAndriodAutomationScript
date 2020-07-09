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

public class OtrReturnToHub {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;


	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();


	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\ReturntoHUBReport.html.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\ReturntoHUBReport.html.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-ReturntoHUBReport.html");
		htmlReporter.config().setDocumentTitle("AutomationReport-ReturntoHUBReport.html");

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
	@Test(description= "To verify Proceed Button",priority= 0)


	public void ReturntoHubProceedBtn () throws InterruptedException {



		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_return_hub");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
		el3.click();






	}

	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 1)

	public void ReturntoHubSelectReasonforOpenDeliveries () throws InterruptedException {

		MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
		el4.click();

	}


	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 2)

	public void ReturntoHubSelectReasonforOpenCollection () throws InterruptedException {

		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_collection_reason");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		el6.click();

//		MobileElement clickOnOpenCollectionDropDown = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout");
//		clickOnOpenCollectionDropDown.click();
//		MobileElement selectReasonforOpenCollection = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[6]");
//		selectReasonforOpenCollection.click();
//		MobileElement clickOnProceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_");
//		clickOnProceedBtn.click();

	}

	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 3)

	public void ReturntoHubSelectReasonforNextCollectionEnterINvalidPodNO () throws InterruptedException {

		//second reco
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_");
		el7.click();
		MobileElement clickOnbtnLogout1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
		clickOnbtnLogout1.click();
		MobileElement clickOnbtnOK = (MobileElement) driver.findElementById("android:id/button2");
		clickOnbtnOK.click();
	}

	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 4)

	public void ReturntoHubSelectReasonforNextCollectionEnterValidPodNO () throws InterruptedException {

//		MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
//		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/et_pod_bag_no");
		el9.click();
		el9.sendKeys("POD12345678");

	}

	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 5)

	public void ReturntoHubScanInvalidWaybillNo () throws InterruptedException {


		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_waybill");
		el10.click();
		driver.findElementById("android:id/button1").click();



		;

//		driver.findElementById("com.ram.courier:id/btn_scan_waybill").click();
//		driver.findElementById("android:id/button1").click();


	}

	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 6)

	public void ReturntoHubScanValidWaybillNo () throws InterruptedException {

		MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_waybill");
		el10.click();


		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
		el12.click();



//		driver.findElementById("com.ram.courier:id/btn_scan_waybill").click();
//
//
//		MobileElement clickOnBtnLogout1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
//		clickOnBtnLogout1.click();
//		MobileElement clickOnBtnOK = (MobileElement) driver.findElementById("android:id/button2");
//		clickOnBtnOK.click();
//		MobileElement clickOnBtnLogout2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
//		clickOnBtnLogout2.click();
//		MobileElement clickOnBtnOK1 = (MobileElement) driver.findElementById("android:id/button1");
//		clickOnBtnOK1.click();


	}


}

	
	
	
	
	
