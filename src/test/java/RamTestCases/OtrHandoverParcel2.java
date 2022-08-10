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

public class OtrHandoverParcel2 {
        public AppiumDriver<MobileElement> driver;
        private static ExtentReports extent;


        public ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

        public ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();


        @BeforeSuite
        public void beforeSuite() {
            extent = ExtentReportBuilder.ExtentManager.createInstance("~\\..\\Result\\HandoverParcel2.html");
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\HandoverParcel2.html");
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
//      cap.setCapability("udid", "8XXCCMUCKV7XIVRG");
//           cap.setCapability("autoGrantPermission", "true");
            cap.setCapability("appPackage", "com.ram.courier");
            cap.setCapability("appActivity", "com.ram.courier.activities.SplashScreen");
            cap.setCapability("noReset", "true");
            cap.setCapability("fullReset", "false");


            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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



        @Test(description = "Select only parcel which is handed over to escort and try to give it to crew", priority = 0)

        public void HandoverParcelEscortToCrew() throws InterruptedException {



            MobileElement el59 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
            el59.click();
            MobileElement el60 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
            el60.click();
            MobileElement el61 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel");
            el61.click();
            MobileElement el62 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel_to_crew");
            el62.click();
            MobileElement el63 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
            el63.click();
            MobileElement el64 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
            el64.click();
            MobileElement el65 = (MobileElement) driver.findElementById("android:id/button1");
            el65.click();
        }
        @Test(description = "Select another three valid parcels", priority = 1)

        public void SelectValidParcelsAndHandOver() throws InterruptedException {

            MobileElement el66 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
            el66.click();
            MobileElement el67 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
            el67.click();
            MobileElement el68 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.CheckBox");
            el68.click();
            el68.click();
            MobileElement el69 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.CheckBox");
            el69.click();
            MobileElement el70 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.CheckBox");
            el70.click();
            MobileElement el71 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
            el71.click();
            MobileElement el72 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el72.click();
            el72.sendKeys("J2081929.001");
            MobileElement el73 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el73.click();
            MobileElement el74 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el74.sendKeys("CELLC11663226.001");
            MobileElement el75 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el75.click();
            MobileElement el76 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el76.click();
            MobileElement el77 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el77.sendKeys("CELLC11663226.002");
            MobileElement el78 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el78.click();
            MobileElement el79 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el79.sendKeys("CELLC11663226.003");
            MobileElement el80 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el80.click();
            MobileElement el81 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el81.sendKeys("CELLC11663226.004");
            MobileElement el82 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el82.click();
            MobileElement el83 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el83.sendKeys("STCL09-U0000005.001");
            MobileElement el84 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el84.click();
            MobileElement el85 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
            el85.click();
            MobileElement el86 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
            el86.click();
            MobileElement el87 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
            el87.click();
            MobileElement el88 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
            el88.click();
            MobileElement el89 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
            el89.click();
            Thread.sleep(4000);
            MobileElement el90 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
            el90.click();
            MobileElement el91 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
            el91.click();
            MobileElement el92 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
            el92.click();
            MobileElement el93 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
            el93.click();
            MobileElement el94 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
            el94.click();
            MobileElement el95 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
            el95.click();
//        MobileElement el96 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
//        el96.sendKeys("j2081929 TEST");
            MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
            el34.sendKeys("hAOVERgv1");
            MobileElement el98 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
            el98.click();

            MobileElement el100 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_five");
            el100.click();
            MobileElement el101 = (MobileElement) driver.findElementById("com.ram.courier:id/et_grv_no");
            el101.sendKeys("GRVNU43211");
            MobileElement el102 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receivers_name");
            el102.sendKeys("RcvGRV54333");
            MobileElement el103 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan");
            el103.click();
            MobileElement el104 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_six");
            el104.click();
            MobileElement el105 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
            el105.click();
            MobileElement el106 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp");
            el106.sendKeys("1152");

            MobileElement el107 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
            el107.click();
            MobileElement el108 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_six");
            el108.click();
            MobileElement el109 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
            el109.click();
            MobileElement el110 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
            el110.click();
            MobileElement el111 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
            el111.click();
            MobileElement el112 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
            el112.click();
            MobileElement el113 = (MobileElement) driver.findElementById("android:id/button1");
            el113.click();
            MobileElement el114 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
            el114.click();
            MobileElement el115 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
            el115.click();
            MobileElement el116 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
            el116.click();
            MobileElement el117 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
            el117.click();
            MobileElement el118 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
            el118.click();
            MobileElement el119 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
            el119.click();
            MobileElement el120 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
            el120.click();
            MobileElement el121 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
            el121.click();
            MobileElement el122 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
            el122.click();
            MobileElement el123 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
            el123.click();
            MobileElement el124 = (MobileElement) driver.findElementById("android:id/button1");
            el124.click();
            MobileElement el125 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
            el125.click();
            MobileElement el126 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
            el126.click();
            MobileElement el127 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
            el127.click();
        }

        @Test(description = "Navigate to Receive Parcel and click on proceed", priority = 2)

        public void goToReceiveParcelAndClickOnProceed() throws InterruptedException {
            // Rcv normal flow with all validation check

            MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_receive_parcel");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_receive_parcel_to_escort");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
            el3.click();
            MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
            el4.click();
        }


        @Test(description = "Scan Invalid EscortId (RAM ID) ", priority = 3)

        public void ScanRAMIDWhichIsNotAnEscort () throws InterruptedException {

            MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
            el5.click();
            MobileElement el6 = (MobileElement) driver.findElementById("android:id/button1");
            el6.click();

        }

        @Test(description = "Scan Invalid Escort to which Parcel is not assigned", priority =4)

        public void ScanInvalid_7208155584081EscortID() throws InterruptedException {

            MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
            el7.click();
            MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
            el8.click();
        }

        @Test(description = "Scan Valid Escort to which Parcel is assigned", priority = 5)

        public void Scan_0006075302080ValidEscortID() throws InterruptedException {
            MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
            el9.click();
            MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
            el10.click();
            MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
            el11.click();
            MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
            el12.click();
            MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el13.click();
            MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
            el14.click();
        }

        @Test(description = "Add parcel which are listed", priority = 6)

        public void AddParcelsToWhichParcelIsAssigned() throws InterruptedException {

            MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el15.sendKeys("A0350538.001");
            MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el16.click();
            MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView");
            el17.click();
            MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el18.sendKeys("PEPA03-91234568.001");
            MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el19.click();
            MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
            el20.click();
            MobileElement el21 = (MobileElement) driver.findElementById("android:id/button2");
            el21.click();
            MobileElement el22 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el22.sendKeys("W0707910.001");
            MobileElement el23 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el23.click();
            MobileElement el24 = (MobileElement) driver.findElementById("android:id/button1");
            el24.click();
            MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el25.sendKeys("J9858033.001");
            el25.click();
            MobileElement el26 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el26.click();
            MobileElement el27 = (MobileElement) driver.findElementById("android:id/button1");
            el27.click();
            MobileElement el28 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
            el28.click();
            MobileElement el29 = (MobileElement) driver.findElementById("android:id/button2");
            el29.click();
            MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
            el30.click();
            MobileElement el31 = (MobileElement) driver.findElementById("android:id/button1");
            el31.click();
            Thread.sleep(4000);
            MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
            el32.click();
        }


        @Test(description = "Scan Valid Escort Id and  Parcel is not assigned", priority = 7)

        public void Scan_8908015067081_ValidEscortIDToWhichParcelIsNotAssigned() throws InterruptedException {
// Handover to another Escort


            MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel_to_escort");
            el3.click();
            MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
            el4.click();
            MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
            el5.click();
            MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el6.sendKeys("RW18220294.001");
            MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el7.click();
            MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el8.click();
            el8.sendKeys("PEPA03-91234569.001");
            MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el9.click();
            MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
            el10.click();
            MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
            el11.click();
            Thread.sleep(4000);
            MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
            el12.click();
            MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
            el13.click();

        }

        @Test(description = "Scan Valid Escort to which Parcel is assigned", priority = 8)

        public void Scan_8908015067081ValidParcelsAndHandOverToDriver() throws InterruptedException {
// Done Escort ID change
            MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
            el14.click();

            MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
            el15.click();
            MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_receive_parcel");
            el16.click();
            MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_receive_parcel_to_escort");
            el17.click();
            MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
            el18.click();
            MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
            el19.click();
            MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el20.sendKeys("ST00038953.001");
            el20.click();
            MobileElement el21 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el21.click();
            MobileElement el22 = (MobileElement) driver.findElementById("android:id/button1");
            el22.click();
            MobileElement el23 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
            el23.sendKeys("RW18220294.001");
            MobileElement el24 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
            el24.click();
            MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
            el25.click();
            MobileElement el26 = (MobileElement) driver.findElementById("android:id/button1");
            el26.click();
            Thread.sleep(4000);
            MobileElement el27 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
            el27.click();

        }



    }


