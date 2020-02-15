package com.gj.common;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA512Encryption {
	private final String saltKey = "makejy";

	public String encryption(String input) {
		String result = "";
		if (input != null && !input.equals("")) {
			input += saltKey;
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-512");
				digest.reset();
				digest.update(input.getBytes("utf8"));
				result = String.format("%0128x", new BigInteger(1, digest.digest()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			result = "";
		}
		return result;
	}
}
