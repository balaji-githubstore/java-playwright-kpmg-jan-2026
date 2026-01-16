package com.kpmg.advance;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Demo6Table2 {

	public static void main(String[] args) {
		
	
		for(int r=1;r<=10;r++)
		{
			System.out.println("xpath=//table[@id='example']/tbody/tr["+r+"]/td[2]");
			
		}
		
	
	}

}
