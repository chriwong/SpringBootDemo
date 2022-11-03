package com.chriwong.dataannotationsdemo.service;

import com.chriwong.dataannotationsdemo.client.NobelPrize;
import com.chriwong.dataannotationsdemo.client.NobelPrizesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NobelService {

    private static final String laureatesEndpoint = "/laureates";
    private static final String prizesEndpoint = "/nobelPrizes";
    private WebClient client;

    @Autowired
    public NobelService(WebClient client) {
        this.client = client;
    }

    public List<NobelPrize> getNobelPrizes(int year, String category, int limit) {
        // Build query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("nobelPrizeYear", String.valueOf(year));
        queryParams.put("nobelPrizeCategory", category);
        queryParams.put("limit", String.valueOf(limit));

        // Make synchronous call
        NobelPrizesResult result = this.client
                .get()
                .uri(prizesEndpoint, queryParams)
                .retrieve()
                .bodyToMono(NobelPrizesResult.class)
                .block();

        return (result != null)
                ? result.getNobelPrizes()
                : null;
    }
}
