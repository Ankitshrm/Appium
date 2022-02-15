package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.security.krb5.internal.crypto.Des;

import java.net.MalformedURLException;
import java.net.URL;

public class FindElement {

   @Test
    public void Element() throws MalformedURLException {

       DesiredCapabilities capabilities =new DesiredCapabilities();
       capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
       capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi 10");
       capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
       capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");

       AndroidDriver<AndroidElement> driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
//        driver.findElementByAccessibilityId("Graphics").click();
//        driver.findElementByClassName(""); //ClassName
//        driver.findElementByXPath(""); //XPath
//        driver.findElementById("android:id/text1").click(); //Resource id
       driver.findElementByAndroidUIAutomator("textContains(\"Views\")").click();
       driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\"Radio Group\"))").click();


   }

}
