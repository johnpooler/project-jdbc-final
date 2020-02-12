package com.qa.persistence.domain;

public class Item {
	private int id;
	private String name;
	private int cost;
	
	public Item(String name, int id, int cost) {
		this.id=id;
		this.name=name;
		this.cost=cost;
		}
	public Item(String name, int id) {
		this.id=id;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return "id:" + id + " item name:" + name ;
	}
}
