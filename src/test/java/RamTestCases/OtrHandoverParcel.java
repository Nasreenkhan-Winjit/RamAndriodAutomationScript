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
        cap.setCapability("udid", "192.168.9.33:5555");
//      cap.setCapability("udid", "8XXCCMUCKV7XIVRG");
//        cap.setCapability("udid", "192.168.0.2:5555");

//      cap.setCapability("deviceId", "192.168.0.2:5555");
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





//    Escort ID's = 0006075302080, 8908015067081, 7208155584081
    @Test(description = "Tap on proceed btn without scan Escort ID ", priority = 0)

    public void HPVerifyProceedBtn() throws InterruptedException {

        MobileElement onTheRoad = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
        onTheRoad.click();

        MobileElement handoverParcel = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
        handoverParcel.click();

        MobileElement giveParcelTo = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel");
        giveParcelTo.click();

        MobileElement giveToEscortWithoutDevice = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel_to_escort");
        giveToEscortWithoutDevice.click();

        MobileElement proceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
        proceedBtn.click();
        MobileElement clickOnOKAlert = (MobileElement) driver.findElementById("android:id/button1");
        clickOnOKAlert.click();

//		android:id/button1

//	MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//	el4.click();
//	MobileElement el13 = (MobileElement) driver.findElementById("android:id/button1");
//	el13.click();
//
    }

    @Test(description = "Tap on Scan RAM ID btn and scan Invalid Id which is not escort ", priority = 1)

    public void InvalidEscortScanRAMID() throws InterruptedException {

        // Scan Invalid Escort ID some RAM ID
        MobileElement scanRAMIDBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
        scanRAMIDBtn.click();

        MobileElement clickOnOKAlert = (MobileElement) driver.findElementById("android:id/button1");
        clickOnOKAlert.click();

    }

    @Test(description = "Tap on Scan RAM ID btn and scan valid Id which is an escort ", priority = 2)

    public void validEscort_0006075302080ScanRAMID() throws InterruptedException {

//		Scan Valid RAM ID- Escort
        MobileElement scanRAMIDBtn1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
        scanRAMIDBtn1.click();

        // Click on proceed button
        MobileElement clickOnProceed = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
        clickOnProceed.click();

    }


    @Test(description = "Add Parcel which not in uploaded manifest and Verify the alert is displayed ", priority = 3)

    public void addParcelInvalidParcel() throws InterruptedException {

//        MobileElement clickOnProceedHTE = (MobileElement) driver.findElementsById("com.ram.courier:id/btn_proceed");
//        clickOnProceedHTE.click();

        MobileElement clickOnProceedHTE = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        clickOnProceedHTE.click();

        MobileElement clickOnOkBtnAlert = (MobileElement) driver.findElementById("android:id/button1");
        clickOnOkBtnAlert.click();


        MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        el2.sendKeys("VSPI01-20054322.001");
        MobileElement aDDBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        aDDBtn.click();
        MobileElement alertOKBtn = (MobileElement) driver.findElementById("android:id/button1");
        alertOKBtn.click();


    }

    @Test(description = "Add Parcel which are uploaded manifest verify all parcel added sccusfully", priority = 4)

    public void addParcelValidParcel() throws InterruptedException {

        MobileElement clearWaybillNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        clearWaybillNo.clear();
        MobileElement enterWaybillNo1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        enterWaybillNo1.sendKeys("A0350538.001");
        MobileElement ADDBtn1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        ADDBtn1.click();
        MobileElement enterWaybillNo2 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        enterWaybillNo2.sendKeys("PEPA03-91234568.001");
        MobileElement ADDBtn2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        ADDBtn2.click();

        MobileElement enterWaybillNo3 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        enterWaybillNo3.sendKeys("RW18220294.001");
        MobileElement ADDBtn3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        ADDBtn3.click();

        MobileElement enterWaybillNo4 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        enterWaybillNo4.sendKeys("K1781740.001");
        MobileElement ADDBtn4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        ADDBtn4.click();

        MobileElement clickOnProceedHTE = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        clickOnProceedHTE.click();

    }

    @Test(description = "Verify the popup is working with both option", priority = 5)

    public void ScanMorePopUpWithYesAndNoBtn() throws InterruptedException {

        MobileElement el2 = (MobileElement) driver.findElementById("android:id/button2");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_issued_by");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_received_by_list_sort");
        el6.click();
        Thread.sleep(4000);
        MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
        el7.click();


    }

    @Test(description = "Verify the already hand over parcel is giving alert that this is handed over to escort", priority = 6)

    public void AddParcelWhichHandoverToEscort() throws InterruptedException {

        MobileElement GiveParcelToEscort = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel_to_escort");
        GiveParcelToEscort.click();

        MobileElement scanRAMIDBtn1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
        scanRAMIDBtn1.click();

        MobileElement ProceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
        ProceedBtn.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        el10.sendKeys("A0350538.001");
        MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
        el14.click();

        MobileElement el110 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        el110.sendKeys("ST00038953.001");
        MobileElement el111 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        el111.click();

        MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_issued_by");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_received_by_list_sort");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
        el7.click();
        Thread.sleep(4000);
    }

    @Test(description = "Select three parcels in that one is handed over to escort", priority = 7)

    public void GiveParcelToCrew() throws InterruptedException {


        MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel_to_crew");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.CheckBox");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("android:id/button1");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.CheckBox");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
        el8.click();
    }


    @Test(description = "Add parcels on handover to crew screen ", priority = 8)

    public void AddParcelsIntoHandoverTOCrew() throws InterruptedException {

        MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        el9.sendKeys("W0707910.001");
        MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        el13.sendKeys("J9858033.001");
        MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el15.click();
        Thread.sleep(4000);

    }
    @Test(description = "Select Issued by and Received by as same member", priority = 9)

    public void SameIssuedByAndRcvdNameAndVerifyAlert() throws InterruptedException {

        MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
        el16.click();
        MobileElement el17 = (MobileElement) driver.findElementById("android:id/button1");
        el17.click();
        MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/iv_issue_arrow");
        el18.click();
        MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        el19.click();
        MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/iv_receiver_arrow");
        el20.click();
        MobileElement el21 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        el21.click();
        Thread.sleep(4000);
        MobileElement el22 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
        el22.click();
        MobileElement el23 = (MobileElement) driver.findElementById("android:id/button1");
        el23.click();
        MobileElement el24 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
        el24.click();
        MobileElement el25 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        el25.click();
        Thread.sleep(4000);
        MobileElement el26 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
        el26.click();

    }
    @Test(description = "Deliver the GRV parcel", priority = 10)

    public void DeliverGRVParcel() throws InterruptedException {


        MobileElement el27 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
        el27.click();
        MobileElement el28 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
        el28.click();
        MobileElement el29 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
        el29.click();
        MobileElement el30 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
        el30.click();
        MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
        el31.click();
        MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
        el32.click();
        MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
        el34.sendKeys("hAOVERgv");
        MobileElement el35 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
        el35.click();
        MobileElement el36 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.Button[2]");
        el36.click();
        MobileElement el37 = (MobileElement) driver.findElementById("android:id/button1");
        el37.click();
        MobileElement el38 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
        el38.click();
        MobileElement el39 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_five");
        el39.click();
        MobileElement el40 = (MobileElement) driver.findElementById("com.ram.courier:id/et_grv_no");
        el40.sendKeys("grv1234");
        MobileElement el41 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan");
        el41.click();
        MobileElement el42 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receivers_name");
        el42.click();
        el42.sendKeys("rceIVERgrv1234");
        MobileElement el43 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan");
        el43.click();
        MobileElement el44 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
        el44.click();


    }

    @Test(description = "Perform Non delivery in which handed over to crew", priority = 11)

    public void NonDeliverParcelHandover() throws InterruptedException {

        MobileElement el45 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
        el45.click();
        MobileElement el46 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
        el46.click();
        MobileElement el47 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
        el47.click();
        MobileElement el48 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
        el48.click();
        MobileElement el49 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
        el49.click();
        MobileElement el50 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
        el50.click();
        MobileElement el51 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
        el51.click();
        MobileElement el52 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]");
        el52.click();
        MobileElement el53 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        el53.click();
        MobileElement el54 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
        el54.click();
        MobileElement el55 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
        el55.click();
        MobileElement el56 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
        el56.click();
        MobileElement el57 = (MobileElement) driver.findElementById("android:id/button1");
        el57.click();
    }



    }
