package com.kpmg.apitest;

import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class Demo1PostPet {

	public static void main(String[] args) {
		
		
		
		String baseUrl="https://petstore.swagger.io";
		String resource="/v2/pet/10";
		
		Playwright playwright = Playwright.create();
		
		APIRequestContext context= playwright.request().newContext(new NewContextOptions().setBaseURL(baseUrl));

		APIResponse response= context.get(resource);
		
		System.out.println(response.status());
		System.out.println(response.text());
		System.out.println(response.body());
		
	}

}
