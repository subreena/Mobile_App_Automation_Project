package config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Setup {
    public AndroidDriver driver;
    public static final String PACKAGE_ID = "com.google.android.calculator";
    @BeforeTest
    public void setup() throws MalformedURLException {
 //        {
//            "platformName": "Android",
//                "appium:os": "16",
//                "appium:app": "G:\\SQA\\mobile_app_automation\\calculator.apk",
//                "appium:appPackage": "com.google.android.calculator",
//                "appium:appActivity": "com.android.calculator2.Calculator",
//                "appium:automationName": "UIAutomator2",
//                "appium:ensureWebviewsHavePages": true,
//                "appium:nativeWebScreenshot": true,
//                "appium:newCommandTimeout": 3600,
//                "appium:connectHardwareKeyboard": true,
//                "appium:disableAndroidWatchers": true,
//                "appium:uiautomator2ServerLaunchTimeout": 120000
//        }
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("appium:os","16");
        caps.setCapability("appium:app", System.getProperty("user.dir")+"/src/test/resources/calculator.apk");
        caps.setCapability("appium:appPackage",PACKAGE_ID);
        caps.setCapability("appium:appActivity","com.android.calculator2.Calculator");
        caps.setCapability("appium:automationName","UIAutomator2");
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);
        caps.setCapability("appium:disableAndroidWatchers", true);
        caps.setCapability("appium:uiautomator2ServerLaunchTimeout", 120000);
        caps.setCapability("appium:adbExecTimeout", 120000);

        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(url,caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @AfterTest
    public void closeApp(){
        driver.quit();
    }
}