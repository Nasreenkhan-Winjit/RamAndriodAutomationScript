package RamTestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BulkCollectionTest extends ExtentReportBuilder {
    public AppiumDriver<MobileElement> driver;
    private static ExtentReports extent;

    private int totalCollectionCount;

    public ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

    public ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();


    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.createInstance("~\\..\\Result\\BulkCollectionTest.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\BulkCollectionTest.html");
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setReportName("AutomationReport-BulkCollectionTest");
        htmlReporter.config().setDocumentTitle("AutomationReport-BulkCollectionTest");

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
        cap.setCapability("appWaitActivity", "*");
//		cap.setCapability("app","C:/Users/nasreenk/Desktop/Diawi/RAMMobile_UatDebug-2.9.23-2.apk" );

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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


    public void scroll() {
        List<MobileElement> lists = driver.findElements(By.xpath("//android.widget.CheckBox"));

        for (MobileElement e : lists)
            System.out.println(e.getAttribute("text"));
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touch = new TouchAction(driver);
        touch.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y)).release().perform();

    }

    @Test(description = "Open collection module", priority = 0)
    public void clickOnCollectionModuleAndVerify() {

        MobileElement OnTheRoad = driver.findElementById("com.ram.courier:id/ll_on_the_road");
        OnTheRoad.click();
        MobileElement ClickOnCollection = driver.findElementById("com.ram.courier:id/ll_collections");
        ClickOnCollection.click();
        List<MobileElement> mobileElements =
                (List<MobileElement>) driver.findElementsByClassName("android.support.v7.app.a$b");

        MobileElement mobileElement = mobileElements.get(1);
        String collectionCount = mobileElement.getAttribute("content-desc").replace("Pending(", "");
        totalCollectionCount = Integer.parseInt(collectionCount.replace(")", ""));
        System.out.println("Print Element " + totalCollectionCount);
//        System.out.println("Print Element"+ mobileElement.getAttribute("content-desc").replace("Pending(", ""));
        mobileElement.click();

    }

    @Test(description = "Accept collection with reason", priority = 1)
    public void selectCollections() throws InterruptedException {
        int numOfpages = 6;
        for (int i = 1; i <= numOfpages; i++) {   // page//i < 41
            for (int j = 1; j < 6; j++) {    // elements
                MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[" + j + "]/android.widget.LinearLayout/android.widget.CheckBox");
                el7.click();
                //sleep
                Thread.sleep(4000);
            }
            scroll();
            //sleep
            Thread.sleep(5000);

        }

        totalCollectionCount = numOfpages * 5;
        System.out.println("collections selected");
        MobileElement BtnProceed = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
        BtnProceed.click();


    }


    @Test(description = "Accept all collection ", priority = 2)
    public void accept50PercentCollections() {
        float percentage;


//        MobileElement AcceptBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_accept");

        //toatlcollection---50%  == count -for loop navigate for accept.click() ;


//         int k = (int)(value*(percentage/100.0f));


        int totalAcceptCount = (totalCollectionCount * 50) / 100;

        for (int i = 0; i < totalAcceptCount; i++) {
            MobileElement AcceptBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_accept");
            AcceptBtn.click();
        }

//


    }

    @Test(description = "Reject with reasons ", priority = 3)
    public void rejectWithReason() {
        // First 3 parcel rejected

        int totalRejectCount = (totalCollectionCount * 50) / 100;

        for (int i = 0; i < totalRejectCount; i++) {
            if (i % 2 == 0) {
                MobileElement RejectBtn = driver.findElementById("com.ram.courier:id/btn_reject");
                RejectBtn.click();
                MobileElement RejectReason1 = driver.findElementById("com.ram.courier:id/tv_reason1");
                RejectReason1.click();
            } else if (i % 3 == 0) {
                MobileElement RejectBtn2 = driver.findElementById("com.ram.courier:id/btn_reject");
                RejectBtn2.click();
                MobileElement RejectReason3 = driver.findElementById("com.ram.courier:id/tv_reason3");
                RejectReason3.click();

            } else {
                MobileElement RejectBtn1 = driver.findElementById("com.ram.courier:id/btn_reject");
                RejectBtn1.click();
                MobileElement RejectReason2 = driver.findElementById("com.ram.courier:id/tv_reason2");
                RejectReason2.click();
            }


        }

    }

    @Test(description = " Select 1 to 5 collections and perform collect and missed ", priority = 4)
    public void selectCollectionsOnCollectionTab() {
        int numberOfPages = 3;
        for (int i = 1; i <= numberOfPages; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j % 2 == 0) {
                    collectParcel(i, j);
                } else {
                    MissedParcel(i, j);
                }
                scroll();
            }
        }
    }

    private void MissedParcel(int i, int j) {
        MobileElement select2nd = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout/android.widget.CheckBox");
        select2nd.click();
        MobileElement proceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
        proceedBtn.click();
        MobileElement missedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_missed");
        missedBtn.click();
        MobileElement selectReasonField = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
        selectReasonField.click();
        MobileElement selectReason1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        selectReason1.click();

        MobileElement enterSenderName = (MobileElement) driver.findElementByXPath("com.ram.courier:id/et_sender_name");
        enterSenderName.click();
        enterSenderName.sendKeys("Test01");
        MobileElement clickOnSubmitBtn = (MobileElement) driver.findElementByXPath("com.ram.courier:id/btn_missing_collection");
        clickOnSubmitBtn.click();

    }

    private void collectParcel(int i, int j) {
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[" + j + "]/android.widget.LinearLayout/android.widget.CheckBox");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_collection");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_collect");
        el3.click();


        MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
        el4.sendKeys("RW098019" + i + j + ".001");
        // Incremented ++ function can be used to differ the consignment id

        MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_waybill");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/et_collected_from");
        el8.sendKeys("Test01");
        MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.click();
    }






}

