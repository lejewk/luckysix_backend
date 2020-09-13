package com.luckysix.luckysix_backend.controller;

import com.luckysix.luckysix_backend.dto.LatestDrawDTO;
import com.luckysix.luckysix_backend.dto.StatisticsDTO;
import com.luckysix.luckysix_backend.service.DrawService;
import com.luckysix.luckysix_backend.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LotteryController {
    private DrawService drawService;
    private StatisticsService statisticsService;

    @Autowired
    public LotteryController(DrawService drawService, StatisticsService statisticsService) {
        this.drawService = drawService;
        this.statisticsService = statisticsService;
    }

    @GetMapping("/getLatestDraw")
    public LatestDrawDTO getLatestDraw() {
        return drawService.getLatestDraw();
    }

    @GetMapping("/getTop6NoDrawRate")
    public StatisticsDTO getTop6NoDrawRate() {
        return statisticsService.getSortedNoDrawRate(6);
    }
}
