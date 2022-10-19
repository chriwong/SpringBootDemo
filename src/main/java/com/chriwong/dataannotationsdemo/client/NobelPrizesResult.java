package com.chriwong.dataannotationsdemo.client;

import lombok.Data;

import java.util.List;

@Data
public class NobelPrizesResult {

    private List<NobelPrize> nobelPrizes;
    private NobelPrizesMeta meta;
    private List<Links> links;

}
