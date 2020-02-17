package com.gj.common;

import java.time.LocalDateTime;

public class UTCMapper {
	public static LocalDateTime toKor(LocalDateTime temp) {
		return temp.plusHours(9);
	}

	public static LocalDateTime fromKor(LocalDateTime temp) {
		return temp.minusHours(9);
	}
}
