package com.example.backend.structure.openweather.factory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import com.example.backend.structure.openweather.enums.TrackStylesEnum;

class TrackStylesFactoryTest {

	@Test
	void shouldGetTrackStyle() {
		int temp = 17;

		TrackStylesEnum stylesEnum = TrackStylesFactory.getTrackStyle( temp );

		assertThat( stylesEnum, equalTo( TrackStylesEnum.POP ) );
	}

	@Test
	void shouldReturnClassicalMusic() {
		int temp = 9;

		TrackStylesEnum stylesEnum = TrackStylesFactory.getTrackStyle( temp );

		assertThat( stylesEnum, notNullValue() );
		assertThat( stylesEnum, equalTo( TrackStylesEnum.CLASSICAL ) );
	}

}
