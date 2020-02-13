package com.gj.common.dto;

import org.apache.ibatis.type.Alias;

@Alias("clientcategory")
public class ClientCategoryDTO {
	private int clientCateCode;
	private String clientCateName;

	public ClientCategoryDTO() {
	}

	public int getClientCateCode() {
		return clientCateCode;
	}

	public void setClientCateCode(int clientCateCode) {
		this.clientCateCode = clientCateCode;
	}

	public String getClientCateName() {
		return clientCateName;
	}

	public void setClientCateName(String clientCateName) {
		this.clientCateName = clientCateName;
	}

	@Override
	public String toString() {
		return "ClientCategoryDTO [clientCateCode=" + clientCateCode + ", clientCateName=" + clientCateName + "]";
	}

}
