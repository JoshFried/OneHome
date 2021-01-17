package com.htne.helpthehomeless.dal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rules {
    @Id
    @GeneratedValue
    @Column
    private Long    id;
    private Time    checkoutTime;
    private Time    supperTime;
    private Time    checkinTime;
    private int     capacity;
    private boolean males;
    private boolean females;
    private boolean pets;
    private boolean sober;
    private boolean minor;
}
