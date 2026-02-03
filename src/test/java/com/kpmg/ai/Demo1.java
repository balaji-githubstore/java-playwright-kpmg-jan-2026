package com.kpmg.ai;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Demo1 {

	public static void main(String[] args) {
		// Create Playwright and launch a visible Chrome browser
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		// 1. Navigate to Facebook
		page.navigate("https://www.facebook.com/");

		// 2. Enter invalid email and password
		page.locator("xpath=//input[@id='email']").fill("invalid@example.com");
		page.locator("xpath=//input[@id='pass']").fill("wrongpassword");

		// 3. Click the Login button
		page.locator("xpath=//button[@name='login' or @id='loginbutton'] | //button[contains(., 'Log In')] ").click();

		// 4. Wait for an error message to appear
		// Facebook shows different error UI depending on geolocation and flow; wait for a few possible selectors.
		String[] errorSelectors = new String[] {
			"xpath=//div[contains(@role,'alert') and .//text()]",
			"xpath=//div[contains(text(),'The password you')]",
			"xpath=//div[contains(text(),'Incorrect')]",
			"xpath=//div[contains(text(),'Log in to continue')]",
			"xpath=//div[contains(@class,'_9ay7')]", // common error class on FB
		};

		boolean errorVisible = false;
		for (String sel : errorSelectors) {
			try {
				// wait up to 5 seconds for the selector to appear
				if (page.waitForSelector(sel, new Page.WaitForSelectorOptions().setTimeout(5000)) != null) {
					errorVisible = true;
					System.out.println("Found error using selector: " + sel);
					String txt = page.locator(sel).innerText();
					System.out.println("Error text: " + txt);
					break;
				}
			} catch (Exception e) {
				// ignore and try next selector
			}
		}

		// 5. Assert error message is visible (simple print assertion)
		if (errorVisible) {
			System.out.println("TEST PASS: Error message is visible for invalid credentials.");
		} else {
			System.out.println("TEST FAIL: No error message detected after invalid login.");
		}

		// pause briefly so human can see the result when running non-headless
		page.waitForTimeout(3000);

		// 6. Close Playwright (which closes browser)
		playwright.close();
	}

}