package com.src.controller.Simple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.src.bean.JPA.BookEntity;
import com.src.bean.Simple.BookBean;
import com.src.dao.JPA.BookRepository;
import com.src.dao.Simple.BookDao;
import com.src.services.FileService;

//@Controller
@ResponseBody
@RestController //(for API. It is not use for browser)
//@CrossOrigin (Perform apis on different plateforms)
public class BookController {

	@Autowired
	public BookDao bookDao;//for normal
	
	@Autowired 
	public BookRepository bookRepo;//for jpa to store the data in database
	
	@Autowired
	public FileService fileService;//file service 
	
	//for normal operations
	@RequestMapping(value = "/bookText",method = RequestMethod.GET)
	@ResponseBody
	public String showText() {
		return "This is Sample Text";
	}
	
	@RequestMapping(value = "/particularBook",method = RequestMethod.GET)
	public BookBean particularBookUsingId() {
		return bookDao.getBookById(22);
	}

	@GetMapping("/book/{pages}")
	public BookBean particularBookUsingPage(@PathVariable("pages") int pages) {
		return bookDao.getBookByPages(pages);
	}
	
	@PostMapping("/book")
	public void addBook(@RequestBody BookBean book) {//pass       @RequestBody BookBean book     in parameter for passing book in parameter
//		bookDao.addBook(new BookBean(44,"This is book4",77));
		bookDao.addBook(book);
	}
	
	@GetMapping("/books")
	public List<BookBean> getAllBook(){
		return bookDao.getAllBooks();
	}
	
	@DeleteMapping("/book/{id}")
	public List<BookBean> deleteParticularBook(@PathVariable("id") int id){
		return bookDao.deleteParticularBook(id);
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<BookBean> updateParticularBook(@RequestBody BookBean book, @PathVariable("id") int id) {
		
		 if(book.getId() != 0) {			 
			 bookDao.updateParticularBook(book,id);
			 return ResponseEntity.of(Optional.of(book));
//			 return ResponseEntity.ok(book);
//			 return ResponseEntity.ok().body(book);
		 }
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//jpa request for database store
	
	
	@GetMapping("/bookjpa/{pages}")
	public ResponseEntity<BookEntity> particularBookUsingPageJpa(@PathVariable("pages") int pages) {
		BookEntity book = bookRepo.findByPages(pages);
		if(book == null || book.equals("")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	@PostMapping("/bookjpa")
	public void addBookJpa(@RequestBody BookEntity book) {//pass       @RequestBody BookBean book     in parameter for passing book in parameter
//		bookDao.addBook(new BookBean(44,"This is book4",77));
		bookRepo.save(book);
	}
	
	@GetMapping("/booksjpa")
	public ResponseEntity<List<BookEntity>> getAllBookJpa(){
		return ResponseEntity.ok((List<BookEntity>)bookRepo.findAll());
	}
	
	@DeleteMapping("/bookjpa/{id}")
	public ResponseEntity<String> deleteParticularBookJpa(@PathVariable("id") int id){
		try {
			bookRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(id+" is deleted.");
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " is not found.");
		}
		
	}
	
	@PutMapping("/bookjpa/{id}")
	public ResponseEntity<BookEntity> updateParticularBookJpa(@RequestBody BookEntity book, @PathVariable("id") int id) {
		
		 if(book.getId() != 0) {			 
			 BookEntity books =  bookRepo.findById(id);
			 books.setName(book.getName());
			 books.setPages(book.getPages());
			 books.setAuthor(book.getAuthor());
			 bookRepo.save(books);
			 return ResponseEntity.of(Optional.of(book));
		 }
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFileInLocal(MultipartFile file){
		
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please send loaded file");
			}else if(!file.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please Upload JPEG Files only");
			}
			
			boolean is_check = fileService.isFileUpload(file); 
			if(is_check) {
				return ResponseEntity.status(HttpStatus.OK).body(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
	}
	
}
