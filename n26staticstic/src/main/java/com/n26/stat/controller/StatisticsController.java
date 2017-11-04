package com.n26.stat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n26.stat.model.StatisticsSummary;
import com.n26.stat.service.StatisticsService;

/**
 * REST API for consuming statistics requests
 *
 * @author Manideepa
 * @since 1.0.0
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public StatisticsSummary getStatistics(){
        return statisticsService.getStatistics();
    }
}
