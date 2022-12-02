package com.chriwong.dataannotationsdemo.controller;

import com.chriwong.dataannotationsdemo.client.NobelPrize;
import com.chriwong.dataannotationsdemo.service.NobelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@Slf4j
public class NobelController {

    private final NobelService nobelService;

    public NobelController(NobelService nobelService) {
        this.nobelService = nobelService;
    }

    @GetMapping("/nobel-prizes")
    public List<NobelPrize> getNobelPrizes(
            @RequestParam(required = false, defaultValue = "1997") int year,
            @RequestParam(required = false, defaultValue = "phy") String category,
            @RequestParam(required = false, defaultValue = "10") int limit) {
        log.debug("- Request\n--- Endpoint: /nobel-prizes\n\n--- Query parameters:\n--- year: {}\n--- category: {}\n--- limit: {}", year, category, limit);
        return nobelService.getNobelPrizes(year, category, limit);
    }
}
