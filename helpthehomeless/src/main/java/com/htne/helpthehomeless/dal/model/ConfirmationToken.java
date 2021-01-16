package com.htne.helpthehomeless.dal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken {
    @Id
    @GeneratedValue
    @Column(name = "token_id")
    private long   tokenId;
    private String confirmationToken;
    private Date   dateCreated;
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User   user;

    public ConfirmationToken(final User user) {
        this.user         = user;
        dateCreated       = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }
}
