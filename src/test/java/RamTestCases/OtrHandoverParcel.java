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


	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();


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

	
	@Test(description= "Tap on Next btn without check clicking on CheckBox",priority= 0)

	public void HPVerifyNextBtn () throws InterruptedException {
	
	MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
	el1.click();
	
	MobileElement el22 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
	el22.click();
	
	MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
	el4.click();
	MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
	el29.click();
	
	}
	
	
	@Test(description= "Click On Proceed btn",priority= 1)

	public void InValidHPProceedbtn () throws InterruptedException {
	
		MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
		el5.sendKeys("RAMS02-20054321.001");
		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		el7.click();
		driver.findElementById("android:id/button1").click();
		
	}
		
	@Test(description= "Validate with sign",priority= 2)

	public void InValidHPProceedsameNameWithoutSign () throws InterruptedException {			
			
	MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el6.click();
	MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	el7.click();
	MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
	el8.click();
	MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
	el9.click();
	MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
	el10.click();
	MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
	el11.click();
	MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
	el12.click();
	MobileElement el13 = (MobileElement) driver.findElementById("android:id/button1");
	el13.click();
	
	}
	
	@Test(description= "Valid Parcel ID",priority= 3)

	public void ValidHPParcel () throws InterruptedException {		
	

	
	MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
	el14.click();
	MobileElement el15 = (MobileElement) driver.findElementById("android:id/button1");
	el15.click();
	MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_received_by_list_sort");
	el16.click();
	MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
	el17.click();
	MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
	el18.click();
	MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
	el19.click();
	MobileElement el20 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
	el20.click();
	MobileElement el21 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
	el21.click();
	MobileElement el22 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
	el22.click();
	MobileElement el23 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
	el23.click();
	MobileElement el24 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
	el24.click();
	MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
	el25.click();
	}

	
	@Test(description= "Validate with second ID",priority= 4)

	public void ValidHPParcelasignstep1 () throws InterruptedException {	
	
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
	
	
	@Test(description= "Validate assign Step2",priority= 5)

	public void ValidHPParcelasignstep2 () throws InterruptedException {	
	
	MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el31.sendKeys("VSPI01-20054322.001");
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
	
	
	
	}	
}
