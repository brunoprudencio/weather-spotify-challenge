package com.example.backend.structure.openweather.usecases;

import static java.net.URI.create;
import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Slf4j
@Component
public class FetchOpenWeatherData {

	private static final String UNIT_TYPE = "&units=metric";
	private static final String API_TOKEN = "&appid=b77e07f479efe92156376a8b07640ced";
	private static final String OPENWEATHER_URI = "https://api.openweathermap.org/data/2.5/weather?q=";

	public JsonObject fetch(String city) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri( create( OPENWEATHER_URI + encode( city, UTF_8 ) + UNIT_TYPE + API_TOKEN ) )
				.header( "Accept", "application/json" )
				.GET()
				.build();

		var response = client.send( request, HttpResponse.BodyHandlers.ofString() );
		return toJsonObject( response );

	}

	private JsonObject toJsonObject(HttpResponse<String> response) {
		return JsonParser.parseString( response.body() ).getAsJsonObject();
	}
}
