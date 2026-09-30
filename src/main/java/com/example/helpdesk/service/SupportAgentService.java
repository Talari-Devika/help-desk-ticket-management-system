package com.example.helpdesk.service;

import com.example.helpdesk.entity.SupportAgent;
import com.example.helpdesk.exception.ResourceNotFoundException;
import com.example.helpdesk.repository.SupportAgentRepository;
import org.springframework.stereotype.Service;
import com.example.helpdesk.dto.SupportAgentDTO;
import com.example.helpdesk.dto.SupportAgentResponseDTO;
import java.util.List;
@Service
public class SupportAgentService {

    private final SupportAgentRepository supportAgentRepository;

    public SupportAgentService(SupportAgentRepository supportAgentRepository) {
        this.supportAgentRepository = supportAgentRepository;
    }

    public SupportAgent createSupportAgent(SupportAgent supportAgent) {
        return supportAgentRepository.save(supportAgent);
    }

    public List<SupportAgentResponseDTO> getAllSupportAgents() {
    return supportAgentRepository.findAll()
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
}

    public SupportAgentResponseDTO getSupportAgentById(Long id) {
    SupportAgent supportAgent = supportAgentRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Support agent not found with id: " + id
                    ));

    return convertToResponseDTO(supportAgent);
}

    public SupportAgent updateSupportAgent(Long id, SupportAgent supportAgent) {
    SupportAgent existingAgent = supportAgentRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Support agent not found with id: " + id
                    ));

    existingAgent.setName(supportAgent.getName());
    existingAgent.setEmail(supportAgent.getEmail());
    existingAgent.setSpecialization(supportAgent.getSpecialization());

    return supportAgentRepository.save(existingAgent);
}

    public void deleteSupportAgent(Long id) {
    SupportAgent supportAgent = supportAgentRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Support agent not found with id: " + id
                    ));

    supportAgentRepository.delete(supportAgent);
}
    public SupportAgent createSupportAgentFromDTO(SupportAgentDTO dto) {

    SupportAgent supportAgent = new SupportAgent();

    supportAgent.setName(dto.getName());
    supportAgent.setEmail(dto.getEmail());
    supportAgent.setSpecialization(dto.getSpecialization());

    return supportAgentRepository.save(supportAgent);
}
public SupportAgentResponseDTO convertToResponseDTO(SupportAgent supportAgent) {

    return new SupportAgentResponseDTO(
            supportAgent.getId(),
            supportAgent.getName(),
            supportAgent.getEmail(),
            supportAgent.getSpecialization()
    );
}
}