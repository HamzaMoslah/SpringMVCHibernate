package controller;


import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BookService;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book){
        long id = bookService.save(book);
        return ResponseEntity.ok().body("New book has been saved with ID: " + id);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") long id){
        return ResponseEntity.ok().body(bookService.get(id));
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> list(){
        return ResponseEntity.ok().body(bookService.list());
    }

    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok().body("Hello World!");
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        bookService.delete(id);
        return ResponseEntity.ok().body("Book has been deleted successfully");
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book){
        bookService.update(id, book);
        return ResponseEntity.ok().body("Book has been updated successfully");
    }
}
