package org.example.ticketrestapi.controller;

import org.example.ticketrestapi.model.Ticket;
import org.example.ticketrestapi.model.dto.request.TicketRequest;
import org.example.ticketrestapi.model.ticketStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/tickets")

public class TicketController {

    private List<Ticket> tickets = new ArrayList<>();
    AtomicLong ticketId = new AtomicLong(6L);

    // initial data by constructor
    public TicketController() {
        tickets.add(new Ticket(1L, "Dalin", new Date(), "Phnom Penh", "Kompong Thom", 15.2, true, ticketStatus.COMPLETED, 001));
        tickets.add(new Ticket(2L, "Rosie", new Date(), "Kandal", "Kompong speu", 22.6, false, ticketStatus.BOOKED, 002));
        tickets.add(new Ticket(3L, "rosé", new Date(), "Siem reap", "Kratie", 42.5, true, ticketStatus.CANCELLED, 003));
        tickets.add(new Ticket(4L, "Jisoo", new Date(), "Takeo", "Prey Veng", 18.2, true, ticketStatus.COMPLETED, 004));
        tickets.add(new Ticket(5L, "Jennie", new Date(), "Koh Kong", "Phnom Penh", 29.1, false, ticketStatus.BOOKED, 005));
    }

    //Get all tickets
    @GetMapping
    public List<Ticket> getALlTickets() {
        return tickets;
    }

    //Get ticket by ID
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId().equals(id)) {
                return ticket;
            }
        }
        return null;
    }

    //insert Data
    @PostMapping
    public Ticket addTicket(@RequestBody TicketRequest request) {
        Ticket ticket = new Ticket(
                ticketId.getAndIncrement(),
                request.getPassengerName(),
                request.getTravelDate(),
                request.getSourceStation(),
                request.getDestinationStation(),
                request.getPrice(),
                request.isPaymentStatus(),
                request.getTicketStatus(),
                request.getSeatNumber()
        );
        tickets.add(ticket);

        return ticket;
    }

    //update ticket
    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id,
                               @RequestBody TicketRequest request) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId().equals(id)) {
                ticket.setPassengerName(request.getPassengerName());
                ticket.setTravelDate(request.getTravelDate());
                ticket.setSourceStation(request.getSourceStation());
                ticket.setDestinationStation(request.getDestinationStation());
                ticket.setPrice(request.getPrice());
                ticket.setTicketStatus(request.getTicketStatus());
                ticket.setSeatNumber(request.getSeatNumber());

                return ticket;
            }
        }
        return null;
    }

    //Delete Ticket
    @DeleteMapping("/{id}")
    public String deleteTicketById(@PathVariable Long id) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId().equals(id)) {
                tickets.remove(ticket);
                return "Ticket has been deleted successfully!!";
            }
        }
        return null;
    }

    //SearchByName
    @GetMapping("/search")
    public Ticket searchTickets(@RequestParam("search") String passengerName) {
        for (Ticket ticket : tickets) {
            if (ticket.getPassengerName().equals(passengerName)) {
                return ticket;
            }
        }
         return null;
    }

    //filter Ticket by Ticket Status and Travel Date
    @GetMapping("/filter")
    public  List<Ticket> filterTickets(@RequestParam("filter") ticketStatus ticketStatus, Date date) {
        List<Ticket> filteredTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getTicketStatus().equals(ticketStatus) || ticket.getTravelDate().equals(date) ) {
                filteredTickets.add(ticket);
                return  filteredTickets;
            }
        }
        return null;
    }



}
