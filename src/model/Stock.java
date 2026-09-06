package model;

import java.time.LocalDate;

public class Stock {
	private int id;
	private String name;
	private LocalDate purchaseDate;
	private int stock;
	private LocalDate expirationDate;
	
	public Stock(int id, String name, LocalDate purchaseDate, int stock, LocalDate expirationDate) {
		super();
		this.id = id;
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.stock = stock;
		this.expirationDate = expirationDate;
	}
	
	public Stock() {
		
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
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
