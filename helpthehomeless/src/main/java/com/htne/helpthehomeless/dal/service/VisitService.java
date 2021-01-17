package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.dal.dao.VisitRepository;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.model.Visit;
import com.htne.helpthehomeless.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;

@RequiredArgsConstructor
@Service
public class VisitService {
    private final VisitRepository   visitRepository;
    private final ConversionService mvcConversionService;

    public Visit createVisit(final ReservationDTO rsvp) {
        return visitRepository.save(Visit.builder()
                                         .user(mvcConversionService.convert(rsvp.getUser(), User.class))
                                         .shelter(mvcConversionService.convert(rsvp.getShelter(), Shelter.class))
                                         .date(Date.from(Instant.now()))
                                         .build());

    }
}
