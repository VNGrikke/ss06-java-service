package java_web.ss06bt.service;

import java_web.ss06bt.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
//    Book getBookById(Long id);
    Book saveBook(Book book);
    void deleteBookById(Long id);
    Book updateBook(Book book, Long id);
}
