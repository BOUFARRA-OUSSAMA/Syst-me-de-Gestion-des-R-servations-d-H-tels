package com.example.hotel_reservation.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DeleteReservationRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteReservationRequest {

    @XmlElement(required = true)
    private Long reservationId;

    // Getters and Setters
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}