package com.luckysix.luckysix_backend.controller;

import com.luckysix.luckysix_backend.dto.LatestDrawDTO;
import com.luckysix.luckysix_backend.dto.StatisticsDTO;
import com.luckysix.luckysix_backend.service.DrawService;
import com.luckysix.luckysix_backend.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/latestDraw")
    public LatestDrawDTO latestDraw() {
        return drawService.latestDraw();
    }

    @GetMapping("/top6DrawRate")
    public StatisticsDTO top6DrawRates() {
        return statisticsService.top6DrawRates();
    }

    @GetMapping("/drawRate")
    public StatisticsDTO drawRate(@RequestParam("nos") List<Integer> nos) {
        return statisticsService.drawRate(nos);
    }

    @GetMapping("/rank")
    public StatisticsDTO rank() {
        return statisticsService.allDrawRate();
    }
}
