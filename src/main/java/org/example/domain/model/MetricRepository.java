package org.example.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MetricRepository extends JpaRepository<MetricDO, Long>, JpaSpecificationExecutor<MetricDO> {
}
