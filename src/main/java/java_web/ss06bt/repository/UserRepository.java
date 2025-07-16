package java_web.ss06bt.repository;


import java_web.ss06bt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
