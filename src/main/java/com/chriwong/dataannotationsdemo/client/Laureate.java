package com.chriwong.dataannotationsdemo.client;

import lombok.Data;
import java.util.List;

@Data
public class Laureate {

    private Integer id;
    private Person laureateIfPerson;
//    private Organization laureateIfOrg;
    private Object wikipedia;
    private Object wikidata;
    private List<String> sameAs;
    private List<ItemLinks> links;
//    private List<NobelPrizePerLaureate> nobelPrizes;

}

