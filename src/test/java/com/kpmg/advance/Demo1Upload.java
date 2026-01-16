package com.kpmg.advance;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Demo1Upload {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		// tab 1
		Page page = context.newPage();

		page.navigate("https://www.ilovepdf.com/pdf_to_word");
		
		page.locator("xpath=//input[@type='file']").setInputFiles(Paths.get("C:\\AutomationSession\\demo.pdf"));

		
		page.waitForTimeout(5000);
		playwright.close();

	}

}
