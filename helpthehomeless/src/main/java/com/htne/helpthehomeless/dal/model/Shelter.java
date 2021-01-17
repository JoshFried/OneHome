package com.htne.helpthehomeless.dal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Shelter {
    @Id
    @GeneratedValue
    private Long        id;
    private String      name;
    @OneToOne(cascade = CascadeType.ALL)
    private Location    location;
    @OneToOne
    private User        user;
    private String      webSite;
    @OneToOne(cascade = CascadeType.ALL)
    private Rules       rules;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<User>   visitors;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<User>   waitingList;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Visit> history;
}
