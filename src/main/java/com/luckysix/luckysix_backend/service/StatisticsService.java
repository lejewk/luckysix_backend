package com.luckysix.luckysix_backend.service;

import com.luckysix.luckysix_backend.domain.DhLotteryRaw;
import com.luckysix.luckysix_backend.dto.DrawRateDTO;
import com.luckysix.luckysix_backend.dto.StatisticsDTO;
import com.luckysix.luckysix_backend.repository.DhLotteryRawRepository;
import com.luckysix.luckysix_backend.util.UtilSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class StatisticsService {
    private DhLotteryRawRepository dhLotteryRawRepository;

    @Autowired
    public StatisticsService(DhLotteryRawRepository dhLotteryRawRepository) {
        this.dhLotteryRawRepository = dhLotteryRawRepository;
    }

    @Cacheable(value = "getSortedNoDrawRate")
    public StatisticsDTO getSortedNoDrawRate(int topLimit) {
        Iterator<DhLotteryRaw> itr = dhLotteryRawRepository.findAll().iterator();

        int[][] counter = new int[45][3];

        // 1 ~ 45 로 번호 초기화
        for(int i=0; i<counter.length; i++) {
            counter[i][0] = i+1;
        }

        // 전체 추첨 수
        int totalRound = 0;

        // 당첨번호 카운팅
        while(itr.hasNext()) {
            DhLotteryRaw dhLotteryRaw = itr.next();
            counter[dhLotteryRaw.getNo1()-1][1]++;
            counter[dhLotteryRaw.getNo2()-1][1]++;
            counter[dhLotteryRaw.getNo3()-1][1]++;
            counter[dhLotteryRaw.getNo4()-1][1]++;
            counter[dhLotteryRaw.getNo5()-1][1]++;
            counter[dhLotteryRaw.getNo6()-1][1]++;
            totalRound++;
        }

        UtilSorter.sortByDrawCount(counter);

        ArrayList<DrawRateDTO> noDrawRateDTOS = new ArrayList<>();
        for (int i=0; i<topLimit; i++) {
            noDrawRateDTOS.add(DrawRateDTO.builder()
                .no(counter[i][0])
                .count(counter[i][1])
                .rate((float) counter[i][1] / (float) totalRound)
                .build());
        }

        return StatisticsDTO.builder().noDrawRates(noDrawRateDTOS).build();
    }
}
