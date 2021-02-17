package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.dal.dao.PickupRepository;
import com.htne.helpthehomeless.dal.dao.ReservationRepository;
import com.htne.helpthehomeless.dal.dao.UserRepository;
import com.htne.helpthehomeless.dal.model.Pickup;
import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dto.PickupDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PickupService {
    private final PickupRepository      pickupRepository;
    private final ReservationRepository reservationRepository;
    private final UserService           userService;
    private final ConversionService     mvcConversionService;

    public PickupDTO createPickup(int distance, Long reservationId, Date date){
        User user = userService.getUserFromContext();
        Reservation reservation = reservationRepository.findById(reservationId).get();
        return mvcConversionService.convert(
                pickupRepository.save(Pickup.builder()
                                              .arrivalTime(date)
                                              .user(user)
                                              .reservation(reservation)
                                              .distance(distance)
                                              .createdAt(Date.from(Instant.now()))
                                              .build()),
                    PickupDTO.class
                );
    }

    public Boolean deletePickup(Long id){
        Pickup pickup = pickupRepository.getOne(id);
        pickupRepository.delete(pickup);
        return !pickupRepository.existsById(pickup.getId());
    }
}
