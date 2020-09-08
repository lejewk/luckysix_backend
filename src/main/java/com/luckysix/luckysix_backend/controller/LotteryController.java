package com.luckysix.luckysix_backend.controller;

import com.luckysix.luckysix_backend.dto.LatestDrawsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LotteryController {
    @GetMapping("/getLatestDraw")
    public LatestDrawsDTO getLatestDraw() {
        return LatestDrawsDTO.builder()
            .round(927)
            .no1(4)
            .no2(11)
            .no3(23)
            .no4(24)
            .no5(34)
            .no6(41)
            .build();
    }
}
