/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import inclassquicksort.QSArrayList;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maximiliano Herrera
 */
public class QuickSortTests {

    private QSArrayList<Integer> _list;

    public QuickSortTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        _list = new QSArrayList<>();
        //[0, 58, 86, 15, 6, 87, 99, 35, 4]
        _list.add(new Integer(0));
        _list.add(new Integer(58));
        _list.add(new Integer(86));
        _list.add(new Integer(15));
        _list.add(new Integer(6));
        _list.add(new Integer(87));
        _list.add(new Integer(99));
        _list.add(new Integer(35));
        _list.add(new Integer(4));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void Test_QuickSort_First_Element_Pivot() {

        _list.quickSortFirstElementPivot(0, _list.size() - 1);

        AssertSortedList();
    }

    @Test
    public void Test_QuickSort_Last_Element_Pivot() {
        _list.quickSortLastElementPivot(0, _list.size() - 1);

        AssertSortedList();
    }

    @Test
    public void Test_QuickSort_Middle_Element_Pivot() {
        _list.quickSortMiddleElementPivot(0, _list.size() - 1);

        AssertSortedList();
    }

    @Test
    public void Test_QuickSort_Random_Element_Pivot() {
        _list.quickSortRandomElementPivot(0, _list.size() - 1);

        AssertSortedList();
    }

    @Test
    public void Test_QuickSort_MedianOf3_Element_Pivot() {
        _list.quickSortMedianOf3Pivot(0, _list.size() - 1);

        AssertSortedList();
    }

    private void AssertSortedList() {
        assertThat(_list.get(0), is(0));
        assertThat(_list.get(1), is(4));
        assertThat(_list.get(2), is(6));
        assertThat(_list.get(3), is(15));
        assertThat(_list.get(4), is(35));
        assertThat(_list.get(5), is(58));
        assertThat(_list.get(6), is(86));
        assertThat(_list.get(7), is(87));
        assertThat(_list.get(8), is(99));
    }
}
