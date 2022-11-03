package com.chriwong.dataannotationsdemo.config;

import com.chriwong.dataannotationsdemo.client.LaureateBasic;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {
    private static final String uri = "https://api.nobelprize.org/2.1";

    @Bean
    public WebClient nobelPrizeWebClient() {
        return WebClient.create(uri);
    }

//    @Bean
//    public Gson gsonWithAdapter() {
//        GsonBuilder builder = new GsonBuilder();
//        builder.registerTypeAdapter(LaureateBasic.PortionEnum.Adapter.class, new LaureateBasic.PortionEnum.Adapter());
//        return builder.create();
//    }
}
