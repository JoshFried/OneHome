package com.htne.helpthehomeless.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class LocationDTO {
    private Long   id;
    private Long   placeId;
    private double longitude;
    private double latitude;
}
