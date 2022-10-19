package com.chriwong.dataannotationsdemo.client;

import lombok.Data;

@Data
public class Location {

    private Translation city = null;
    private Translation country = null;
//    private TranslationWithSameas cityNow = null;
//    private TranslationWithSameas countryNow = null;
    private Translation continent = null;
    private Translation locationString = null;

}

