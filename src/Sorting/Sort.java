package Sorting;

import java.util.Arrays;

public class Sort {
    public static void bubbleSort(int[] array){
        for (int i = array.length - 1; i >= 0 ; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort2(int[] array){
        boolean isSorted;
        for (int i = array.length - 1; i >= 0 ; i--){
            isSorted = true;
            for (int j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            for (int j = i+1; j < array.length; j++){
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }

            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array){
        for(var i = 1; i < array.length; i++){
            var current = array[i];
            var j = i -1;
            while (j >= 0 && array[j] > current){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }

    public static void mergeSort(int[] array){

        if (array.length < 2)
            return;

        //Divide array into half
        var middle = array.length / 2;

        int[] left = new int[middle];

        for (var i = 0; i < middle; i++){
            left[i] = array[i];
        }

        int[] right = new int[array.length - middle];
        for (var i = middle; i < array.length; i++){
            right[i - middle] = array[i];
        }

        //Sorting.Sort each half
        mergeSort(left);
        mergeSort(right);

        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] result){
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length){
            if (left[i] <= right[j]){
                result[k++] = left[i];
            }
            else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length){
            result[k++] = left[i++];
        }

        while (j < right.length){
            result[k++] = right[j++];
        }
    }


    public static void quickSort(int[] array, int start, int end){
        if(start >= end)
            return;

        var boundary = partition(array, start, end);

        quickSort(array, start, boundary -1);
        quickSort(array, boundary + 1, end);

    }
    private static int partition(int[] array, int start, int end){
        var pivot = array[end];
        var boundary = start - 1;

        for (var i =start; i <= end; i++){
            if (array[i] <= pivot){
                boundary++;
                int temp = array[i];
                array[i] = array[boundary];
                array[boundary] = temp;
            }
        }
        return boundary;
    }

}
