package com.htne.helpthehomeless.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class ShelterDTO {
    private Long        id;
    private Long        placeId;
    private String      name;
    private LocationDTO location;
    private String      webSite;
    private RulesDTO    rules;
}