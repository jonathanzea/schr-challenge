package com.weathermiddle.util;

import java.text.DecimalFormat;
/*
 * Utility class for weather calculation
 */
public class GeneralUtils {

	public static Double getTemperatureInCelsiusFromKelvin(Double kelvinTemperature) {
		DecimalFormat format = new DecimalFormat(".##");
		Double temperatureInCelsius = Double.parseDouble(format.format(kelvinTemperature - 273.0));
		return temperatureInCelsius;
	}
	
}
