package dk.nykredit.upskilling.twitter.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOG")
public class Log {

    @Id
    private String id;

    @Column(name = "LOGGED_AT", nullable = false)
    private LocalDateTime loggedAt;

    @Column(name = "OPERATION_TYPE", nullable = false)
    private String type;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "POST_ID", referencedColumnName = "ID")
    private Post post;

    @OneToOne
    @JoinColumn(name = "POST_LIKED_ID", referencedColumnName = "ID")
    private PostLiked postLiked;

    @OneToOne
    @JoinColumn(name = "POST_SHARED_ID", referencedColumnName = "ID")
    private PostShared postShared;
}
