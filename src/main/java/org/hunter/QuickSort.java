package org.hunter;

public class QuickSort {

    public static void main(String [] args) {

        QuickSort quickSort = new QuickSort();

//        int [] arr = new int[] {77,88,79,3,44,202,101,3,2,1};
        int [] arr = new int[] {1,2,0};
//        int [] arr = new int[] {1,2,3,4,5,6,7};
        quickSort.sort(arr, 0, arr.length -1);
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    private void sort(int [] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int pivot = find(arr, start, end);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    /**
     * choose a pivot value and then decide which index do we insert the pivot value in the array?
     * 0,1,2
     * 2,1,0
     * 1,0,2
     * 1,2,0 -> 1,0,2
     */
    int find(int [] arr, int start, int end) {
        int pivotValue = arr[start];
        int pivotIndex = start;
        for(int i = start; i <= end; ++i) {
            if(arr[i] < pivotValue) {
                ++pivotIndex;
                int tmp = arr[i];
                arr[i] = arr[pivotIndex];
                arr[pivotIndex] = tmp;
            }
        }
        int tmp = arr[pivotIndex];
        arr[pivotIndex] = pivotValue;
        arr[start] = tmp;
        return pivotIndex;
    }

}
