package com.kpmg.alert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator.ClickOptions;

public class Demo1Alert {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		// tab 1
		Page page = context.newPage();

		page.navigate("https://netbanking.hdfcbank.com/netbanking/IpinResetUsingOTP.htm");

		// register the dialog handler to override the default activity of alert in
		// playwright
		page.onDialog((dialog) -> {
			String actualAlertMessage = dialog.message();
			System.out.println(actualAlertMessage);
			dialog.accept();
		});

	
		// click on Go
		page.locator("//img[@alt='Go']").click();
		
		page.waitForTimeout(5000);
		playwright.close();

	}

}
