package com.example.helpdesk.dto;

import com.example.helpdesk.enums.TicketPriority;
import com.example.helpdesk.enums.TicketStatus;

public class TicketResponseDTO {

    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;
    private Long employeeId;
    private Long supportAgentId;

    public TicketResponseDTO() {
    }

    public TicketResponseDTO(Long id, String title, String description,
                             TicketStatus status, TicketPriority priority,
                             Long employeeId, Long supportAgentId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.employeeId = employeeId;
        this.supportAgentId = supportAgentId;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getSupportAgentId() {
        return supportAgentId;
    }

    public void setSupportAgentId(Long supportAgentId) {
        this.supportAgentId = supportAgentId;
    }
}