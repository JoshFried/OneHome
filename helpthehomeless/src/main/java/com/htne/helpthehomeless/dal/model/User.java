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
@Table(name = "\"user\"")
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