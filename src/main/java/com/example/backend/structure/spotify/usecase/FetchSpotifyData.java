package com.example.backend.structure.spotify.usecase;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

@Component
public class FetchSpotifyData {

	private static final String SPOTIFY_URI = "https://api.spotify.com/v1/browse/categories/";
	private static final String PLAYLISTS = "/playlists";
	private static final String API_TOKEN = "BQDH3uuMWVjhMNJSjq_vzpbDE7dWN4Pnl4wiI-7pMIoI8QlLZqdTogFmuSYhtjvM7HHRzWN1WkfdOmhsJAtUhNKFXJtuF4q8J-DFlkQ3rsLbP0HwYkvh8o5K5Ogi0aFTyTh_a1eHQf3J2_Dd8QTzbu0KhAFlj9p8MW6OVyu00bK7k6dw";

	public String fetch(String style) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri( URI.create( SPOTIFY_URI + style.toLowerCase() + PLAYLISTS ) )
				.header( "Accept", "application/json" )
				.headers( "Authorization", "Bearer " + API_TOKEN )
				.GET()
				.build();

		return client.send( request, HttpResponse.BodyHandlers.ofString() ).body();
	}
}
