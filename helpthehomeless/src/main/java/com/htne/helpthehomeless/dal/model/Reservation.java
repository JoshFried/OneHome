package com.htne.helpthehomeless.dal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    @Column
    private Long    id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Shelter shelter;
    @OneToOne(cascade = CascadeType.PERSIST)
    private User    user;
    private Date    createdAt;
    private Date    expiresAt;
}
