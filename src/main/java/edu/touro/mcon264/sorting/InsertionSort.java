package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class InsertionSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // TODO: implement insertion sort
        for (int i = 1; i < a.length; i++) {
            T key = a[i]; //key becomes a[0]
            int j = i - 1; //j becomes one less then what number the loop is up to.
            while (j >= 0 && comp.compare(a[j], key) > 0) {
            a[j + 1] = a[j];
            }
        }
    }
}

