package com.luckysix.luckysix_backend.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckysix.luckysix_backend.dto.DhLotteryApiDTO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DhLotteryApi {
    private final static String LOTTERY_API_URL = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";

    public static DhLotteryApiDTO getLottoNumber(int drwNo) {
        try {
            HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
            String result = client.send(
                HttpRequest.newBuilder(
                    new URI(LOTTERY_API_URL + drwNo)).GET().build(),
                HttpResponse.BodyHandlers.ofString()
            ).body();
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            return mapper.readValue(result, DhLotteryApiDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
