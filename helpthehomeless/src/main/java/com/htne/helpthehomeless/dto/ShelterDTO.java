package com.htne.helpthehomeless.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class ShelterDTO {
    private Long        id;
    private String      name;
    private LocationDTO location;
    private String      webSite;
    private RulesDTO    rules;
}