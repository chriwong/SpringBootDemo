package com.chriwong.dataannotationsdemo.service;

import org.springframework.stereotype.Service;

@Service
public class SpellCheckService {

    public String basicCorrections(String s) {
        return s.replaceAll(" anf " , " and ")
                .replaceAll(" thd ", " the ")
                .replaceAll(" hte ", " the ")
                .replaceAll(" fo ", " of" )
                .replaceAll("grammer", "grammar");
    }

}
