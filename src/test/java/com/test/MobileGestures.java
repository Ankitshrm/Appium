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

public class MobileGestures {

    static AndroidDriver<AndroidElement> driver;


    @Test
    public void Gesture() throws MalformedURLException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //Single Tap
        AndroidElement view =driver.findElementByAccessibilityId("Views");
        tap(view);
        tapByCordinates(500,1400);
        driver.findElementById("android:id/text1").click();
        AndroidElement peoplename = driver.findElementByXPath("//*[@text='People Names']");
        tapLongPress(peoplename);

    }

    private void tapLongPress(AndroidElement peoplename) {
        new AndroidTouchAction(driver)
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peoplename)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .perform();

    }

    private void tapByCordinates(int x,int y) {
        new AndroidTouchAction(driver).tap(PointOption.point(x,y)).perform();

    }


    private void tap(AndroidElement view) {
        new AndroidTouchAction(driver)
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(view)))
                .perform();

    }
}
