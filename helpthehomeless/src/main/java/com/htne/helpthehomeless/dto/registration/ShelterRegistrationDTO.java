package com.htne.helpthehomeless.dto.registration;

import com.htne.helpthehomeless.dto.LocationDTO;
import lombok.Data;

@Data
public class ShelterRegistrationDTO {
    private Long        id;
    private String      name;
    private LocationDTO location;
    private String      webSite;
}
