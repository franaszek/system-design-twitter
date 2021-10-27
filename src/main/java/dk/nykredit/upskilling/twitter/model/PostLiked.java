package dk.nykredit.upskilling.twitter.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POST_LIKED")
public class PostLiked {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "POST_ID", referencedColumnName = "ID")
    private Post post;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    public PostLiked(User user, Post post) {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.user = user;
        this.post = post;
    }
}
