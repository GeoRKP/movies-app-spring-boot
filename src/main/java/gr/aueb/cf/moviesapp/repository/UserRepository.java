package gr.aueb.cf.moviesapp.repository;

import gr.aueb.cf.moviesapp.model.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = ?1 AND u.password = ?2")
    boolean isUserValid(String username, String password);

    @Query("SELECT COUNT(u) > 0 from User u WHERE u.email = ?1")
    boolean emailExists(String email);

    User getUserByEmail(String email);
}
