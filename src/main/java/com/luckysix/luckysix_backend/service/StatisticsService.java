package com.luckysix.luckysix_backend.service;

import com.luckysix.luckysix_backend.domain.DhLotteryRaw;
import com.luckysix.luckysix_backend.dto.DrawRateDTO;
import com.luckysix.luckysix_backend.dto.StatisticsDTO;
import com.luckysix.luckysix_backend.repository.DhLotteryRawRepository;
import com.luckysix.luckysix_backend.util.UtilSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StatisticsService {
    private ArrayList<DrawRateDTO> noDrawRateDTOS;
    private DhLotteryRawRepository dhLotteryRawRepository;

    @Autowired
    public StatisticsService(DhLotteryRawRepository dhLotteryRawRepository) {
        this.dhLotteryRawRepository = dhLotteryRawRepository;
        this.computeAllNoDrawRate();
    }

    /**
     * 전체 번호를 조회하여 통계후 메모리 등록
     */
    private void computeAllNoDrawRate() {
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

        this.noDrawRateDTOS = new ArrayList<>();
        for (int[] ints : counter) {
            noDrawRateDTOS.add(DrawRateDTO.builder()
                .no(ints[0])
                .count(ints[1])
                .rate((float) ints[1] / (float) totalRound)
                .build());
        }
    }

    @Cacheable(value = "top6DrawRates")
    public StatisticsDTO top6DrawRates() {
        return StatisticsDTO.builder()
            .drawRates(
                this.noDrawRateDTOS.stream()
                    .sorted(Comparator.comparing(DrawRateDTO::getCount).reversed())
                    .limit(6)
                    .collect(Collectors.toCollection(ArrayList::new)))
            .build();
    }

    public StatisticsDTO drawRate(List<Integer> nos) {
        return StatisticsDTO.builder()
            .drawRates(
                this.noDrawRateDTOS.stream()
                    .filter(drawRateDTO -> Optional.ofNullable(nos).isPresent() && nos.contains(drawRateDTO.getNo()))
                    .sorted(Comparator.comparing(DrawRateDTO::getNo))
                    .collect(Collectors.toCollection(ArrayList::new)))
            .build();
    }
}
