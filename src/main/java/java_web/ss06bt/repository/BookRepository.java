package java_web.ss06bt.repository;


import java_web.ss06bt.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
