package com.chriwong.dataannotationsdemo.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.Data;

import java.io.IOException;
import java.util.List;

@Data
public class LaureateBasic {

    private Integer id;
    private Translation name;
    private PortionEnum portion = PortionEnum.WHOLE;
    private String sortOrde;
    private Translation motivation;
    private List<ItemLinks> links;

    public enum PortionEnum {
        @JsonProperty("1")
        WHOLE,

        @JsonProperty("1/2")
        HALF,

        @JsonProperty("1/3")
        THIRD,

        @JsonProperty("1/4")
        QUARTER;
    }

}