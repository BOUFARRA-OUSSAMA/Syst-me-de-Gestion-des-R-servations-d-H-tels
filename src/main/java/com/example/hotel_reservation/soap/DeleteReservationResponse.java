package com.example.hotel_reservation.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DeleteReservationResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteReservationResponse {

    @XmlElement(required = true)
    private String status;

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}