package com.src.dao.Simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.src.bean.Simple.BookBean;

@Repository
public class BookDao {
	
	private static List<BookBean> books = new ArrayList<>();
	
	static {
		books.add(new BookBean(11,"This is book1",22));
		books.add(new BookBean(22,"This is book2",33));
		books.add(new BookBean(33,"This is book3",44));
	}
	
	public List<BookBean> getAllBooks(){
		return books;
	}//get all book
	
	public BookBean getBookById(int id) {
		return books.stream().filter(e->e.getId()==id).findFirst().get();
	}//get book using id

	public BookBean getBookByPages(int pages) {
		return books.stream().filter(e->e.getPages()==pages).findAny().get();
	}//get book using page
	
	public void addBook(BookBean book) {
		books.add(book);
	}//add book pass by api
	
	public List<BookBean> deleteParticularBook(int id) {
		
		books = books.stream().filter(book->{
			if(book.getId()!=id) {
				return true;
			}else {
				return false;
			}
			
		}).collect(Collectors.toList());
		return books;
	}// delete particular book
	
	public void updateParticularBook(BookBean b,int id) {
		books = books.stream().map(e->{
			if(e.getId() == id) {
				e.setName(b.getName());
				e.setPages(b.getPages());
			}
			return e;
		}).toList();
//		return books;
	}
	
	
}
