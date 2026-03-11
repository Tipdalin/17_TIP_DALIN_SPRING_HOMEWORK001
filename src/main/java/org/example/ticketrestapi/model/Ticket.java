package org.example.ticketrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket {
    private Long ticketId;
    private String passengerName;
    private  Date travelDate;
    private String sourceStation;
    private String destinationStation;
    private double price;
    private boolean paymentStatus;
    private ticketStatus ticketStatus;
    private int seatNumber;

}
