package com.qa.persistence.domain;

public class Item {
	private int id;
	private String name;
	private double cost;
	
	public Item(String name, int id, double cost) {
		this.id=id;
		this.name=name;
		this.cost=cost;
		}

	public Item(String name, double cost) {
		this.cost=cost;
		this.name=name;
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return "id:" + id + " item name:" + name ;
	}
}
