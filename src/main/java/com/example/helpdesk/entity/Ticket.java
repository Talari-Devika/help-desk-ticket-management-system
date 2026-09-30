package com.example.helpdesk.entity;

import com.example.helpdesk.enums.TicketPriority;
import com.example.helpdesk.enums.TicketStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
private TicketStatus status;

@Enumerated(EnumType.STRING)
private TicketPriority priority;
    @ManyToOne
@JoinColumn(name = "employee_id")
private Employee employee;
@ManyToOne
@JoinColumn(name = "support_agent_id")
private SupportAgent supportAgent;
public Ticket() {
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public TicketStatus getStatus() {
    return status;
}

public void setStatus(TicketStatus status) {
    this.status = status;
}

public TicketPriority getPriority() {
    return priority;
}

public void setPriority(TicketPriority priority) {
    this.priority = priority;
}

public Employee getEmployee() {
    return employee;
}

public void setEmployee(Employee employee) {
    this.employee = employee;
}

public SupportAgent getSupportAgent() {
    return supportAgent;
}

public void setSupportAgent(SupportAgent supportAgent) {
    this.supportAgent = supportAgent;
}

public Ticket(String title, String description, TicketStatus status, TicketPriority priority,
              Employee employee, SupportAgent supportAgent) {
    this.title = title;
    this.description = description;
    this.status = status;
    this.priority = priority;
    this.employee = employee;
    this.supportAgent = supportAgent;
}
}