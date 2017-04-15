package com.vnsoft.server.tags.yui;

import java.io.Serializable;

public class ChartData implements Serializable{
	private static final long serialVersionUID = 2374651821270559518L;
	private Object x;
	private Object y;
	
	public ChartData(Object x, Object y) {
		this.x = x;
		this.y = y;
	}
	public Object getX() {
		return x;
	}
	public void setX(Object x) {
		this.x = x;
	}
	public Object getY() {
		return y;
	}
	public void setY(Object y) {
		this.y = y;
	}
}
