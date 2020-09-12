package com.luckysix.luckysix_backend.controller;

import com.luckysix.luckysix_backend.dto.LatestDrawDTO;
import com.luckysix.luckysix_backend.dto.StatisticsDTO;
import com.luckysix.luckysix_backend.service.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LotteryController {
    private DrawService drawService;

    @Autowired
    public LotteryController(DrawService drawService) {
        this.drawService = drawService;
    }

    @GetMapping("/getLatestDraw")
    public LatestDrawDTO getLatestDraw() {
        return drawService.getLatestDraw();
    }

    @GetMapping("/getTop6NoRates")
    public StatisticsDTO getTop6NoRates() {
        return StatisticsDTO.builder().build();
    }
}
