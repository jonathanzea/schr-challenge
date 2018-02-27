package com.weathermiddle.util;
/*
 * An Enum class to retrieve some Json and Maps Keys
 */
public enum GeneralEnum {
	
	  MAIN_KEY("main"),
	  TEMP_KEY("temp"),
	  TEMPERATURE_KEY("temperature"), 
	  DEFAULT_CITY("Caracas");

	    private String value;

	    GeneralEnum(String value) {
	        this.value = value;
	    }

	    public String value() {
	        return value;
	    }

}
