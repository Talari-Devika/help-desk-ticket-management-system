package com.example.helpdesk.repository;

import com.example.helpdesk.entity.SupportAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportAgentRepository extends JpaRepository<SupportAgent, Long> {

}