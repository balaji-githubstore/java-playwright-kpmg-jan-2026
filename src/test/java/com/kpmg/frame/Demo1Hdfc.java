package com.kpmg.frame;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
//frame using xpath
public class Demo1Hdfc {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		// tab 1
		Page page = context.newPage();

		page.navigate("https://netbanking.hdfcbank.com/netbanking/");

		FrameLocator frameLoginPage = page.frameLocator("xpath=//frame[@name='login_page']");
		frameLoginPage.locator("xpath=//input[@name='fldLoginUserId']").fill("john123");
		// click on Continue
		frameLoginPage.locator("xpath=//a[text()='CONTINUE']").click();

		
		page.waitForTimeout(5000);
		playwright.close();

	}

}
