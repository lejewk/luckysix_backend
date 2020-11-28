package com.luckysix.luckysix_backend.service;

import com.luckysix.luckysix_backend.domain.DhLotteryRaw;
import com.luckysix.luckysix_backend.dto.LatestDrawDTO;
import com.luckysix.luckysix_backend.repository.DhLotteryRawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrawService {
    private DhLotteryRawRepository dhLotteryRawRepository;

    @Autowired
    public DrawService(DhLotteryRawRepository dhLotteryRawRepository) {
        this.dhLotteryRawRepository = dhLotteryRawRepository;
    }

    public LatestDrawDTO getLatestDraw() {
        DhLotteryRaw dhLotteryRaw = dhLotteryRawRepository.findTopByOrderByRoundDesc();
        return LatestDrawDTO.builder()
            .round(dhLotteryRaw.getRound())
            .no1(dhLotteryRaw.getNo1())
            .no2(dhLotteryRaw.getNo2())
            .no3(dhLotteryRaw.getNo3())
            .no4(dhLotteryRaw.getNo4())
            .no5(dhLotteryRaw.getNo5())
            .no6(dhLotteryRaw.getNo6())
            .bonus(dhLotteryRaw.getBonusNo())
            .build();
    }
}
