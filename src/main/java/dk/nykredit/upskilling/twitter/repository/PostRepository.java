package dk.nykredit.upskilling.twitter.repository;

import java.util.List;

import dk.nykredit.upskilling.twitter.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    @Query("SELECT p from Post p where p.createdBy.id = :userId ")
    List<Post> listPosts(@Param("userId") String userId, Pageable pageable);
}
