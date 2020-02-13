package com.gj.common.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("transaction")
public class TransactionDTO {
	private int traCode;
	private int traCategory;
	private int traClient;
	private String traName;
	private String traTel;
	private String traCustomer;
	private String traAddr;
	private String traAddrDetail;
	private LocalDateTime regDate;
	private String useYn;
	private LocalDateTime updDate;
	private String updUser;
	private int traCost;
	private int traPrice;
	private int traTax;
	private String traPayment;
	private String traMemo;
	private String traMaterial;

	public TransactionDTO() {
	}

	public int getTraCode() {
		return traCode;
	}

	public void setTraCode(int traCode) {
		this.traCode = traCode;
	}

	public int getTraCategory() {
		return traCategory;
	}

	public void setTraCategory(int traCategory) {
		this.traCategory = traCategory;
	}

	public int getTraClient() {
		return traClient;
	}

	public void setTraClient(int traClient) {
		this.traClient = traClient;
	}

	public String getTraName() {
		return traName;
	}

	public void setTraName(String traName) {
		this.traName = traName;
	}

	public String getTraTel() {
		return traTel;
	}

	public void setTraTel(String traTel) {
		this.traTel = traTel;
	}

	public String getTraCustomer() {
		return traCustomer;
	}

	public void setTraCustomer(String traCustomer) {
		this.traCustomer = traCustomer;
	}

	public String getTraAddr() {
		return traAddr;
	}

	public void setTraAddr(String traAddr) {
		this.traAddr = traAddr;
	}

	public String getTraAddrDetail() {
		return traAddrDetail;
	}

	public void setTraAddrDetail(String traAddrDetail) {
		this.traAddrDetail = traAddrDetail;
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

	public int getTraCost() {
		return traCost;
	}

	public void setTraCost(int traCost) {
		this.traCost = traCost;
	}

	public int getTraPrice() {
		return traPrice;
	}

	public void setTraPrice(int traPrice) {
		this.traPrice = traPrice;
	}

	public int getTraTax() {
		return traTax;
	}

	public void setTraTax(int traTax) {
		this.traTax = traTax;
	}

	public String getTraPayment() {
		return traPayment;
	}

	public void setTraPayment(String traPayment) {
		this.traPayment = traPayment;
	}

	public String getTraMemo() {
		return traMemo;
	}

	public void setTraMemo(String traMemo) {
		this.traMemo = traMemo;
	}

	public String getTraMaterial() {
		return traMaterial;
	}

	public void setTraMaterial(String traMaterial) {
		this.traMaterial = traMaterial;
	}

	@Override
	public String toString() {
		return "TransactionDTO [traCode=" + traCode + ", traCategory=" + traCategory + ", traClient=" + traClient
				+ ", traName=" + traName + ", traTel=" + traTel + ", traCustomer=" + traCustomer + ", traAddr="
				+ traAddr + ", traAddrDetail=" + traAddrDetail + ", regDate=" + regDate + ", useYn=" + useYn
				+ ", updDate=" + updDate + ", updUser=" + updUser + ", traCost=" + traCost + ", traPrice=" + traPrice
				+ ", traTax=" + traTax + ", traPayment=" + traPayment + ", traMemo=" + traMemo + ", traMaterial="
				+ traMaterial + "]";
	}

}
