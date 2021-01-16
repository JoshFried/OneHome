package com.htne.helpthehomeless.dal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Location {
    @Id
    @GeneratedValue
    @Column
    private Long   id;
    private String streetLine1;
    private String streetLine2;
    private String postalCode;
    private String province;
    private String city;
    private String country;
    private double longitude;
    private double latitude;
}
