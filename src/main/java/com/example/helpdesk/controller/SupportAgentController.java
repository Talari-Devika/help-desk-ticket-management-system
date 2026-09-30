package com.example.helpdesk.controller;

import com.example.helpdesk.entity.SupportAgent;
import com.example.helpdesk.service.SupportAgentService;
import org.springframework.web.bind.annotation.*;
import com.example.helpdesk.dto.SupportAgentDTO;
import com.example.helpdesk.dto.SupportAgentResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/support-agents")
public class SupportAgentController {

    private final SupportAgentService supportAgentService;

    public SupportAgentController(SupportAgentService supportAgentService) {
        this.supportAgentService = supportAgentService;
    }

   @PostMapping
public SupportAgentResponseDTO createSupportAgent(
        @Valid @RequestBody SupportAgentDTO dto) {

    SupportAgent supportAgent =
            supportAgentService.createSupportAgentFromDTO(dto);

    return supportAgentService.convertToResponseDTO(supportAgent);
}
    @GetMapping
public List<SupportAgentResponseDTO> getAllSupportAgents() {
    return supportAgentService.getAllSupportAgents();
}
    @GetMapping("/{id}")
public SupportAgentResponseDTO getSupportAgentById(@PathVariable Long id) {
    return supportAgentService.getSupportAgentById(id);
}

    @PutMapping("/{id}")
    public SupportAgent updateSupportAgent(
            @PathVariable Long id,
            @RequestBody SupportAgent supportAgent) {

        return supportAgentService.updateSupportAgent(id, supportAgent);
    }

    @DeleteMapping("/{id}")
    public void deleteSupportAgent(@PathVariable Long id) {
        supportAgentService.deleteSupportAgent(id);
    }
}