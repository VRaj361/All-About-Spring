package com.src.dao.JPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.src.bean.JPA.BookEntity;

@Repository
public interface BookRepository  extends CrudRepository<BookEntity, Integer>{

	BookEntity findByPages(int pages);
	
	BookEntity findById(int id);

}
