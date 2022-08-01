package RamTestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


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

public class OtrSAIDOCRAnd9999 {
    public AppiumDriver<MobileElement> driver;
    private static ExtentReports extent;


    public ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

    public ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();


    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentReportBuilder.ExtentManager.createInstance("~\\..\\Result\\OtrSAIDOCRAnd9999Report.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\OtrSAIDOCRAnd9999Report.html");
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setReportName("AutomationReport-OtrSAIDOCRAnd9999Report");
        htmlReporter.config().setDocumentTitle("AutomationReport-OtrSAIDOCRAnd9999Report");

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
        cap.setCapability("udid", "192.168.9.33:5555");
//	cap.setCapability("udid", "8XXCCMUCKV7XIVRG");
//		cap.setCapability("autoGrantPermission", "true");
        cap.setCapability("appPackage", "com.ram.courier");
        cap.setCapability("appActivity", "com.ram.courier.activities.SplashScreen");
        cap.setCapability("noReset", "true");
        cap.setCapability("fullReset", "false");
//		cap.setCapability("app","C:/Users/nasreenk/Desktop/Diawi/RAMMobile_UatDebug-2.9.23-2.apk" );

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

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

    @Test(description = "To verify home screen", priority = 0)

    public void AtTheHub() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement ATTheHub = (MobileElement) driver.findElementById("com.ram.courier:id/ll_at_the_hub");
        ATTheHub.isEnabled();


        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();


    }

    @Test(description = "Login and upload 9999 manifest and upload for SAID OCR test", priority = 1)

    public void uploadManifestWith1971AndSAIDOCRManifest() throws InterruptedException {


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
        el13.sendKeys("8111140110088");
        MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_member");
        el14.click();

        MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_to_scan");
        el15.click();


        MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ds");
        el18.click();


        MobileElement el22 = (MobileElement) driver.findElementById("com.ram.courier:id/et_ds_no");
        el22.sendKeys("DDISA16327469024");

//	  DDISA15816827824
//	  DDISA13959025107
//    DDISA16327469024


//	  9999
//	  1.	DDISA16395682938
//	  2.	DDISA16395687314
//	  3.	DDISA16395690751
//	  4.	DDBLM16395757097


        MobileElement el213 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_ds_no");
        el213.click();
        // Newly added lines
//
//        MobileElement el128 = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ds");
//        el128.click();
//
//        MobileElement el212 = (MobileElement) driver.findElementById("com.ram.courier:id/et_ds_no");
//        el212.sendKeys("DDISA16395687314");
//	  // Newly added lines
//
//	  MobileElement el1218 = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ds");
//	  el1218.click();
//
//	  MobileElement el221 = (MobileElement) driver.findElementById("com.ram.courier:id/et_ds_no");
//	  el221.sendKeys("DDISA15822179704");
//        MobileElement el23 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_ds_no");
//        el23.click();
        MobileElement el24 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el24.click();
        MobileElement ProceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        ProceedBtn.click();

        MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/et_total_parcels");
        el29.sendKeys("75");

        MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/proceed_for_further_sheet");
        el30.click();

        MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/et_registration_no");
        el34.sendKeys("CL08FRGP");
        MobileElement el35 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_veh_no");
        el35.click();

        MobileElement el36 = (MobileElement) driver.findElementById("com.ram.courier:id/et_odometer_reading");
        el36.sendKeys("123456");
        MobileElement el37 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_veh_no");
        el37.click();
        Thread.sleep(20000);
//        MobileElement onTheRoad = (MobileElement) driver.findElementByAccessibilityId("com.ram.courier:id/btn_on_the_road");
//        boolean isEnabled = onTheRoad.isEnabled();


        MobileElement onTheRoad = (MobileElement) driver.findElementById("com.ram.courier:id/btn_on_the_road");
        onTheRoad.click();
        MobileElement el39 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
        el39.click();
            }

    @Test(description = "Scan Valid bar code and Valid SAID capture the image horizontal", priority = 2)

    public void ScanValidBarCodeAndValidSAID_CapImgHorizontally() throws InterruptedException {


        MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
        el1.click();
        MobileElement clickOnDeliveriesIcon = (MobileElement) driver.findElementById("com.ram.courier:id/ll_deliveries");
        clickOnDeliveriesIcon.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        el2.sendKeys("K2784270.001");
        MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_zero");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_one");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_sa_id_card");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button2");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/id_front");
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/iv_arrow_next");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/id_back");
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/iv_proceed");
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_fname");
        el15.sendKeys("test");
        MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_lname");
        el16.sendKeys("testRCV");
        MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/signature_pad");
        el17.click();
        MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el18.click();

    }
    @Test(description = "Scan Valid bar code and Invalid SAID", priority =3)

    public void ScanValidBarCodeAndInvalidSAID() throws InterruptedException {
        MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        el2.sendKeys("K2791599.001");
        MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_reason3");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/et_note");
        el5.sendKeys("test Ops officer");
        MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_zero");
        el8.click();
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_one");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_sa_id_card");
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementById("android:id/button2");
        el12.click();
        Thread.sleep(10000);
        MobileElement el13 = (MobileElement) driver.findElementById("android:id/button1");
        el13.click();
        Thread.sleep(20000);
        MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
        el14.click();
        Thread.sleep(20000);
        MobileElement el15 = (MobileElement) driver.findElementById("android:id/button1");
        el15.click();
//        Thread.sleep(20000);

    }
    @Test(description = "Scan Invalid bar code and make non delivery ", priority =4)

    public void ScanInvalidBarCode_2138731287213_MakeNonDelivery() throws InterruptedException {

        MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        el2.sendKeys("K2793546.001");
        MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_reason5");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/et_note");
        el5.sendKeys("ReasonXYZ");
        MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_zero");
        el8.click();
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_one");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_sa_id_card");
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementById("android:id/button2");
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementById("android:id/button1");
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("android:id/button1");
        el15.click();

    }



}




