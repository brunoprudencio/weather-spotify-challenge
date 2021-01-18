package com.example.backend.structure.openweather.factory;

import java.util.Arrays;

import lombok.experimental.UtilityClass;

import com.example.backend.structure.openweather.enums.TrackStylesEnum;

@UtilityClass
public class TrackStylesFactory {

	public static TrackStylesEnum getTrackStyle(int temperature) {
		return Arrays.stream( TrackStylesEnum.values() )
				.filter( track -> track.matchWith( temperature ) )
				.findFirst()
				.orElse( TrackStylesEnum.CLASSICAL );
	}
}
