package com.inventorysystem.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import javax.persistence.Table;

@Entity
@Table(name="Purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)private long id;
	
	private String itemName;
    private int itemNumber;
    private long quantity;
	private String vendorName;
	private int purchaseId;
	private long unityPrice;
	private long currentStock;
	private long saleDate;
	private long totalCost;
	

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public long getUnityPrice() {
		return unityPrice;
	}
	public void setUnityPrice(long unityPrice) {
		this.unityPrice = unityPrice;
	}
	public long getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(long currentStock) {
		this.currentStock = currentStock;
	}
	public long getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(long saleDate) {
		this.saleDate = saleDate;
	}
	public long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	
		
}

			
	
	
