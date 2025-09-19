package org.example.port.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.application.MetricService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-test")
public class MetricController {
    private final MetricService metricDraftService;

    /**
     * normal example
     */
    @DeleteMapping("/metric/{id}")
    public void delete(@NotNull @PathVariable("id") Long id) {
        metricDraftService.deleteById(id);
    }

    /**
     * ObjectOptimisticLockingFailureException example
     */
    @DeleteMapping("/metric/{id}/v2")
    public void deleteV2(@NotNull @PathVariable("id") Long id) {
        metricDraftService.deleteByIdV2(id);
    }
}
