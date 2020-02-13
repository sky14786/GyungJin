package com.gj.common.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("client")
public class ClientDTO {
	private int clientCode;
	private int clientCategory;
	private String clientName;
	private String clientCustomer;
	private String clientTel;
	private LocalDateTime regDate;
	private String useYn;
	private LocalDateTime updDate;
	private String updUser;

	public ClientDTO() {
	}

	public int getClientCode() {
		return clientCode;
	}

	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}

	public int getClientCategory() {
		return clientCategory;
	}

	public void setClientCategory(int clientCategory) {
		this.clientCategory = clientCategory;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientCustomer() {
		return clientCustomer;
	}

	public void setClientCustomer(String clientCustomer) {
		this.clientCustomer = clientCustomer;
	}

	public String getClientTel() {
		return clientTel;
	}

	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
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

	@Override
	public String toString() {
		return "ClientDTO [clientCode=" + clientCode + ", clientCategory=" + clientCategory + ", clientName="
				+ clientName + ", clientCustomer=" + clientCustomer + ", clientTel=" + clientTel + ", regDate="
				+ regDate + ", useYn=" + useYn + ", updDate=" + updDate + ", updUser=" + updUser + "]";
	}

}
