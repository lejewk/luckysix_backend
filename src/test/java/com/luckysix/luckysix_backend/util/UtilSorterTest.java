package com.luckysix.luckysix_backend.util;

import org.junit.Assert;
import org.junit.Test;

public class UtilSorterTest {
    @Test
    public void sortTest() {
        int[][] source = {
            {1,4}, {2,8}, {3,5}
        };
        UtilSorter.sortByDrawCount(source);

        Assert.assertEquals(2, source[0][0]);
        Assert.assertEquals(3, source[1][0]);
        Assert.assertEquals(1, source[2][0]);
    }
}
