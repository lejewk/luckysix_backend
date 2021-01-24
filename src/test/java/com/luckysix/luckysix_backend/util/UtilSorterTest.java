package com.luckysix.luckysix_backend.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilSorterTest {
    @Test
    void sortTest() {
        int[][] source = {
            {1,4}, {2,8}, {3,5}
        };
        SorterUtil.sortByDrawCount(source);

        Assertions.assertEquals(2, source[0][0]);
        Assertions.assertEquals(3, source[1][0]);
        Assertions.assertEquals(1, source[2][0]);
    }
}
