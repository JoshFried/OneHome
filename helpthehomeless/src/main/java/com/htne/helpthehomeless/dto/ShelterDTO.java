package com.htne.helpthehomeless.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class ShelterDTO {
    //    private Long        id;
    private String      name;
    private Integer     capacity;
    private Integer     occupancy;
    private LocationDTO location;
    private String      webSite;
}