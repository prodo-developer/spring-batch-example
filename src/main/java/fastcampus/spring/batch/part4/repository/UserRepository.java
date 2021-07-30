package fastcampus.spring.batch.part4.repository;

import fastcampus.spring.batch.part4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
