package java_web.ss06bt.controller;

import java_web.ss06bt.dto.response.DataResponse;
import java_web.ss06bt.entity.Book;
import java_web.ss06bt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Book>>> getBooks() {
        return new ResponseEntity<>(new DataResponse<>(bookService.getBooks(), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Book>> saveBook(Book book) {
        return new ResponseEntity<>(new DataResponse<>(bookService.saveBook(book), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse<String>> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(new DataResponse<>("Book with id " + id + " deleted", HttpStatus.OK), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<Book>> updateBook(@RequestBody Book book, @PathVariable Long id) {
        return new ResponseEntity<>(new DataResponse<>(bookService.updateBook(book, id), HttpStatus.OK), HttpStatus.OK);
    }
}
