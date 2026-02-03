package com.kpmg.apidemo;

import java.io.IOException;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.model.SimpleRequest;
import com.atlassian.oai.validator.model.SimpleResponse;
import com.atlassian.oai.validator.report.ValidationReport;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

import io.restassured.path.json.JsonPath;
import io.swagger.util.Json;

public class Demo6GetOpenAPISpecSwagger {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		String baseUrl = "https://petstore.swagger.io";
		String resource = "/v2/pet/10";
		Playwright playwright = Playwright.create();

		APIRequestContext context = playwright.request().newContext(new NewContextOptions().setBaseURL(baseUrl));

		APIResponse responseObj = context.get(resource);

		System.out.println(responseObj.status());
		System.out.println(responseObj.body());
		System.out.println(responseObj.text());
		System.out.println(responseObj.headers());
		
	

		 OpenApiInteractionValidator validator = 
		            OpenApiInteractionValidator.createFor("files/petstore.yaml").build();
		 
		 // Create request & response objects for validation
         SimpleRequest request = SimpleRequest.Builder.get("/pet/10")
                 .build();

         SimpleResponse response = SimpleResponse.Builder
                 .status(responseObj.status())
                 .withBody(responseObj.text())
                 .build();

         // Validate
         ValidationReport report = validator.validate(request, response);
         
         System.out.println(report.getMessages());
         System.out.println(report.hasErrors());
         
         System.out.println("--------------------------");

	}

}
