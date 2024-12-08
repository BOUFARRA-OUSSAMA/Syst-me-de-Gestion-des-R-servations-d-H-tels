package com.example.hotel_reservation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class ReservationGraphQLResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private ReservationService reservationService;

    public Reservation createReservation(String clientName, Date startDate, Date endDate, String roomPreferences) {
        Reservation reservation = new Reservation();
        reservation.setClientName(clientName);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setRoomPreferences(roomPreferences);
        return reservationService.createReservation(reservation);
    }

    public Optional<Reservation> getReservation(Long id) {
        return reservationService.getReservation(id);
    }

    public Reservation updateReservation(Long id, String clientName, Date startDate, Date endDate, String roomPreferences) {
        Reservation reservationDetails = new Reservation();
        reservationDetails.setClientName(clientName);
        reservationDetails.setStartDate(startDate);
        reservationDetails.setEndDate(endDate);
        reservationDetails.setRoomPreferences(roomPreferences);
        return reservationService.updateReservation(id, reservationDetails);
    }

    public void deleteReservation(Long id) {
        reservationService.deleteReservation(id);
    }
}