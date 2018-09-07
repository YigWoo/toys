package com.yigwoo.java.lambda;

import java.util.ArrayList;
import java.util.Optional;

public class StreamLazyTest {

    public String findSymbol(ArrayList<String> al) {
        Optional<String> t = al.stream().
                filter(symbol -> symbol.charAt(0) != 'A').
                filter(symbol -> symbol.charAt(1) != 'A').
                filter(symbol -> symbol.charAt(2) != 'A').
                filter(symbol -> symbol.charAt(3) != 'A').
                findFirst();
        return t.orElse(null);
    }
}
