package com.kpmg.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Demo4Salesforce {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext(); // kind of profile in browser
		Page page = context.newPage(); // tab 1

		page.navigate("https://www.salesforce.com/form/signup/freetrial-salesforce-starter/?d=pb");
		
		page.locator("xpath=//input[@name='UserFirstName']").fill("jack");
		page.locator("xpath=//input[@name='UserLastName']").fill("jack");
		page.locator("xpath=//input[@name='UserTitle']").fill("Manager");
		
		//span[text()='Next']
		page.locator("xpath=//a[@data-page-cntrl='next']").click();
		
		page.locator("xpath=//select[@name='CompanyEmployees']").selectOption(new SelectOption().setLabel("21 - 200 employees"));
		
		page.locator("xpath=//input[@name='CompanyName']").fill("RPS");
		
		page.locator("xpath=//a[@data-page-cntrl='next']").click();
		
		page.locator("xpath=//input[@name='UserEmail']").fill("Manager@gmail.com");
		
		page.locator("xpath=(//div[@class='checkbox-ui'])[2]").click();
		
		String actualError= page.locator("xpath=//span[contains(text(),'valid phone')]").innerText();
		
		System.out.println(actualError);
		
		page.waitForTimeout(5000);
		
		playwright.close();
		

	}

}
