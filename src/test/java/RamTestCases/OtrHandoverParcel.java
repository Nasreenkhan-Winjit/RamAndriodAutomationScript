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
        cap.setCapability("udid", "192.168.0.3:5555");
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
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.CheckBox");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("android:id/button1");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.CheckBox");
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
        MobileElement el29 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
        el29.click();
        MobileElement el30 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
        el30.click();
        MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
        el31.click();
        MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
        el32.click();
        MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
        el34.sendKeys("hAOVERgv");
        MobileElement el35 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
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

        MobileElement el45 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
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

//    @Test(description = "Select only parcel which is handed over to escort and try to give it to crew", priority = 12)
//
//    public void HandoverParcelEscortToCrew() throws InterruptedException {
//
//
//        MobileElement el58 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
//        el58.click();
//        MobileElement el59 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
//        el59.click();
//        MobileElement el60 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
//        el60.click();
//        MobileElement el61 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel");
//        el61.click();
//        MobileElement el62 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel_to_crew");
//        el62.click();
//        MobileElement el63 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
//        el63.click();
//        MobileElement el64 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//        el64.click();
//        MobileElement el65 = (MobileElement) driver.findElementById("android:id/button1");
//        el65.click();
//    }
//    @Test(description = "Select another three valid parcels", priority = 13)
//
//    public void SelectValidParcelsAndHandOver() throws InterruptedException {
//
//        MobileElement el66 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
//        el66.click();
//        MobileElement el67 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
//        el67.click();
//        MobileElement el68 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.CheckBox");
//        el68.click();
//        el68.click();
//        MobileElement el69 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.CheckBox");
//        el69.click();
//        MobileElement el70 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.CheckBox");
//        el70.click();
//        MobileElement el71 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//        el71.click();
//        MobileElement el72 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el72.click();
//        el72.sendKeys("J2081929.001");
//        MobileElement el73 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el73.click();
//        MobileElement el74 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el74.sendKeys("CELLC11663226.001");
//        MobileElement el75 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el75.click();
//        MobileElement el76 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el76.click();
//        MobileElement el77 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el77.sendKeys("CELLC11663226.002");
//        MobileElement el78 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el78.click();
//        MobileElement el79 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el79.sendKeys("CELLC11663226.003");
//        MobileElement el80 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el80.click();
//        MobileElement el81 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el81.sendKeys("CELLC11663226.004");
//        MobileElement el82 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el82.click();
//        MobileElement el83 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el83.sendKeys("AFRI02-00021571.001");
//        MobileElement el84 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el84.click();
//        MobileElement el85 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//        el85.click();
//        MobileElement el86 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
//        el86.click();
//        MobileElement el87 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//        el87.click();
//        MobileElement el88 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
//        el88.click();
//        MobileElement el89 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//        el89.click();
//        MobileElement el90 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//        el90.click();
//        MobileElement el91 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
//        el91.click();
//        MobileElement el92 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
//        el92.click();
//        MobileElement el93 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
//        el93.click();
//        MobileElement el94 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//        el94.click();
//        MobileElement el95 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
//        el95.click();
////        MobileElement el96 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
////        el96.sendKeys("j2081929 TEST");
//        MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
//        el34.sendKeys("hAOVERgv1");
//        MobileElement el98 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
//        el98.click();
//
//        MobileElement el100 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_five");
//        el100.click();
//        MobileElement el101 = (MobileElement) driver.findElementById("com.ram.courier:id/et_grv_no");
//        el101.sendKeys("GRVNU43211");
//        MobileElement el102 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receivers_name");
//        el102.sendKeys("RcvGRV54333");
//        MobileElement el103 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan");
//        el103.click();
//        MobileElement el104 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_six");
//        el104.click();
//        MobileElement el105 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
//        el105.click();
//        MobileElement el106 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp");
//        el106.sendKeys("1152");
//
//        MobileElement el107 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
//        el107.click();
//        MobileElement el108 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_six");
//        el108.click();
//        MobileElement el109 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
//        el109.click();
//        MobileElement el110 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
//        el110.click();
//        MobileElement el111 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
//        el111.click();
//        MobileElement el112 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
//        el112.click();
//        MobileElement el113 = (MobileElement) driver.findElementById("android:id/button1");
//        el113.click();
//        MobileElement el114 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
//        el114.click();
//        MobileElement el115 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
//        el115.click();
//        MobileElement el116 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
//        el116.click();
//        MobileElement el117 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
//        el117.click();
//        MobileElement el118 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//        el118.click();
//        MobileElement el119 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
//        el119.click();
//        MobileElement el120 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//        el120.click();
//        MobileElement el121 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
//        el121.click();
//        MobileElement el122 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//        el122.click();
//        MobileElement el123 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
//        el123.click();
//        MobileElement el124 = (MobileElement) driver.findElementById("android:id/button1");
//        el124.click();
//        MobileElement el125 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
//        el125.click();
//        MobileElement el126 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
//        el126.click();
//        MobileElement el127 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
//        el127.click();
//    }
//
//    @Test(description = "Navigate to Receive Parcel and click on proceed", priority = 14)
//
//    public void goToReceiveParcelAndClickOnProceed() throws InterruptedException {
//        // Rcv normal flow with all validation check
//
//        MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_receive_parcel");
//        el1.click();
//        MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_receive_parcel_to_escort");
//        el2.click();
//        MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
//        el3.click();
//        MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
//        el4.click();
//    }
//
//
//    @Test(description = "Scan Invalid EscortId", priority = 15)
//
//    public void ScanRAMIDWhichIsNotAnEscort () throws InterruptedException {
//
//    MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
//el5.click();
//    MobileElement el6 = (MobileElement) driver.findElementById("android:id/button1");
//el6.click();
//
//    }
//
//    @Test(description = "Scan Invalid Escort to which Parcel is not assigned", priority =16)
//
//    public void ScanInvalidEscortID() throws InterruptedException {
//
//        MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
//        el7.click();
//        MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
//        el8.click();
//    }
//
//    @Test(description = "Scan Valid Escort to which Parcel is assigned", priority = 17)
//
//    public void ScanValidEscortID() throws InterruptedException {
//    MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
//el9.click();
//    MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
//el10.click();
//    MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//el11.click();
//    MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
//el12.click();
//    MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//el13.click();
//    MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
//el14.click();
//    }
//
//    @Test(description = "Add parcel which are listed", priority = 18)
//
//    public void AddParcelsToWhichParcelIsAssigned() throws InterruptedException {
//
//        MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el15.sendKeys("A0350538.001");
//        MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el16.click();
//        MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView");
//        el17.click();
//        MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el18.sendKeys("PEPA03-91234568.001");
//        MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el19.click();
//        MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//        el20.click();
//        MobileElement el21 = (MobileElement) driver.findElementById("android:id/button2");
//        el21.click();
//        MobileElement el22 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el22.sendKeys("W0707910.001");
//        MobileElement el23 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el23.click();
//        MobileElement el24 = (MobileElement) driver.findElementById("android:id/button1");
//        el24.click();
//        MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el25.sendKeys("J9858033.001");
//        el25.click();
//        MobileElement el26 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el26.click();
//        MobileElement el27 = (MobileElement) driver.findElementById("android:id/button1");
//        el27.click();
//        MobileElement el28 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//        el28.click();
//        MobileElement el29 = (MobileElement) driver.findElementById("android:id/button2");
//        el29.click();
//        MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//        el30.click();
//        MobileElement el31 = (MobileElement) driver.findElementById("android:id/button1");
//        el31.click();
//        MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//        el32.click();
//    }
//
//
//    @Test(description = "Scan Valid Escort Id and  Parcel is not assigned", priority = 19)
//
//    public void ScanValidEscortIDToWhichParcelIsNotAssigned() throws InterruptedException {
//// Hanover to another Escort
//
//
//        MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
//        el1.click();
//        MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel");
//        el2.click();
//        MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_give_parcel_to_escort");
//        el3.click();
//        MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
//        el4.click();
//        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
//        el5.click();
//        MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el6.sendKeys("RW18220294.001");
//        MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el7.click();
//        MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el8.click();
//        el8.sendKeys("PEPA03-91234569.001");
//        MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el9.click();
//        MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//        el10.click();
//        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
//        el11.click();
//        MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//        el12.click();
//        MobileElement el13 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
//        el13.click();
//        MobileElement el14 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
//        el14.click();
//        MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
//        el15.click();
//        MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_receive_parcel");
//        el16.click();
//        MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_receive_parcel_to_escort");
//        el17.click();
//        MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_member");
//        el18.click();
//        MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login_proceed");
//        el19.click();
//        MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el20.sendKeys("ST00038953.001");
//        el20.click();
//        MobileElement el21 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el21.click();
//        MobileElement el22 = (MobileElement) driver.findElementById("android:id/button1");
//        el22.click();
//    }
//
//    @Test(description = "Scan Valid Escort to which Parcel is assigned", priority = 20)
//
//    public void ScanValidParcelsAndHandOverToDriver() throws InterruptedException {
//
//
//        MobileElement el23 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el23.sendKeys("RW18220294.001");
//        MobileElement el24 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el24.click();
//        MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//        el25.click();
//        MobileElement el26 = (MobileElement) driver.findElementById("android:id/button1");
//        el26.click();
//        MobileElement el27 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//        el27.click();
















//    @Test(description = "Click On Proceed btn", priority = 1)

//    public void InValidHPProceedbtn() throws InterruptedException {
//
//        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.CheckBox");
//        el3.click();
//        MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//        el4.click();
//        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//        el5.sendKeys("A0350538.001");
//        MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//        el7.click();
//        driver.findElementById("android:id/button1").click();
//
//    }

//    @Test(description = "Validate with sign", priority = 2)

//    public void InValidHPProceedsameNameWithoutSign() throws InterruptedException {
//
//        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//        el5.click();
//        MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//        el6.click();
//        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
//        el7.click();
//        MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//        el8.click();
//        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
//        el9.click();
//        MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//        el10.click();
//        MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//        el11.click();
//        MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
//        el12.click();
//        MobileElement el13 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
//        el13.click();
//        MobileElement el14 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//        el14.click();
//        MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//        el15.click();
//        MobileElement el16 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
//        el16.click();
//        MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
//        el17.click();
//        MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
//        el18.click();
//        MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//        el19.click();
//        MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_non_delivery");
//        el20.click();
//        MobileElement el21 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_non_delivery_option");
//        el21.click();
//        MobileElement el22 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//        el22.click();
//        MobileElement el23 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[1]");
//        el23.click();
//        MobileElement el24 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
//        el24.click();
//        MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/tv_detailed_reason");
//        el25.click();
//        MobileElement el26 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//        el26.click();
//        MobileElement el27 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_reason");
//        el27.click();
//        MobileElement el28 = (MobileElement) driver.findElementById("android:id/button1");
//        el28.click();
//        MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
//        el29.click();
//    }

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


//	@Test(description = "Validate with second ID", priority = 3)
//
//	public void ValidHPParcelasignstep1() throws InterruptedException {
//
//		MobileElement el26 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
//		el26.click();
//		MobileElement el27 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
//		el27.click();
//		MobileElement el28 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//		el28.click();
////		MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
////		el29.click();
//		MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.CheckBox");
//		el3.click();
//		MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//		el30.click();
//
//	}
//
//
//	@Test(description = "Validate assign Step2", priority = 4)
//
//	public void ValidHPParcelasignstep2() throws InterruptedException {
//
//		MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//		el31.sendKeys("AFRI02-00021571.001");
//		MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//		el32.click();
//		MobileElement el33 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//		el33.click();
//		MobileElement el34 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout");
//		el34.click();
//		MobileElement el35 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//		el35.click();
//		MobileElement el36 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
//		el36.click();
//		MobileElement el37 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//		el37.click();
//		MobileElement el38 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//		el38.click();
//		MobileElement el291 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
//		el291.click();
//
//	}
//
//	@Test(description = "Validate assign Step2", priority = 5)
//	public void GRVParcelToHandover() {
//
//		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
//		el1.click();
//		MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
//		el2.click();
//		MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.CheckBox");
//		el3.click();
//		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//		el4.click();
//		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//		el5.click();
//		el5.sendKeys("J2081929.001");
//		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//		el6.click();
//		MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//		el7.click();
//		MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
//		el8.click();
//		MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//		el9.click();
//		MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout");
//		el10.click();
//		MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//		el11.click();
//		MobileElement el12 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//		el12.click();
//		MobileElement el13 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
//		el13.click();
//		MobileElement el14 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
//		el14.click();
//		MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
//		el15.click();
//		MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//		el16.click();
//		MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
//		el17.click();
//		el17.click();
//		MobileElement el18 = (MobileElement) driver.findElementById("android:id/button1");
//		el18.click();
//		MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
//		el19.click();
//		el19.sendKeys("Tester");
//	}
//	@Test(description = "Validate assign Step2", priority = 6)
//	public void DeliverHandoverParcel() {
//		MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/et_time_of_delivery_mm");
//		el20.click();
//		MobileElement el21 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.Button[1]");
//		el21.click();
//		MobileElement el22 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.Button[1]");
//		el22.click();
//		MobileElement el23 = (MobileElement) driver.findElementById("android:id/button1");
//		el23.click();
//		MobileElement el24 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
//		el24.click();
////		MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_grv");
////		el25.click();
//		MobileElement el25 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_five");
//		el25.click();
//		MobileElement el26 = (MobileElement) driver.findElementById("com.ram.courier:id/et_grv_no");
//		el26.click();
//		el26.sendKeys("TesterGRV1234");
//		MobileElement el27 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receivers_name");
//		el27.sendKeys("GRVReceiver");
//		MobileElement el28 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan");
//		el28.click();
////		MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_invoice");
//		MobileElement el29 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_six");
//		el29.click();
////		MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//		MobileElement el30 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
//		el30.click();
//		MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
//		el31.click();
//
//	}
//
//
//	@Test(description = "Validate assign Step2", priority = 7)
//	public void DeliverGrpHandoverParcel() {
//		MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
//		el32.click();
//		MobileElement el33 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
//		el33.click();
//		MobileElement el34 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//		el34.click();
//		MobileElement el35 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.CheckBox");
//		el35.click();
//		MobileElement el36 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//		el36.click();
//		MobileElement el37 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//		el37.click();
//		el37.sendKeys("CELLC11663226.001");
//		MobileElement el38 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//		el38.click();
//		MobileElement el39 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//		el39.sendKeys("CELLC11663226.002");
//		MobileElement el40 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//		el40.click();
//		MobileElement el41 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//		el41.sendKeys("CELLC11663226.003");
//		MobileElement el42 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//		el42.click();
//		MobileElement el43 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//		el43.sendKeys("CELLC11663226.004");
//		MobileElement el44 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//		el44.click();
//		el44.click();
//		MobileElement el45 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//		el45.click();
//		MobileElement el46 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
//		el46.click();
//		MobileElement el47 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//		el47.click();
//		MobileElement el48 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
//		el48.click();
//		MobileElement el49 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//		el49.click();
//		MobileElement el50 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//
//		el50.click();
//
//
//	}
//	@Test(description = "Validate assign Step2", priority = 8)
//	public void EnterReceiverName() {
//		MobileElement el51 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView");
//		el51.click();
//		MobileElement el52 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
//		el52.click();
//		MobileElement el53 = (MobileElement) driver.findElementById("com.ram.courier:id/cb_select_consignment");
//		el53.click();
//		MobileElement el54 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//		el54.click();
//		MobileElement el55 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
//		el55.click();
//		MobileElement el56 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout");
//		el56.click();
//		MobileElement el58 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout");
//		el58.click();
//		MobileElement el119 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
//		el119.click();
//		el119.sendKeys("GrpTester");
//		MobileElement el62 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
//		el62.click();
//
//	}
//
//
//	@Test(description = "Validate assign Step2", priority = 9)
//	public void EnterHandoverParcel2() {
//		MobileElement el31 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
//		el31.click();
//		MobileElement el32 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
//		el32.click();
//		MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_handover_parcels");
//		el1.click();
//		MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
//		el2.click();
//		MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//		el3.click();
//		MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
//		el4.click();
//		el4.sendKeys("W0707910.001");
//		MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
//		el5.click();
//		MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
//		el6.click();
//		MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
//		el7.click();
//		MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
//		el8.click();
//		MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout");
//		el9.click();
//		MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
//		el10.click();
//		MobileElement el11 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_finish");
//		el11.click();
//	}
//
//	@Test(description = "Validate assign Step2", priority = 10)
//	public void EnterReceiverNametoDeliverHandoverPrcl() {
//
//	MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout");
//el12.click();
//	MobileElement el13 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
//el13.click();
//	MobileElement el14 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
//el14.click();
//	MobileElement el15 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_next_deliveries");
//el15.click();
//	MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
//el16.click();
//	MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
//el17.click();
//el17.sendKeys("RAMDelivery");
//	MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit");
//el18.click();
//
//
//}

    }
