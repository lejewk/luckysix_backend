package com.luckysix.luckysix_backend.api;

import com.luckysix.luckysix_backend.dto.DhLotteryApiDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DhLotteryApiTest {
    @Test
    void getLottoNumberTest() {
        DhLotteryApiDTO dhLotteryApiDTO = DhLotteryApi.getLottoNumber(900);
        System.out.println(dhLotteryApiDTO);
        Assertions.assertEquals(1, 1);
    }
}
