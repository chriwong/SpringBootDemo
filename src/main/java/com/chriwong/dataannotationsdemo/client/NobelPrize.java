package com.chriwong.dataannotationsdemo.client;

import lombok.Data;
import java.util.List;

@Data
public class NobelPrize {

    private Integer awardYear;
    private Translation category;
    private Translation categoryFullName;
    private String dateAwarded;
    private Integer prizeAmount;
    private Integer prizeAmountAdjusted;
    private Translation topMotivation;
    private List<LaureateBasic> laureates;

}

