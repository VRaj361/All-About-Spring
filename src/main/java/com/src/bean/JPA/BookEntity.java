package com.src.bean.JPA;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "booksjpa")
public class BookEntity {
	
	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid" , strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	int pages;
	
	//when we apply some changes on one entity it is hardly reflect to another entity so we can use CascadeType=ALL 
	//for not create any problem for modify anything in both the entity 
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference//for manage the reference
	private AuthorEntity author;
	
	public BookEntity() {
		super();
	}
	public BookEntity(int id, String name, int pages, AuthorEntity author) {
		super();
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.author = author;
	}
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
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
	
	public AuthorEntity getAuthor() {
		return author;
	}
	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "BookBean [id=" + id + ", name=" + name + ", pages=" + pages + ", id=" + id + "]";
	}
}
