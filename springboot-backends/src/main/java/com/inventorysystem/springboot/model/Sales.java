package com.inventorysystem.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;



@Entity
@Table(name="Sales")
public class Sales {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)private long id;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_number")
	private int itemNumber;
	@Column(name="quantity")
	private long quantity;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="customer_id")
	private int customerId;
	@Column(name="unity_price")
	private long unityPrice;
	@Column(name="total_stock")
	private long totalStock;
	@Column(name="sale_id")
	private int saleId;
	@Column(name="discount")
	private long discount;
	@Column(name="sale_date")
	private long saleDate;
	@Column(name="total")
	private long total;
	
	

   
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public long getUnityPrice() {
		return unityPrice;
	}
	public void setUnityPrice(long unityPrice) {
		this.unityPrice = unityPrice;
	}
	public long getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(long totalStock) {
		this.totalStock = totalStock;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public long getDiscount() {
		return discount;
	}
	public void setDiscount(long discount) {
		this.discount = discount;
	}
	public long getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(long saleDate) {
		this.saleDate = saleDate;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
 

	}
