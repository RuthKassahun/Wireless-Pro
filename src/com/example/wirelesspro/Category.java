package com.example.wirelesspro;

public class Category {

	public static final int chapter1=1;
	public static final int chapter2=2;
	public static final int chapter3=3;
	public static final int chapter4=4;
	public static final int chapter5=5;
	
	private int id;
	private String name;
	
	public Category (){
	
	}

	public Category(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString(){
		return getName();
	}
	
}
