package com.chriwong.dataannotationsdemo.client;

import lombok.Data;

@Data
public class NobelPrizesMeta {

    private int offset;
    private int limit;
    private int nobelPrizeYear;
    private int yearTo;
    private String nobelPrizeCategory;
    private int count;

}
