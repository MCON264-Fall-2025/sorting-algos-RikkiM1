package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override

    public <T> void sort(T[] a, Comparator<? super T> comp) {
        if (a.length < 2) {
            return;
        }

        int mid = a.length / 2;

        // Split array
        @SuppressWarnings("unchecked")
        T[] left = (T[]) new Object[mid];
        @SuppressWarnings("unchecked")
        T[] right = (T[]) new Object[a.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            right[i - mid] = a[i];
        }

        // Recursively sort halves
        sort(left, comp);
        sort(right, comp);

        // Merge halves
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