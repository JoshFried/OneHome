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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long    id;
    @Column(unique = true)
    private String  username;
    private String  password;
    @Column(unique = true)
    private String  email;
    private String  firstName;
    private String  lastName;
    private boolean isEnabled;
    private Role    role;
    private Gender  gender;
    private int     age;
}