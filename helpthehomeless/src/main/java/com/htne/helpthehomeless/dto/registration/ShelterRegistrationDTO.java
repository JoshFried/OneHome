package com.htne.helpthehomeless.dto.registration;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.htne.helpthehomeless.dto.LocationDTO;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class ShelterRegistrationDTO {
    private Long        id;
    private String      name;
    private LocationDTO location;
    private String      webSite;
    private int         capacity;
}
