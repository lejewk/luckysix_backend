package com.luckysix.luckysix_backend.service;

import com.luckysix.luckysix_backend.domain.DhLotteryRaw;
import com.luckysix.luckysix_backend.repository.DhLotteryRawRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DhLotteryApiServiceTest {
    @Mock
    DhLotteryRawRepository dhLotteryRawRepository;

    @InjectMocks
    DhLotteryApiService dhLotteryApiService;

    @BeforeEach
    void init() {
        Mockito
            .when(dhLotteryRawRepository.save(Mockito.any(DhLotteryRaw.class)))
            .thenReturn(null);
        dhLotteryApiService = new DhLotteryApiService(this.dhLotteryRawRepository);
    }
}
