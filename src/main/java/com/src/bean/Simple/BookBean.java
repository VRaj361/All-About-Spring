package com.src.bean.Simple;

public class BookBean {
	int id;
	String name;
	int pages;
	//this is simple book bean
	public BookBean() {
		super();
	}
	public BookBean(int id, String name, int pages) {
		super();
		this.id = id;
		this.name = name;
		this.pages = pages;
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
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	@Override
	public String toString() {
		return "BookBean [id=" + id + ", name=" + name + ", pages=" + pages + "]";
	}
	
}
