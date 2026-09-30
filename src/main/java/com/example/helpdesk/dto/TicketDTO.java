package com.example.helpdesk.dto;

import com.example.helpdesk.enums.TicketPriority;
import com.example.helpdesk.enums.TicketStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TicketDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private TicketStatus status;

    @NotNull
    private TicketPriority priority;

    @NotNull
    private Long employeeId;

    @NotNull
    private Long supportAgentId;

    public TicketDTO() {
    }

    public TicketDTO(String title, String description,
                     TicketStatus status, TicketPriority priority,
                     Long employeeId, Long supportAgentId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.employeeId = employeeId;
        this.supportAgentId = supportAgentId;
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