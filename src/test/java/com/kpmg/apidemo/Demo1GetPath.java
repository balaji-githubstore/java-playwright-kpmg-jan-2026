package com.kpmg.apidemo;

import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.impl.RequestOptionsImpl;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class Demo1GetPath {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		
		APIRequestContext context= playwright.request().newContext(new NewContextOptions().setBaseURL("https://petstore.swagger.io"));
		
		APIResponse response= context.get("/v2/pet/10");
		
		System.out.println(response.status());
		System.out.println(response.body());
		System.out.println(response.text());
		System.out.println(response.headers());
	}

}
