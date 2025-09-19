package org.example.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MetricV2Repository extends JpaRepository<MetricV2DO, Long>,
        JpaSpecificationExecutor<MetricV2DO> {
}
