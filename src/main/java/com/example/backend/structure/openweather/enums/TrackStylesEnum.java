package com.example.backend.structure.openweather.enums;

public enum TrackStylesEnum {

	PARTY {
		@Override
		public boolean matchWith(int temperature) {
			return temperature > 30;
		}
	},
	POP {
		@Override
		public boolean matchWith(int temperature) {
			return temperature >= 15 && temperature <= 30;
		}
	},
	ROCK {
		@Override
		public boolean matchWith(int temperature) {
			return temperature >= 10 && temperature <= 14;
		}
	},
	CLASSICAL {
		@Override
		public boolean matchWith(int temperature) {
			return false;
		}
	};

	public abstract boolean matchWith(int temperature);
}
