package com.gj.common.dto;

import org.apache.ibatis.type.Alias;

@Alias("material")
public class MaterialDTO {
	private int matCode;
	private String matName;
	private String matSize;
	private int matPrice;
	private int matCost;

	public MaterialDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getMatCode() {
		return matCode;
	}

	public void setMatCode(int matCode) {
		this.matCode = matCode;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getMatSize() {
		return matSize;
	}

	public void setMatSize(String matSize) {
		this.matSize = matSize;
	}

	public int getMatPrice() {
		return matPrice;
	}

	public void setMatPrice(int matPrice) {
		this.matPrice = matPrice;
	}

	public int getMatCost() {
		return matCost;
	}

	public void setMatCost(int matCost) {
		this.matCost = matCost;
	}

	@Override
	public String toString() {
		return "MaterialDTO [matCode=" + matCode + ", matName=" + matName + ", matSize=" + matSize + ", matPrice="
				+ matPrice + ", matCost=" + matCost + "]";
	}

}
