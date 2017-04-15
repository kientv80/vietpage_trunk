package com.vnsoft.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2091126192846824476L;
	int id;
	String name;
	String description;
	Date date;
	List<Item> items = new ArrayList<Item>();
	private int comid;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	public Menu(int id,String name,String description) {
		this.id = id;
		this.name=name;
		this.description=description;
		this.date = new Date();
	}
	public Menu(String name,String description, int comid) {
		this.name=name;
		this.description=description;
		this.date = new Date();
		this.comid = comid;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}

}
