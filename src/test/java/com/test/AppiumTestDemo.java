package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTestDemo {

    @Test
    public void FirstAppiumTest() throws MalformedURLException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi 10");
        capabilities.setCapability(MobileCapabilityType.UDID,"8e3d0077");
        AndroidDriver<AndroidElement> driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByAccessibilityId("Content");
    }
}
