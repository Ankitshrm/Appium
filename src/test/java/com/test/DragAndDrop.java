package com.test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DragAndDrop {

    static AndroidDriver<AndroidElement> driver;

    @Test
    public void DragDrop() throws MalformedURLException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        AndroidElement view =driver.findElementByAccessibilityId("Views");
        tap(view);
        driver.findElementByAccessibilityId("Drag and Drop").click();
        AndroidElement source =driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        AndroidElement target =driver.findElementById("io.appium.android.apis:id/drag_dot_2");

        new AndroidTouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release().perform();

        System.out.println(driver.findElementById("io.appium.android.apis:id/drag_result_text").getText());

    }

    private static void tap(AndroidElement view){
        new AndroidTouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(view))).perform();
    }
}


