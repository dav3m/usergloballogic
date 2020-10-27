package com.globallogic.service;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class UtilService {

	
	private UtilService() {

	}

	public static boolean validaMail(String correo) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(correo);
		return matcher.matches();
	}

	public static boolean validaPassword(String password) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=(.*[\\d]){2,})[A-Za-z\\d]{4,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
	
	 public static String uuid() {  
		 return UUID.randomUUID().toString().replace("-", "");
	} 
	 
	 
	public static String getJWTToken(String email) {
			String secretKey = "mySecretKey";
			
			return Jwts.builder().setId("globalLogicUser").setSubject(email).setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000)).signWith(SignatureAlgorithm.HS512,secretKey.getBytes()).compact();

		}
}
