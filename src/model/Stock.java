package model;

import java.time.LocalDate;

public class Stock {
	private int id;
	private String name;
	private int stock;
	private LocalDate purchaseDate;
	private LocalDate expirationDate;
	
	
	public Stock(int id, String name, int stock, LocalDate purchaseDate, LocalDate expirationDate) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.purchaseDate = purchaseDate;
		this.expirationDate = expirationDate;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public LocalDate getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}


	@Override
	public String toString() {
		return "ID:" + id + "品名:" + name + "在庫数:" + stock + "購入日:" + purchaseDate + "消費期限:" + expirationDate;
	}
	
	
}
