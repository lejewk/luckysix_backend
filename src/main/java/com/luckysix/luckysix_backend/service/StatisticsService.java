package com.luckysix.luckysix_backend.service;

import com.luckysix.luckysix_backend.domain.DhLotteryRaw;
import com.luckysix.luckysix_backend.repository.DhLotteryRawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Service
public class StatisticsService {
    private DhLotteryRawRepository dhLotteryRawRepository;

    @Autowired
    public StatisticsService(DhLotteryRawRepository dhLotteryRawRepository) {
        this.dhLotteryRawRepository = dhLotteryRawRepository;
    }

    public void getTop6NoRates() {
        Iterator<DhLotteryRaw> itr = dhLotteryRawRepository.findAll().iterator();

//        HashMap<Integer, Integer> counter = new HashMap<>();

        int[][] counter = new int[45][2];

        // 1 ~ 45 로 번호 초기화
        for(int i=0; i<counter.length; i++) {
            counter[i][0] = i+1;
        }

        // 당첨번호 카운팅
        while(itr.hasNext()) {
            DhLotteryRaw dhLotteryRaw = itr.next();
            counter[dhLotteryRaw.getNo1()][1]++;
            counter[dhLotteryRaw.getNo2()][1]++;
            counter[dhLotteryRaw.getNo3()][1]++;
            counter[dhLotteryRaw.getNo4()][1]++;
            counter[dhLotteryRaw.getNo5()][1]++;
            counter[dhLotteryRaw.getNo6()][1]++;
        }
    }
}
