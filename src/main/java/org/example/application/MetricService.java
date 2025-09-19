package org.example.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.model.MetricDO;
import org.example.domain.model.MetricRepository;
import org.example.domain.model.MetricV2DO;
import org.example.domain.model.MetricV2Repository;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MetricService implements ApplicationRunner {
    private final MetricRepository metricRepository;
    private final MetricV2Repository metricV2Repository;

    public void deleteById(@NotNull Long id) {
        metricRepository.deleteById(id);
    }

    public void deleteByIdV2(@NotNull Long id) {
        metricV2Repository.deleteById(id);
    }

    @Override
    public void run(ApplicationArguments args) {
        init();
    }

    public void init() {

        MetricDO metricDO1 = MetricDO.create(1001L);
        MetricDO metricDO2 = MetricDO.create(1002L);
        MetricDO metricDO3 = MetricDO.create(1003L);
        List<MetricDO> metricDOList = List.of(metricDO1, metricDO2, metricDO3);

        MetricV2DO metricV2DO1 = MetricV2DO.create(1001L);
        MetricV2DO metricV2DO2 = MetricV2DO.create(1002L);
        MetricV2DO metricV2DO3 = MetricV2DO.create(1003L);
        List<MetricV2DO> metricV2DOList = List.of(metricV2DO1, metricV2DO2, metricV2DO3);


        metricRepository.saveAll(metricDOList);
        metricV2Repository.saveAll(metricV2DOList);

        log.info("Initialization completed");
    }
}
