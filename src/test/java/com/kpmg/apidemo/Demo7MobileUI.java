package com.kpmg.apidemo;

import java.util.Map;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

/**
 * 
 * https://github.com/microsoft/playwright/blob/main/packages/playwright-core/src/server/deviceDescriptorsSource.json
 */
public class Demo7MobileUI {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

//		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
//				  .setViewportSize(1280, 1024));

        // Emulate iPhone 13 Pro
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setDeviceScaleFactor(3)
            .setViewportSize(414, 736)
            //.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15")
            .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/26.0 Mobile/15A372 Safari/604.1")
            .setHasTouch(true)
            .setIsMobile(true));
        
        Page page = context.newPage();

		page.navigate("https://www.facebook.com/");
		
		page.locator("xpath=//input").nth(0).fill("hello2232343434343@gmail.com");
	
		page.locator("xpath=//input").nth(1).fill("welcom222");
		

		
		
		playwright.close();
		
	
		
	}

}
