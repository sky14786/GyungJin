package com.gj.common.dto;

import org.apache.ibatis.type.Alias;

@Alias("client")
public class ClientDTO {
	private int clientCode;
	private String clientName;
	private String clientCustomer;
	private String clientTel;
	private int clinetCount;

	public ClientDTO() {
	}

	public ClientDTO(int clientCode, String clientName, String clientCustomer, String clientTel, int clinetCount) {
		super();
		this.clientCode = clientCode;
		this.clientName = clientName;
		this.clientCustomer = clientCustomer;
		this.clientTel = clientTel;
		this.clinetCount = clinetCount;
	}

	public int getClientCode() {
		return clientCode;
	}

	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
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

	public int getClinetCount() {
		return clinetCount;
	}

	public void setClinetCount(int clinetCount) {
		this.clinetCount = clinetCount;
	}

	@Override
	public String toString() {
		return "ClientDTO [clientCode=" + clientCode + ", clientName=" + clientName + ", clientCustomer="
				+ clientCustomer + ", clientTel=" + clientTel + ", clinetCount=" + clinetCount + "]";
	}

}
