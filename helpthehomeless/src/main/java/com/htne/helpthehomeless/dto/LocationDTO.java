package com.htne.helpthehomeless.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class LocationDTO {
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
