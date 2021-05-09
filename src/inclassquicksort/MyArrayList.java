/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclassquicksort;

import java.util.ArrayList;

/**
 *
 * @author EThornbury
 */
public class MyArrayList<E> extends ArrayList<E> {

    private boolean _debug;

    public MyArrayList(boolean debug) {
        _debug = debug;
    }

    public void quickSort(int start, int end) {
        int pivotIndex;

        print("quickSort(start: " + start + ", end: " + end + ")");
        print("start < end = " + (start < end));

        if (start < end) {
            //set a pivotindex by calling partition() which re-arranges the elements
            pivotIndex = partition(start, end);
            print("pivotIndex: " + pivotIndex);

            //recursively call quickSort() with start, pivotIndex - 1 (left side)
            quickSort(start, pivotIndex - 1);
            //recursively call quickSort() pivotIndex+1, end (right side)
            quickSort(pivotIndex + 1, end);

        } else {
            return; // do nothing as only one element and its sorted
        }
    }

    protected int partition(int start, int end) {
        print("partition(start: " + start + ", end: " + end + ")");

        //set up the indexes for up and down
        int down = end;
        //temp obj E pivot = get(start)
        E pivot = get(start);
        //int up = start + 1;
        int up = start;
        print("up: " + up + ", down: " + end + ", pivot: " + pivot);

        //while loop where up < down - as long as havent passed
        while (up < down) {

            //while loop to move our up index up 
            while (up < end && ((Comparable) get(up)).compareTo((Comparable) pivot) < 0) {
                up++;
            }
            //while loop to move the down index down
            while (down > start && (((Comparable) get(down)).compareTo((Comparable) pivot) >= 0)) {
                down--; //keep moving down
            }
            if (up < down) { //if the indexes don't pass each other
                //create temp obj for the elem at up index
                E elemUp = get(up);
                //swap set(up, )
                set(up, get(down));
                //set(down, )
                set(down, elemUp);
            }
        }
        //set(start, get(down)) and swap the pivot
        set(start, get(down));
        //set(down, pivot)
        set(down, pivot);

        print("result partition(start: " + start + ", end: " + end + "): " + this);
        //return that index
        return down;
    }

    protected void print(String message) {
        if (!_debug)
            return;

        System.out.println(message);
    }
}
