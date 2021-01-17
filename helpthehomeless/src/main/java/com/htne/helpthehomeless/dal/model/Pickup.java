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
public class Pickup {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @OneToOne
    private Reservation reservation;
    @OneToOne
    private User user;
    private Date createdAt;
    private Date arrivalTime;
    private double distance;
}
