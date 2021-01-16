package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.converters.dto2entity.LocationDTOToLocationConverter;
import com.google.maps.GeoApiContext;
import com.google.maps.TextSearchRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.htne.helpthehomeless.dal.dao.LocationRepository;
import com.htne.helpthehomeless.dal.dao.ShelterRepository;
import com.htne.helpthehomeless.dal.dao.mapper.ShelterMapper;
import com.htne.helpthehomeless.dal.model.Role;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.service.exceptions.ExceptionHelper;
import com.htne.helpthehomeless.dal.service.exceptions.HTNENotFoundException;
import com.htne.helpthehomeless.dto.ShelterDTO;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShelterService {
    private final ShelterRepository  shelterRepository;
    private final ConversionService  mvcConversionService;
    private final UserService        userService;
    private final LocationRepository locationRepository;

    public ShelterDTO createShelter(final ShelterDTO dto) {
        final User user = userService.getUserFromContext();

        if (user.getRole() != Role.ADMIN) {
            throw new HTNENotFoundException("Invalid Role");
        }

        locationRepository.save(LocationDTOToLocationConverter.convert(dto.getLocation()));
        final Shelter shelter = mvcConversionService.convert(dto, Shelter.class);
        shelter.setUser(user);
        shelterRepository.save(shelter);

        return mvcConversionService.convert(shelter, ShelterDTO.class);
    }

    public ShelterDTO getShelter(final long id) {
        return mvcConversionService.convert(fetchShelter(id), ShelterDTO.class);
    }

    public Shelter fetchShelter(final long id) {
        return shelterRepository.findById(id).orElseThrow(() -> new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Id: ", String.valueOf(id))));
    }

    public ShelterDTO incrementOccupancy(final long id) {
        final Shelter shelter = fetchShelter(id);
        shelter.setOccupancy(+1);
        return mvcConversionService.convert(shelterRepository.save(shelter), ShelterDTO.class);
    }

    public ShelterDTO updateShelter(final ShelterDTO dto) {
        shelterRepository.save(ShelterMapper.updateFields(dto, fetchShelter(dto.getId())));
        return dto;
    }

    public String getRegisteredShelters(double longitude, double latitude, int radius) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDIpjXbG67pNIXxcrACuw8hmI60qb_CWVs")
                .build();
         final String input = "Homeless shelter";
         final com.google.maps.model.LatLng latLng = new com.google.maps.model.LatLng(latitude, longitude);
         final TextSearchRequest txtRequest = new TextSearchRequest(context);
         txtRequest.radius(radius);
         txtRequest.location(latLng);
         txtRequest.query(input);
         PlacesSearchResponse response = txtRequest.await();
         PlacesSearchResult[] places = response.results;
         List<Shelter> registeredShelterList = new ArrayList<>();

         for(PlacesSearchResult place : places){
             Optional<Shelter> shelter = shelterRepository.findByName(place.name);
             if(shelter.isPresent()){
                 registeredShelterList.add(shelter.get());
             }
         }

         for(Shelter shelter : shelterRepository.findAll()){
             if(distance(shelter.getLocation().getLatitude(), shelter.getLocation().getLongitude(), latitude, longitude,
                     "K") <= radius/1000) {
                 registeredShelterList.add(shelter);
             };
         }

         String registeredShelterJSON = new GsonJsonProvider().toJson(registeredShelterList);
         return registeredShelterJSON;
    }

    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

}
