package com.gj.common.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("member")
public class MemberDTO {
	private int memCode;
	private String memName;
	private String memId;
	private String memPwd;
	private String memTel;
	private String memBirth;
	private int memType;
	private LocalDateTime regDate;
	private String useYn;
	private LocalDateTime updDate;
	private String updUser;
	private String mailYn;
	private String smsYn;
	private String memNick;

	public MemberDTO() {
		this.memCode = 0;
		this.memType = 0;
		this.mailYn = "";
		this.smsYn = "";
		this.useYn = "";
		this.updUser = "";
	}

	public int getMemCode() {
		return memCode;
	}

	public void setMemCode(int memCode) {
		this.memCode = memCode;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}

	public int getMemType() {
		return memType;
	}

	public void setMemType(int memType) {
		this.memType = memType;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public LocalDateTime getUpdDate() {
		return updDate;
	}

	public void setUpdDate(LocalDateTime updDate) {
		this.updDate = updDate;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public String getMailYn() {
		return mailYn;
	}

	public void setMailYn(String mailYn) {
		this.mailYn = mailYn;
	}

	public String getSmsYn() {
		return smsYn;
	}

	public void setSmsYn(String smsYn) {
		this.smsYn = smsYn;
	}

	public String getMemNick() {
		return memNick;
	}

	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}

	@Override
	public String toString() {
		return "MemberDTO [memCode=" + memCode + ", memName=" + memName + ", memId=" + memId + ", memPwd=" + memPwd
				+ ", memTel=" + memTel + ", memBirth=" + memBirth + ", memType=" + memType + ", regDate=" + regDate
				+ ", useYn=" + useYn + ", updDate=" + updDate + ", updUser=" + updUser + ", mailYn=" + mailYn
				+ ", smsYn=" + smsYn + ", memNick=" + memNick + "]";
	}

}
