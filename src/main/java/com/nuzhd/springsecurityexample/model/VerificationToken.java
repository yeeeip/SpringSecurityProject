package com.nuzhd.springsecurityexample.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private Date expirationTime;

    private static final int EXPIRATION_TIME_MINUTES = 10;
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
        this.expirationTime = calculateExpirationTime(EXPIRATION_TIME_MINUTES);

    }

    private Date calculateExpirationTime(int expirationTime) {
        Calendar date = Calendar.getInstance();

        return new Date(date.getTimeInMillis() + ((long) expirationTime * 60 * 1000));
    }

}
