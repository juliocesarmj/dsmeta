package com.juliomoraes.dsmeta.sale.dto;

import java.time.LocalDate;

import com.juliomoraes.dsmeta.entities.Sale;

public class SaleDTO {
	
	private Long id;
	private String sellerName;
	private int visited;
	private double deals;
	private double amount;
	private LocalDate date;
	
	public SaleDTO(Sale entity) {
		id = entity.getId();
		sellerName = entity.getSellerName();
		visited = entity.getVisited();
		deals = entity.getDeals();
		amount = entity.getAmount();
		date = entity.getDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}

	public double getDeals() {
		return deals;
	}

	public void setDeals(double deals) {
		this.deals = deals;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
