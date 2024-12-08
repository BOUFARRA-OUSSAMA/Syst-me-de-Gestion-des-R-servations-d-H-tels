package com.example.hotel_reservation;

import com.example.hotel_reservation.soap.CreateReservationRequest;
import com.example.hotel_reservation.soap.CreateReservationResponse;
import com.example.hotel_reservation.soap.DeleteReservationRequest;
import com.example.hotel_reservation.soap.DeleteReservationResponse;
import com.example.hotel_reservation.soap.GetReservationRequest;
import com.example.hotel_reservation.soap.GetReservationResponse;
import com.example.hotel_reservation.soap.ReservationServiceGrpc;
import com.example.hotel_reservation.soap.UpdateReservationRequest;
import com.example.hotel_reservation.soap.UpdateReservationResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@GrpcService
public class ReservationGrpcService extends ReservationServiceGrpc.ReservationServiceImplBase {
    @Autowired
    private ReservationService reservationService;

    @Override
    public void createReservation(CreateReservationRequest request, StreamObserver<CreateReservationResponse> responseObserver) {
        Reservation reservation = new Reservation();
        reservation.setClientName(request.getClientName());
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());
        reservation.setRoomPreferences(request.getRoomPreferences());
        Reservation createdReservation = reservationService.createReservation(reservation);
        CreateReservationResponse response = CreateReservationResponse.newBuilder()
                .setReservationId(createdReservation.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getReservation(GetReservationRequest request, StreamObserver<GetReservationResponse> responseObserver) {
        Optional<Reservation> reservation = reservationService.getReservation(request.getReservationId());
        GetReservationResponse.Builder responseBuilder = GetReservationResponse.newBuilder();
        reservation.ifPresent(res -> {
            responseBuilder.setClientName(res.getClientName());
            responseBuilder.setStartDate(res.getStartDate());
            responseBuilder.setEndDate(res.getEndDate());
            responseBuilder.setRoomPreferences(res.getRoomPreferences());
        });
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateReservation(UpdateReservationRequest request, StreamObserver<UpdateReservationResponse> responseObserver) {
        Reservation reservationDetails = new Reservation();
        reservationDetails.setClientName(request.getClientName());
        reservationDetails.setStartDate(request.getStartDate());
        reservationDetails.setEndDate(request.getEndDate());
        reservationDetails.setRoomPreferences(request.getRoomPreferences());
        Reservation updatedReservation = reservationService.updateReservation(request.getReservationId(), reservationDetails);
        UpdateReservationResponse response = UpdateReservationResponse.newBuilder()
                .setReservationId(updatedReservation.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteReservation(DeleteReservationRequest request, StreamObserver<DeleteReservationResponse> responseObserver) {
        reservationService.deleteReservation(request.getReservationId());
        DeleteReservationResponse response = DeleteReservationResponse.newBuilder()
                .setStatus("SUCCESS")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}