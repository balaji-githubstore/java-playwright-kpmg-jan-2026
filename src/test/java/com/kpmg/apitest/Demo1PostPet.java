package com.kpmg.apitest;

import com.microsoft.playwright.APIRequest.NewContextOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.impl.RequestOptionsImpl;

public class Demo1PostPet {

	public static void main(String[] args) throws IOException {
		
		String jsonBodyStr= Files.readString(Paths.get("files/new_pet.json"));
		
		String baseUrl="https://petstore.swagger.io";
		String resource="/v2/pet";
		
		Playwright playwright = Playwright.create();
		
		APIRequestContext context= playwright.request().newContext(new NewContextOptions().setBaseURL(baseUrl));

		APIResponse response= context.post(resource,
				new RequestOptionsImpl().setHeader("Content-Type", "application/json").setData(jsonBodyStr));
		
		System.out.println(response.status());
		System.out.println(response.text());
		System.out.println(response.body());
		
		playwright.close();
		
	}

}
