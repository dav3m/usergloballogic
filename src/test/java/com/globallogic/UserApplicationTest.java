package com.globallogic;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.UserApplication;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class UserApplicationTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8888;
    }

    @org.junit.Test
    public void login() {
		
		Map<String, String>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("email", "juan@gmail.com");
		jsonAsMap.put("password", "Test123");
		
        given().
        body(jsonAsMap).contentType(ContentType.JSON).
		when().
		        post("globallogic/login").
		then().
		statusCode(200).
		       and().
		   contentType(ContentType.JSON);
	} 
	
	@org.junit.Test
    public void getUsers() {
		
		given().get("globallogic/users").then()
		 .assertThat().statusCode(200).
        	and().
        		contentType(ContentType.JSON);

	} 
	
	@org.junit.Test
    public void getUser() {
		
		given().pathParams("id", "ba4852d81bc84466b42d295b238c102a")
		.get("globallogic/users/{id}").then()
		 .assertThat().statusCode(200).
        	and().
        		contentType(ContentType.JSON);

	} 
	
    @org.junit.Test
    public void register() {
		
		Map<String, String>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("name", "Juan Rodriguez");
		jsonAsMap.put("email", "juan@gmail.com");
        jsonAsMap.put("password", "Test123");
        
        given().
        body(jsonAsMap).contentType(ContentType.JSON).
		when().
		        post("globallogic/register").
		then().
		statusCode(200).
		       and().
		   contentType(ContentType.JSON);
	} 

	
}

