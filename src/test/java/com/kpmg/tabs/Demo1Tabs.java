package com.kpmg.tabs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Demo1Tabs {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		//tab 1
		Page page = context.newPage();
		String url="https://www.db4free.net/";

		page.navigate(url);

		//expected new tab/window to open and return the page
		//tab2
		Page newPage = page.waitForPopup(() -> {
			page.locator("xpath=//b[contains(text(),'phpMyAdmin')]").click();
		});

		newPage.locator("xpath=//input[@id='input_username']").fill("admin");
		newPage.locator("xpath=//input[@id='input_password']").fill("admin123");
		newPage.locator("xpath=//input[@id='input_go']").click();
		
		//get the complete error " Access denied for use" and print it
		String actualError= newPage.locator("xpath=//div[contains(text(),'Access')]").innerText();
		System.out.println(actualError);
	
		page.waitForTimeout(5000);

		playwright.close();

	}

}
