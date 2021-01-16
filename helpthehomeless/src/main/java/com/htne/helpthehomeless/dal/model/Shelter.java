package com.htne.helpthehomeless.dal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Shelter {
    @Id
    @GeneratedValue
    @Column
    private Long     id;
    private String   name;
    private int      capacity;
    private int      occupancy;
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    @OneToOne
    private User     user;
    private String   webSite;
}
