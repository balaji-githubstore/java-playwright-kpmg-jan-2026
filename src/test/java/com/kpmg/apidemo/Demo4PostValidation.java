package com.kpmg.apidemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.impl.RequestOptionsImpl;
import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.model.Request;
import com.atlassian.oai.validator.model.SimpleResponse;
import com.atlassian.oai.validator.report.ValidationReport;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class Demo4PostValidation {

	public static void main(String[] args) throws IOException {
		
		String file = Files.readString(Paths.get("files/data.json"));

		Playwright playwright = Playwright.create();

		APIRequestContext context = playwright.request()
				.newContext(new NewContextOptions().setBaseURL("https://petstore.swagger.io"));

		APIResponse response = context.post("/v2/pet",
				new RequestOptionsImpl().setHeader("Content-Type", "application/json").setData(file));

		System.out.println(response.status());
		System.out.println(response.body());
		System.out.println(response.text());
		System.out.println(response.headers());

		SimpleResponse apiResponse = SimpleResponse.Builder.status(response.status()).withBody(response.text()).build();

		OpenApiInteractionValidator validator =
		        OpenApiInteractionValidator.createFor(
		                "files/petstore.yaml"
		        ).build();

		// Validate response
		ValidationReport report = validator.validateResponse("/pet", Request.Method.POST, apiResponse);
	}
}
