package com.discord;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class api {
  public String apid(String temp, String password, String quota) {
	  try {
		HttpResponse<String> response3 = Unirest.post("https://basic.proxiesapi.xyz/proxy_api/v1/basic/users/create")
				   .header("Authorization", "Bearer 69e5c480-dedb-11eb-ba80-0242ac130004")
				   .header("Content-Type", "application/json")
				      .body("{\n    \"username\": \""+temp+"\"\n}")
				   .asString();
		String yes = response3.getBody();
		System.out.println(yes);
	     JSONObject jsonObject = new JSONObject(yes);
	     String yes3 =  jsonObject.get("username").toString(); 
	     System.out.println(yes3);
		  return yes3;
	    } catch (UnirestException e) {
		}
		// TODO Auto-generated catch block
		return null;
	}
  }

