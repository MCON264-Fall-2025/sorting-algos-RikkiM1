package edu.touro.mcon264.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort implements Sorter {



    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        if (a.length < 2) {
            return;
        }

        int mid = a.length / 2;

        T[] left = Arrays.copyOfRange(a, 0, mid);
        T[] right = Arrays.copyOfRange(a, mid, a.length);

        sort(left, comp);
        sort(right, comp);

        merge(a, left, right, comp);
    }

    private <T> void merge(T[] a, T[] left, T[] right, Comparator<? super T> comp) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (comp.compare(left[i], right[j]) <= 0) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while (i < left.length) {
            a[k++] = left[i++];
        }

        while (j < right.length) {
            a[k++] = right[j++];
        }
    }
}