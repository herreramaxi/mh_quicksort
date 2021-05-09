/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclassquicksort;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Maximiliano Herrera
 */
public class QSArrayList<E> extends ArrayList<E> {

    public void quickSortFirstElementPivot(int start, int end) {
        int pivotIndex;

        if (start < end) {
            pivotIndex = partitionFirstElementPivot(start, end);

            quickSortFirstElementPivot(start, pivotIndex - 1);
            quickSortFirstElementPivot(pivotIndex + 1, end);

        }
    }

    //Hoare partition scheme
    private int partitionFirstElementPivot(int start, int end) {
        int down = end;
        E pivot = get(start);
        int up = start;

        while (up < down) {
            up++;

            while (up < end && ((Comparable) get(up)).compareTo((Comparable) pivot) < 0) {
                up++;
            }

            while (down > start && (((Comparable) get(down)).compareTo((Comparable) pivot) >= 0)) {
                down--;
            }
            if (up < down) {
                swap(down, up);
            }
        }

        swap(start, down);

        return down;
    }

    public void quickSortMiddleElementPivot(int start, int end) {
        int pivotIndex;

        if (start < end) {
            pivotIndex = partitionMiddleElementPivot(start, end);

            quickSortMiddleElementPivot(start, pivotIndex - 1);
            quickSortMiddleElementPivot(pivotIndex + 1, end);
        }
    }

    //Hoare partition scheme
    private int partitionMiddleElementPivot(int start, int end) {
        int down = end;
        int mid = (start + end) / 2;

        swap(start, mid);

        E pivot = get(start);
        int up = start;

        while (up < down) {
            up++;

            while (up < end && ((Comparable) get(up)).compareTo((Comparable) pivot) < 0) {
                up++;
            }

            while (down > start && (((Comparable) get(down)).compareTo((Comparable) pivot) >= 0)) {
                down--;
            }
            if (up < down) {
                swap(down, up);
            }
        }

        swap(start, down);

        return down;
    }

    public void quickSortLastElementPivot(int start, int end) {
        int pivotIndex;
        if (start < end) {
            pivotIndex = partitionLomutoLastElementPivot(start, end);
            quickSortLastElementPivot(start, pivotIndex - 1);
            quickSortLastElementPivot(pivotIndex + 1, end);
        }
    }

    //Lomuto partition scheme
    public int partitionLomutoLastElementPivot(int low, int high) {
        E pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (((Comparable) get(j)).compareTo((Comparable) pivot) <= 0) {
                i++;
                //swap the elements           
                swap(i, j);
            }
        }

        swap(i + 1, high);

        return i + 1;
    }

    private void random(int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;

        swap(pivot, high);
    }

    //Lomuto partition scheme
    public int partitionLomutoRandom(int low, int high) {
        this.random(low, high);
        E pivot = get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (((Comparable) get(j)).compareTo((Comparable) pivot) <= 0) {
                i++;

                swap(i, j);
            }
        }

        swap(i + 1, high);

        return i + 1;
    }

    public void quickSortRandomElementPivot(int start, int end) {
        int pivotIndex;
        if (start < end) {
            pivotIndex = partitionLomutoRandom(start, end);
            quickSortRandomElementPivot(start, pivotIndex - 1);
            quickSortRandomElementPivot(pivotIndex + 1, end);
        }
    }

    public void quickSortMedianOf3Pivot(int start, int end) {
        int size = end - start + 1;
        if (size <= 3)
            manualSort(start, end);
        else {
            int median = medianOf3(start, end);
            int partition = partitionIt(start, end, median);
            quickSortMedianOf3Pivot(start, partition - 1);
            quickSortMedianOf3Pivot(partition + 1, end);
        }
    }

    private int medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (compareTo(left, center) > 0)
            swap(left, center);

        if (compareTo(left, right) > 0)
            swap(left, right);

        if (compareTo(center, right) > 0)
            swap(center, right);

        swap(center, right - 1);

        return right - 1;
    }

    //Hoare partition scheme
    private int partitionIt(int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (compareTo(++leftPtr, pivot) < 0);

            while (compareTo(--rightPtr, pivot) > 0);

            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }

        swap(leftPtr, right - 1);

        return leftPtr;
    }

    private int compareTo(E i, E j) {
        return ((Comparable) i).compareTo((Comparable) j);
    }

    private int compareTo(int i, int j) {
        return ((Comparable) get(i)).compareTo((Comparable) get(j));
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (compareTo(get(left), get(right)) > 0)
                swap(left, right);
            return;
        } else {
            if (compareTo(left, right - 1) > 0)
                swap(left, right - 1);
            if (compareTo(left, right) > 0)
                swap(left, right);
            if (compareTo(right - 1, right) > 0)
                swap(right - 1, right);
        }
    }

    public void swap(int position1, int position2) {
        E objPosition2 = get(position2);

        set(position2, get(position1));
        set(position1, objPosition2);
    }
}
