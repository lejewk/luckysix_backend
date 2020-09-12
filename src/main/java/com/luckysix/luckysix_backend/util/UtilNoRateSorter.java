package com.luckysix.luckysix_backend.util;

import java.util.Arrays;

public class UtilNoRateSorter {
    public static void sort(int[][] source) {
        Arrays.sort(source, (o1, o2) -> Integer.compare(o2[1], o1[1]));
    }
}
