package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.dal.dao.PickupRepository;
import com.htne.helpthehomeless.dal.dao.ReservationRepository;
import com.htne.helpthehomeless.dal.dao.UserRepository;
import com.htne.helpthehomeless.dal.model.Pickup;
import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PickupService {
    private PickupRepository pickupRepository;
    private ReservationRepository reservationRepository;
    private UserService userService;

    public Pickup createPickup(int distance, Long reservationId, Date date){
        User user = userService.getUserFromContext();
        Reservation reservation = reservationRepository.findById(reservationId).get();

        Pickup pickup = Pickup.builder()
                .arrivalTime(date)
                .user(user)
                .reservation(reservation)
                .distance(distance)
                .createdAt(Date.from(Instant.now()))
                .build();

        pickupRepository.save(pickup);

        return pickup;
    }

    public Boolean deletePickup(Long id){
        Pickup pickup = pickupRepository.getOne(id);
        pickupRepository.delete(pickup);
        return !pickupRepository.existsById(pickup.getId());
    }
}
