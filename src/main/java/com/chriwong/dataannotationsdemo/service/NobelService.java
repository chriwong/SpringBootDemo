package com.chriwong.dataannotationsdemo.service;

import com.chriwong.dataannotationsdemo.client.NobelPrize;
import com.chriwong.dataannotationsdemo.client.NobelPrizesResult;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NobelService {

    private static final String uri = "https://api.nobelprize.org/2.1";

    private final WebClient client;

    public NobelService() {
        client = WebClient.create(uri);
    }

    public List<NobelPrize> getNobelLaureates(Integer year, String category) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("nobelPrizeYear", year.toString());
        queryParams.put("nobelPrizeCategory", category);

        NobelPrizesResult result = this.client
                .get()
                .uri("/nobelPrizes", queryParams)
                .retrieve()
                .bodyToMono(NobelPrizesResult.class)
                .block();

        return (result != null)
                ? result.getNobelPrizes()
                : null;
    }
}
