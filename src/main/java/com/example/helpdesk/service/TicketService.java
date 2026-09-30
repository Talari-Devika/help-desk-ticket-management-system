package com.example.helpdesk.service;

import com.example.helpdesk.entity.Ticket;
import com.example.helpdesk.enums.TicketStatus;
import com.example.helpdesk.repository.TicketRepository;
import org.springframework.stereotype.Service;
import com.example.helpdesk.dto.TicketDTO;
import com.example.helpdesk.dto.TicketResponseDTO;
import com.example.helpdesk.entity.Employee;
import com.example.helpdesk.entity.SupportAgent;
import com.example.helpdesk.repository.EmployeeRepository;
import com.example.helpdesk.repository.SupportAgentRepository;
import java.util.List;
import com.example.helpdesk.exception.ResourceNotFoundException;
import com.example.helpdesk.enums.TicketPriority;
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EmployeeRepository employeeRepository;
private final SupportAgentRepository supportAgentRepository;

  public TicketService(
        TicketRepository ticketRepository,
        EmployeeRepository employeeRepository,
        SupportAgentRepository supportAgentRepository) {

    this.ticketRepository = ticketRepository;
    this.employeeRepository = employeeRepository;
    this.supportAgentRepository = supportAgentRepository;
}  

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<TicketResponseDTO> getAllTickets() {
    return ticketRepository.findAll()
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
}
public List<TicketResponseDTO> getTicketsByStatus(TicketStatus status) {
    return ticketRepository.findByStatus(status)
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
}
public List<TicketResponseDTO> getTicketsByPriority(TicketPriority priority) {
    return ticketRepository.findByPriority(priority)
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
}

    public TicketResponseDTO getTicketById(Long id) {
    Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Ticket not found with id: " + id
                    ));

    return convertToResponseDTO(ticket);
}
    public Ticket updateTicket(Long id, Ticket ticket) {
    Ticket existingTicket = ticketRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Ticket not found with id: " + id
                    ));

    existingTicket.setTitle(ticket.getTitle());
    existingTicket.setDescription(ticket.getDescription());
    existingTicket.setStatus(ticket.getStatus());
    existingTicket.setPriority(ticket.getPriority());
    existingTicket.setEmployee(ticket.getEmployee());
    existingTicket.setSupportAgent(ticket.getSupportAgent());

    return ticketRepository.save(existingTicket);
}

    public void deleteTicket(Long id) {
    Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Ticket not found with id: " + id
                    ));

    ticketRepository.delete(ticket);
}
    public Ticket createTicketFromDTO(TicketDTO dto) {

    Employee employee = employeeRepository
        .findById(dto.getEmployeeId())
        .orElseThrow(() ->
                new ResourceNotFoundException(
                        "Employee not found with id: " + dto.getEmployeeId()
                ));

SupportAgent supportAgent = supportAgentRepository
        .findById(dto.getSupportAgentId())
        .orElseThrow(() ->
                new ResourceNotFoundException(
                        "Support agent not found with id: " + dto.getSupportAgentId()
                ));

    Ticket ticket = new Ticket();

    ticket.setTitle(dto.getTitle());
    ticket.setDescription(dto.getDescription());
    ticket.setStatus(dto.getStatus());
    ticket.setPriority(dto.getPriority());
    ticket.setEmployee(employee);
    ticket.setSupportAgent(supportAgent);

    return ticketRepository.save(ticket);
}
public TicketResponseDTO convertToResponseDTO(Ticket ticket) {

    return new TicketResponseDTO(
            ticket.getId(),
            ticket.getTitle(),
            ticket.getDescription(),
            ticket.getStatus(),
            ticket.getPriority(),
            ticket.getEmployee().getId(),
            ticket.getSupportAgent().getId()
    );
}
}