package com.test;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InlineTime {


    AndroidDriver<AndroidElement> driver;
    @Test
    public void TimeChoose() throws MalformedURLException, MalformedURLException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);


        AndroidElement view =driver.findElementByAccessibilityId("Views");
        tap(view);
        driver.findElementByAccessibilityId("Date Widgets").click();
        driver.findElementByXPath("//*[@content-desc=\"2. Inline\"]").click();
        driver.findElementByAccessibilityId("3").click();

        AndroidElement source =  driver.findElementByAccessibilityId("15");
        AndroidElement target =  driver.findElementByAccessibilityId("45");
        new AndroidTouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();



    }

    private void tap(AndroidElement view) {
        new AndroidTouchAction(driver)
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(view)))
                .perform();

    }
}
