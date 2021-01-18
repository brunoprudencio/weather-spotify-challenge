package com.example.backend.resources.main;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.structure.openweather.services.OpenWeatherService;
import com.example.backend.structure.spotify.service.SpotifyService;

@RestController
@RequestMapping("/retrieve/tracks")
public class AppResource {

	private final SpotifyService spotifyService;
	private final OpenWeatherService openWeatherService;

	public AppResource(SpotifyService spotifyService,
			OpenWeatherService openWeatherService) {
		this.spotifyService = spotifyService;
		this.openWeatherService = openWeatherService;
	}

	@GetMapping("/{city}")
	public String getTracks(@PathVariable("city") String city)
			throws IOException, InterruptedException {
		return spotifyService.fetchTracks( openWeatherService.findTrackStyleBy( city ) );
	}
}
