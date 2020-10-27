package com.globallogic.model;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"number",
	"citycode",
	"contrycode"
})	
public class Phones {

	@JsonProperty("number")
	private String number;
	@JsonProperty("citycode")
	private String citycode;
	@JsonProperty("contrycode")
	private String contrycode;

		
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getCitycode() {
		return citycode;
	}


	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}


	public String getContrycode() {
		return contrycode;
	}


	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}
}
