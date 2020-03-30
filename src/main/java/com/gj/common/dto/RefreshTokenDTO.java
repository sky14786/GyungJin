package com.gj.common.dto;

import org.apache.ibatis.type.Alias;

@Alias("refreshToken")
public class RefreshTokenDTO {
	private String memId;
	private String memReToken;

	public RefreshTokenDTO() {
	}

	public RefreshTokenDTO(String memId, String memReToken) {
		super();
		this.memId = memId;
		this.memReToken = memReToken;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemReToken() {
		return memReToken;
	}

	public void setMemReToken(String memReToken) {
		this.memReToken = memReToken;
	}

	@Override
	public String toString() {
		return "RefreshTokenDTO [memId=" + memId + ", memReToken=" + memReToken + "]";
	}

}
