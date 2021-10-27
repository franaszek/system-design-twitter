package dk.nykredit.upskilling.twitter.repository;

import dk.nykredit.upskilling.twitter.model.PostLiked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikePostRepository extends JpaRepository<PostLiked, String> {
}
