package com.saaws88.stringTypeSpecifier;

import com.saaws88.stringTypeSpecifier.FileManager.Implementations.DecimalParser;
import com.saaws88.stringTypeSpecifier.Statistics.implementations.IntsStatisticsCalculator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        DecimalParser dp = new DecimalParser();
        assertTrue(dp.validate("1000"));
    }

    @Test
    public void maxShouldBe91() {
        Integer[] arr = {56, 23, 78, 12, 45, 89, 34, 67, 5, 91};
        List<Integer> list = Arrays.asList(arr);
        assert Collections.max(list) == 91;
    }




}
