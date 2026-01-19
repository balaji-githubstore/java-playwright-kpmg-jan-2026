package com.kpmg.advance;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.FrameLocator.GetByTextOptions;
import com.microsoft.playwright.FileChooser;

//Option 3 - handler Method page.onFileChooser()
public class Demo3Upload {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		// tab 1
		Page page = context.newPage();

		page.navigate("https://www.ilovepdf.com/pdf_to_word");
		
		//registering the file handler
		page.onFileChooser((fileChooser)->{
			fileChooser.setFiles(Paths.get("C:\\AutomationSession\\demo.pdf"));
		});	
		page.locator("xpath=//span[text()='Select PDF file']").click();
		
		page.locator("xpath=//span[text()='Convert to WORD']").click();	
		
		Download download= page.waitForDownload(()->{
			page.locator("xpath=//a[contains(normalize-space(),'Download WO')]").click();
		});
		
		download.saveAs(Paths.get(download.suggestedFilename()));
		
		page.waitForTimeout(5000);
		playwright.close();

	}

}
