package com.rest.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.book.model.Book;
import com.rest.book.repository.BookRepository;

@RestController
public class BookController {


	
@Autowired
private BookRepository bookRepository;
	

  @PostMapping("/book")
  public Book saveBook(@RequestBody Book book) {
	Book b= bookRepository.save(book);
	  return b;
  }
  
  @GetMapping("/books/{id}")
  public Book getBookById(@PathVariable("id") int id) {
	   Book b=null;
	  Optional<Book> book= bookRepository.findById(id);
     if(book.isPresent()) {
    	 b=book.get();
    	 System.out.println(b);
     }
     else {
    	System.out.println("Something Went wrong");
     }
     return b;
}
 
  @PostMapping("/books")
  public List<Book> saveAll(@RequestBody List<Book> books){
	  
	  List<Book> b=bookRepository.saveAll(books);
	  
	  return b;
  }
  @GetMapping("/All_books")
  public List<Book> getAllBooks(){
	 List<Book> b=bookRepository.findAll();
	 
	 b.forEach(bk->{
		 System.out.println(bk);
	 });
	 
	   return b;
  }
  
}
