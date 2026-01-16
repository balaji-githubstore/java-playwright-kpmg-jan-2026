package com.kpmg.advance;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Demo5Table {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		// tab 1
		Page page = context.newPage();

		page.navigate("https://datatables.net/extensions/select/examples/checkbox/checkbox.html");
		

		
		for(int r=1;r<=10;r++)
		{
			String actualName= page.locator("xpath=//table[@id='example']/tbody/tr["+r+"]/td[2]").innerText();
			System.out.println(actualName);
			
			if(actualName.equals("Brenden Wagner"))
			{
				//click on checkbox
				page.locator("xpath=//table[@id='example']/tbody/tr["+r+"]/td[1]").click();
				break;
			}
			
		}
		
		page.waitForTimeout(5000);
		playwright.close();
	}

}
