package com.gj.common.dto;

import org.apache.ibatis.type.Alias;

@Alias("tradecategory")
public class TradeCategoryDTO {
	private int tradeCode;
	private String tradeName;

	public TradeCategoryDTO() {
	}

	public int getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(int tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	@Override
	public String toString() {
		return "TradeCateogryDTO [tradeCode=" + tradeCode + ", tradeName=" + tradeName + "]";
	}

}
