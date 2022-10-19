package com.chriwong.dataannotationsdemo.client;

import lombok.Data;

@Data
public class ItemLinks {

    private String rel;
    private String href;
    private String action;
    private String types;

}
