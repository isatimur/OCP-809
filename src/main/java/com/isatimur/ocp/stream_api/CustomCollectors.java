package com.isatimur.ocp.stream_api;

import java.util.ArrayList;
import java.util.stream.Collector;

/**
 * Created by Isa Timur on 7/12/16.
 */
public class CustomCollectors {
    public static void main(String[] args) {
        Collector collector = Collector.of(
            () -> new ArrayList(),
            (list, o) -> list.add(o),
            (list, list2) -> {
                list.addAll(list2);
                return list;
            },
            Collector.Characteristics.IDENTITY_FINISH
        );

    }
}
