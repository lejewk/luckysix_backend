package com.luckysix.luckysix_backend.service;

import com.luckysix.luckysix_backend.api.DhLotteryApi;
import com.luckysix.luckysix_backend.domain.DhLotteryRaw;
import com.luckysix.luckysix_backend.dto.DhLotteryApiDTO;
import com.luckysix.luckysix_backend.repository.DhLotteryRawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DhLotteryApiService {
    private DhLotteryRawRepository dhLotteryRawRepository;

    @Autowired
    public DhLotteryApiService(DhLotteryRawRepository dhLotteryRawRepository) {
        this.dhLotteryRawRepository = dhLotteryRawRepository;
    }

    public int collectAllDraws() {
        int round = 1;
        int counter = 0;
        do {
            DhLotteryRaw dhLotteryRaw = this.dhLotteryRawRepository.findTopByOrderByRoundDesc();

            if (dhLotteryRaw != null) {
                round = dhLotteryRaw.getRound() + 1;
            }

            DhLotteryApiDTO dhLotteryApiDTO = DhLotteryApi.getLottoNumber(round);
            if (dhLotteryApiDTO == null || !dhLotteryApiDTO.getReturnValue().equals("success")) {
                break;
            }

            this.dhLotteryRawRepository.save(
                DhLotteryRaw.builder()
                    .drawDate(LocalDate.parse(dhLotteryApiDTO.getDrwNoDate()))
                    .round(dhLotteryApiDTO.getDrwNo())
                    .no1(dhLotteryApiDTO.getDrwtNo1())
                    .no2(dhLotteryApiDTO.getDrwtNo2())
                    .no3(dhLotteryApiDTO.getDrwtNo3())
                    .no4(dhLotteryApiDTO.getDrwtNo4())
                    .no5(dhLotteryApiDTO.getDrwtNo5())
                    .no6(dhLotteryApiDTO.getDrwtNo6())
                    .bonusNo(dhLotteryApiDTO.getBnusNo())
                    .firstWinnerAmount(dhLotteryApiDTO.getFirstWinamnt())
                    .firstWinnerCount(dhLotteryApiDTO.getFirstPrzwnerCo())
                    .totalSellAmount(dhLotteryApiDTO.getTotSellamnt())
                    .build()
            );
            counter++;
        } while(true);

        return counter;
    }
}
