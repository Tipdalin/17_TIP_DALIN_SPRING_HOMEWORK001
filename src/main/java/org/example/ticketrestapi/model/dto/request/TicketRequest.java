package org.example.ticketrestapi.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ticketrestapi.model.ticketStatus;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequest {
    private String passengerName;
    private Date travelDate;
    private String sourceStation;
    private String destinationStation;
    private double price;
    private boolean paymentStatus;
    private ticketStatus ticketStatus;
    private int seatNumber;

}
