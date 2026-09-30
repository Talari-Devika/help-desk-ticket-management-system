package com.example.helpdesk.controller;

import com.example.helpdesk.entity.Ticket;
import com.example.helpdesk.enums.TicketStatus;
import com.example.helpdesk.service.TicketService;
import org.springframework.web.bind.annotation.*;
import com.example.helpdesk.dto.TicketDTO;
import com.example.helpdesk.dto.TicketResponseDTO;
import jakarta.validation.Valid;
import com.example.helpdesk.enums.TicketPriority;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

   @PostMapping
public TicketResponseDTO createTicket(
        @Valid @RequestBody TicketDTO dto) {

    Ticket ticket = ticketService.createTicketFromDTO(dto);

    return ticketService.convertToResponseDTO(ticket);
}

   @GetMapping
public List<TicketResponseDTO> getAllTickets() {
    return ticketService.getAllTickets();
}
@GetMapping("/status/{status}")
public List<TicketResponseDTO> getTicketsByStatus(
        @PathVariable TicketStatus status) {

    return ticketService.getTicketsByStatus(status);
}
@GetMapping("/priority/{priority}")
public List<TicketResponseDTO> getTicketsByPriority(
        @PathVariable TicketPriority priority) {

    return ticketService.getTicketsByPriority(priority);
}
    @GetMapping("/{id}")
public TicketResponseDTO getTicketById(@PathVariable Long id) {
    return ticketService.getTicketById(id);
}

    @PutMapping("/{id}")
    public Ticket updateTicket(
            @PathVariable Long id,
            @RequestBody Ticket ticket) {

        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}