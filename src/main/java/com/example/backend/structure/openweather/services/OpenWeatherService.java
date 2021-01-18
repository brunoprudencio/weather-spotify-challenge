package com.example.backend.structure.openweather.services;

import static java.util.Optional.of;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.backend.structure.openweather.enums.TrackStylesEnum;
import com.example.backend.structure.openweather.factory.TrackStylesFactory;
import com.example.backend.structure.openweather.usecases.FetchOpenWeatherData;
import com.google.gson.JsonElement;

@Service
public class OpenWeatherService {

	private final FetchOpenWeatherData fetchOpenWeatherData;

	public OpenWeatherService(FetchOpenWeatherData fetchOpenWeatherData) {
		this.fetchOpenWeatherData = fetchOpenWeatherData;
	}

	public TrackStylesEnum findTrackStyleBy(String cityName) throws IOException, InterruptedException {
		return TrackStylesFactory.getTrackStyle( getTemperatureOf( cityName ) );
	}

	private Integer getTemperatureOf(String cityName) throws IOException, InterruptedException {
		var response = fetchOpenWeatherData.fetch( cityName );
		return of( response.get( "main" ) )
				.map( JsonElement::getAsJsonObject )
				.map( jsonObject -> jsonObject.get( "temp" ) )
				.map( JsonElement::getAsInt )
				.orElseThrow();
	}
}
