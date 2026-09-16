package org.example.ticketrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @GetMapping
    public String getTickets() {
        return "Ticket API is working";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Ticket API";
    }

    @GetMapping("/v2")
    public String version2() {
        return "Ticket API Version 2";
    }
}
