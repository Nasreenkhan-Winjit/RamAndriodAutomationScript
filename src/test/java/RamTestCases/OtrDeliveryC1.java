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
		cap.setCapability("platformVersion", "10");
		cap.setCapability("deviceName", "vivo 1907");
		cap.setCapability("udid", "8XXCCMUCKV7XIVRG");
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


	@Test(description= "To verify home screen",priority= 0)

	public void VerifyNextBtn () throws InterruptedException {

		MobileElement clickOnOnTheRoadIcon = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		clickOnOnTheRoadIcon.click();
		MobileElement clickOnDeliverriesIcon = (MobileElement) driver.findElementById("com.ram.courier:id/ll_deliveries");
		clickOnDeliverriesIcon.click();

		driver.findElementById("com.ram.courier:id/btn_next_deliveries").click();

		driver.findElementById("android:id/button1").click();

	}

	@Test(description= "Enter Invalid Parcel No.",priority= 1)

	public void DeliveryCase1InvalidParcel () throws InterruptedException {

		MobileElement entertxtInvalidWaybillNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		entertxtInvalidWaybillNo.sendKeys("A0350538");
		entertxtInvalidWaybillNo.click();
		MobileElement clickOnAddParcelbtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		clickOnAddParcelbtn.click();
		MobileElement clickONoKBtn = (MobileElement) driver.findElementById("android:id/button1");
		clickONoKBtn.click();

	}

	@Test(description= "Enter In valid Parcel",priority= 2)

	public void DeliveryvalidParcelNo () throws InterruptedException {


		MobileElement clickOnFirstwaybillNo = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
		clickOnFirstwaybillNo.click();
		driver.findElementById("com.ram.courier:id/btn_next_deliveries").click();
		MobileElement clickOnProceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		clickOnProceedBtn.click();
		MobileElement clickOnOkBtn1 = (MobileElement) driver.findElementById("android:id/button1");
		clickOnOkBtn1.click();
		MobileElement entertxtValidWybillNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		entertxtValidWybillNo.sendKeys("A0350538.001");
		MobileElement clickOnbtnAddParcel = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		clickOnbtnAddParcel.click();
		MobileElement clickOnProceedBtn1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		clickOnProceedBtn1.click();




	}

	@Test(description= "Verify Delivery Button",priority= 3)

	public void TapOnDeliveryBtnCompleteProcess () throws InterruptedException {

		MobileElement clickOnbtnDelivery = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		clickOnbtnDelivery.click();


		driver.findElementById("com.ram.courier:id/et_receiver_fname").sendKeys("FNautotest");
		driver.findElementById("com.ram.courier:id/et_receiver_lname").sendKeys("LNautotest");


//		driver.findElement(By.xpath(props.getProperty(“mobile”))).click();
//		Actions action = new Actions(driver);
//		action.sendKeys(“Mobile”).perform();

		MobileElement Proceedbtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		Proceedbtn.click();
	}

	@Test(description= "No Dilivery Button",priority= 4)

	public void NonDeliveryCompleteProcess () throws InterruptedException {

		MobileElement clickOnFirstwaybillNo = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
		clickOnFirstwaybillNo.click();
		driver.findElementById("com.ram.courier:id/btn_next_deliveries").click();
		MobileElement entertxtInvalidWaybillNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		entertxtInvalidWaybillNo.sendKeys("AFRI02-00021571.001");
		MobileElement clickOnBtnAddParcel = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		clickOnBtnAddParcel.click();
		clickOnBtnAddParcel.click();
		MobileElement clickOnOkBtn = (MobileElement) driver.findElementById("android:id/button1");
		clickOnOkBtn.click();
		MobileElement entertxtValidWaybillNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		entertxtValidWaybillNo.sendKeys("AFRI02-00021571.001");
		MobileElement clickOnAddParcelbtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		clickOnAddParcelbtn.click();
		MobileElement clickOnbtnProceed1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		clickOnbtnProceed1.click();
		MobileElement clickOnNonDeliveryBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
		clickOnNonDeliveryBtn.click();
		MobileElement clickOnPopUpOfNonDelivery = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
		clickOnPopUpOfNonDelivery.click();
		MobileElement clickOnNonDeliveryOption = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		clickOnNonDeliveryOption.click();
		MobileElement selectReasonforNonDeliveryOption = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
		selectReasonforNonDeliveryOption.click();
		MobileElement clickOnSelectReasonOption = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		clickOnSelectReasonOption.click();
		MobileElement SelectReason = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
		SelectReason.click();
		MobileElement clickOnDetailedReason = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		clickOnDetailedReason.click();
		MobileElement selectReasonInDetailedReason = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
		selectReasonInDetailedReason.click();
		MobileElement clickOnOkbtnsubmitReason = (MobileElement) driver.findElementById("android:id/button1");
		clickOnOkbtnsubmitReason.click();


	}

	@Test(description= "GroupDelivery",priority= 5)

	public void GroupDelivery() throws InterruptedException {


		MobileElement clickOnCheckboxofGroupIcon = (MobileElement) driver.findElementById("com.ram.courier:id/cbAgree");
		clickOnCheckboxofGroupIcon.click();
		driver.findElementById("com.ram.courier:id/btn_next_deliveries").click();
		MobileElement clickOnOkBtnError = (MobileElement) driver.findElementById("android:id/button1");
		clickOnOkBtnError.click();
		MobileElement clickOnfirstwaybillNo = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
		clickOnfirstwaybillNo.click();
		driver.findElementById("com.ram.courier:id/btn_next_deliveries").click();
		MobileElement entertxtwaybillNo1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		entertxtwaybillNo1.sendKeys("PLAT05-90023456.001");
		MobileElement clickOnAddParcelbtn1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		clickOnAddParcelbtn1.click();
		MobileElement entertxtwaybillNo2 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		entertxtwaybillNo2.sendKeys("PLAT05-92234567.001");
		MobileElement clickOnAddParcelbtn2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		clickOnAddParcelbtn2.click();
		MobileElement entertxtwaybillNo3 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		entertxtwaybillNo3.sendKeys("PLAT05-94123456.001");
		MobileElement clickOnAddParcelbtn3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
		clickOnAddParcelbtn3.click();
		MobileElement clickOnProceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		clickOnProceedBtn.click();
		MobileElement clickOnDeliveryBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
		clickOnDeliveryBtn.click();
		MobileElement clickOnOKBtn = (MobileElement) driver.findElementById("android:id/button1");
		clickOnOKBtn.click();
//		MobileElement entertxtOnRecieverName = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
//		entertxtOnRecieverName.sendKeys("Autotest");
		driver.findElementById("com.ram.courier:id/et_receiver_fname").sendKeys("FNautotest");
		driver.findElementById("com.ram.courier:id/et_receiver_lname").sendKeys("LNautotest");
		MobileElement clickOnBtnProceed = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		clickOnBtnProceed.click();


	}



}
