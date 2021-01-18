package com.example.backend.structure.spotify.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.backend.structure.openweather.enums.TrackStylesEnum;
import com.example.backend.structure.spotify.usecase.FetchSpotifyData;

@Service
public class SpotifyService {

	private final FetchSpotifyData spotifyData;

	public SpotifyService(FetchSpotifyData spotifyData) {
		this.spotifyData = spotifyData;
	}

	public String fetchTracks(TrackStylesEnum category) throws IOException, InterruptedException {
		return spotifyData.fetch( category.toString() );
	}
}
