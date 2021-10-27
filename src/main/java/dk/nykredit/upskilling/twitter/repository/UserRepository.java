package dk.nykredit.upskilling.twitter.repository;

import java.util.List;

import dk.nykredit.upskilling.twitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
