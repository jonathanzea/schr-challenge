package com.weathermiddle.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.weathermiddle.util.GeneralEnum;
import com.weathermiddle.util.GeneralUtils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/weadthermidle/weather-in")
@Api(value = "Weather", description = "Weather Midleware API")
public class WeatherMiddlewareController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get the current temperature for a city name introduced.", notes = "The temperature will be in Celsisus Degrees")
	public Object getWeatherForCity(@RequestParam(value = "city", required = true) String city) {
		Map<String, Double> temperatureResponse = getTemperatureForCityFromAPI(city);

		return temperatureResponse;
	}

	@SuppressWarnings("unchecked")
	private Map<String, Double> getTemperatureForCityFromAPI(String city) {
		Map<String, Double> temperatureResponse = new HashMap<String, Double>();
		Map<String, Object> apiRawWeatherInfoMap = new HashMap<String, Object>();
		RestTemplate restTemplate = new RestTemplate();
		apiRawWeatherInfoMap = restTemplate.getForObject("http://samples.openweathermap.org/data/2.5/weather?q=" + city
				+ "&appid=b6907d289e10d714a6e88b30761fae22", Map.class);

		Map<String, Double> cityTemperatures = (Map<String, Double>) apiRawWeatherInfoMap
				.get(GeneralEnum.MAIN_KEY.value());

		Double temperatureInCelsius = GeneralUtils
				.getTemperatureInCelsiusFromKelvin(cityTemperatures.get(GeneralEnum.TEMP_KEY.value()));

		temperatureResponse.put(GeneralEnum.TEMPERATURE_KEY.value(), temperatureInCelsius);

		return temperatureResponse;
	}

}
