package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by richardsaney on 8/28/16.
 */
@RunWith(Parameterized.class)
public class QuickSortTesting {

    Integer[] initial;
    Integer[] sorted;

    public QuickSortTesting(Integer[] unsorted, Integer[] sorted) {
        this.initial = unsorted;
        this.sorted = sorted;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void quickSort() throws Exception {
        int[] unsorted = Arrays.stream(initial).mapToInt(i -> i).toArray();
        System.out.print("Before: ");
        Arrays.stream(unsorted).forEachOrdered(i -> System.out.print(i+" "));
        System.out.println();
        int[] sortedArr = Arrays.stream(sorted).mapToInt(i -> i).toArray();

        SortingMethods.quickSort(unsorted);
        assertArrayEquals(unsorted, sortedArr);
        System.out.print("After: ");
        Arrays.stream(unsorted).forEachOrdered(i -> System.out.print(i+" "));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> params()
    {
        Object[][] data = new Object[][]{
            new Object[]{
                new Integer[]{5,4,3,2,1},
                new Integer[]{1,2,3,4,5}
            },
            new Object[]{
                new Integer[]{8,5,23,-1,0},
                new Integer[]{-1,0,5,8,23}
            },
            new Object[]{
                new Integer[]{},
                new Integer[]{}
            },
            new Object[]{
                new Integer[]{-23, -400, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, Integer.MIN_VALUE},
                new Integer[]{Integer.MIN_VALUE, Integer.MIN_VALUE, -400, -23, 0, Integer.MAX_VALUE}
            }
        };
        List<Object[]> result = Arrays.asList(data);
        return result;
    }
}