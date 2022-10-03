package com.nuzhd.springsecurityexample.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private MyUser user;

    public VerificationToken() {
    }

    public VerificationToken(String token, MyUser user) {
        super();
        this.token = token;
        this.user = user;
        this.expirationTime = Date.from(Instant.now().plus());
    }

}
