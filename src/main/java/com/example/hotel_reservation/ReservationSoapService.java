package com.example.hotel_reservation;

import com.example.hotel_reservation.soap.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class ReservationSoapService {
    private static final String NAMESPACE_URI = "http://example.com/hotel_reservation";

    @Autowired
    private ReservationService reservationService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateReservationRequest")
    @ResponsePayload
    public CreateReservationResponse createReservation(@RequestPayload CreateReservationRequest request) {
        Reservation reservation = new Reservation();
        reservation.setClientName(request.getClientName());
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());
        reservation.setRoomPreferences(request.getRoomPreferences());
        Reservation createdReservation = reservationService.createReservation(reservation);
        CreateReservationResponse response = new CreateReservationResponse();
        response.setReservationId(createdReservation.getId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetReservationRequest")
    @ResponsePayload
    public GetReservationResponse getReservation(@RequestPayload GetReservationRequest request) {
        Optional<Reservation> reservation = reservationService.getReservation(request.getReservationId());
        GetReservationResponse response = new GetReservationResponse();
        reservation.ifPresent(res -> {
            response.setClientName(res.getClientName());
            response.setStartDate(res.getStartDate());
            response.setEndDate(res.getEndDate());
            response.setRoomPreferences(res.getRoomPreferences());
        });
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateReservationRequest")
    @ResponsePayload
    public UpdateReservationResponse updateReservation(@RequestPayload UpdateReservationRequest request) {
        Reservation reservationDetails = new Reservation();
        reservationDetails.setClientName(request.getClientName());
        reservationDetails.setStartDate(request.getStartDate());
        reservationDetails.setEndDate(request.getEndDate());
        reservationDetails.setRoomPreferences(request.getRoomPreferences());
        Reservation updatedReservation = reservationService.updateReservation(request.getReservationId(), reservationDetails);
        UpdateReservationResponse response = new UpdateReservationResponse();
        response.setReservationId(updatedReservation.getId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteReservationRequest")
    @ResponsePayload
    public DeleteReservationResponse deleteReservation(@RequestPayload DeleteReservationRequest request) {
        reservationService.deleteReservation(request.getReservationId());
        DeleteReservationResponse response = new DeleteReservationResponse();
        response.setStatus("SUCCESS");
        return response;
    }
}