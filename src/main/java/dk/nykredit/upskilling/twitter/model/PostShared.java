package dk.nykredit.upskilling.twitter.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POST_SHARED")
public class PostShared {

    @Id
    private String id;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "POST_ID", referencedColumnName = "ID")
    private Post post;

    @OneToOne
    @JoinColumn(name = "FROM_USER_ID", referencedColumnName = "ID")
    private User userFrom;

    @OneToOne
    @JoinColumn(name = "TO_USER_ID", referencedColumnName = "ID")
    private User userTo;

}
