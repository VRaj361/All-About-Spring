package com.src.bean.JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="authorsjpa")
public class AuthorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorid;
	private String name;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference//for back the reference so it can not create book object again
	private BookEntity book;
	
	
	public AuthorEntity() {
		super();
	}

	public AuthorEntity(int authorid, String name) {
		super();
		this.authorid = authorid;
		this.name = name;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}
	
	
}
