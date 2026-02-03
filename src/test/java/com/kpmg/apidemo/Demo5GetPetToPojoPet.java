package com.kpmg.apidemo;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpmg.model.Pet;
import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.impl.RequestOptionsImpl;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class Demo5GetPetToPojoPet {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		Playwright playwright=Playwright.create();
		
		APIRequestContext context= playwright.request().newContext(new NewContextOptions().setBaseURL("https://petstore.swagger.io"));
		
		APIResponse response= context.get("/v2/pet/10");
		
		System.out.println(response.status());
		System.out.println(response.body());
		System.out.println(response.text());
		System.out.println(response.headers());
		
		
		//To JsonNode
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.valueToTree(response.headers());
		System.out.println(jsonNode.toPrettyString());
		System.out.println(jsonNode.get("server").asText());
		
		
		//To Pet Object
//		ObjectMapper mapper = new ObjectMapper();
        Pet pet = mapper.readValue(response.body(), Pet.class);
        System.out.println(pet.getId());
        
	}

}
