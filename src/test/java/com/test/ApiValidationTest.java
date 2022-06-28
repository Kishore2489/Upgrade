package com.test;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jayway.restassured.RestAssured;
import com.qa.api.StateInfo;
import com.qa.api.Statelist;
import com.qa.api.StatesInfo;

public class ApiValidationTest {

	public StatesInfo statesInfo;
	public Statelist statelist;

	/**
	* The method gets the response from the api
	* deserializes to class States Info matching the schema
	* predefined states in US 
	* Adding a dummy message 
	*/
	@BeforeTest
	public void getResponse() {

		try {
			RestAssured.baseURI = "https://credapi.credify.tech/api/loanapp/v1/states";
			String response = RestAssured.get(RestAssured.baseURI).asString();

			Gson gson = new Gson();
			
			/*Deserializing the response to StateInfo objects*/
			statesInfo = gson.fromJson(response, StatesInfo.class);
			
			/*Getting Predefined list of state names*/
			statelist = new Statelist();

		} catch (JsonSyntaxException e) {
			System.out.println(e);
		}
	}

	
	/**
	* The method iterates through each states in the APi 
	* and verifies if it is a valid comparing it with list of 
	* predefined states in US 
	* 
	*/
	@Test
	public void validateStateCode() {

		for (StateInfo StateInfo : statesInfo.getStates()) {
			Assert.assertTrue(statelist.statelist.containsKey(StateInfo.getLabel()),
					StateInfo.getLabel() + "Not a valid state");
		}
	}

	
	/**
	* The method validates only one states has Minimum age 19
	* Prints the only state with Minimum age 19
	*  
	*/
	@Test
	public void validateStateMinAge() {

		List<StateInfo> statesWithMinAge = statesInfo.getStates().stream().filter(state -> state.getMinAge() == 19)
				.collect(Collectors.toList());
		Assert.assertEquals(statesWithMinAge.size(), 1);
		Reporter.log("Only state with min age as 19 :  " + statesWithMinAge.get(0).getLabel());
	}
	
	/**
	* The method validates only one states has Minimum loan requirement of $3,005
	* Prints the only stare with Minimum loan requirement of $3,005
	*  
	*/
	@Test
	public void validateStateMinLoanAmount() {

		List<StateInfo> statesWithMinAge = statesInfo.getStates().stream()
				.filter(state -> state.getMinLoanAmount() == 3005).collect(Collectors.toList());
		Assert.assertEquals(statesWithMinAge.size(), 1);
		Reporter.log(
				"Only state with with min loan amount requirement of $3,005 :  " + statesWithMinAge.get(0).getLabel());
	}

}
