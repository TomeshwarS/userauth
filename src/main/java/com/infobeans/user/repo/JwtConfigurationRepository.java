package com.infobeans.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infobeans.user.model.JwtConfiguration;

public interface JwtConfigurationRepository extends JpaRepository<JwtConfiguration, Long> {
}