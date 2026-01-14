package com.kpmg.tabs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForLoadStateOptions;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class Demo2Tabs {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		// tab 1
		Page page = context.newPage();

		page.navigate("https://www.online.citibank.co.in/");
		
		page.locator("xpath=//button[text()='Accept All' and @id='onetrust-accept-btn-handler']").click();
		
		page.locator("xpath=//div[text()='My Account']").hover();
		
		//div[text()='Banking with Citi']
		Page newPage = page.waitForPopup(() -> {
			page.locator("xpath=//div[text()='Banking with Citi']").click();
		});
		
		//enter username as john123
		newPage.waitForLoadState(LoadState.LOAD,new WaitForLoadStateOptions().setTimeout(60000));
		
		newPage.waitForSelector("xpath=//input[@id='username']", new WaitForSelectorOptions().setTimeout(60000));
		
		//setting at page level to increase default timeout from 30s to 60s for all 
		newPage.setDefaultTimeout(60000);
		
		newPage.locator("xpath=//input[@id='username']").fill("john");
		
//		Task 3 (Important) - Multiple tabs
//		1.      Navigate onto https://www.online.citibank.co.in/
//		2.      Accept cookies
//		3.      Mousehover on My Account
//		4.      Click on Banking with citi
//		5.      In new tab
//		6.      Enter userid as john123
//		7.      Click on signup
//		8.      Get the error displayed for the password
		
		
		page.waitForTimeout(5000);
		playwright.close();
	}

}
