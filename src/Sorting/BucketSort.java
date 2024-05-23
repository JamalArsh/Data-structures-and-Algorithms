package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void sort(int[] array, int numberOfBuckets){

        //Creating buckets
        List<List<Integer>> buckets = new ArrayList<>();
        for(var i = 0; i < numberOfBuckets; i++){
            buckets.add(new ArrayList<>());
        }

        for (var item: array){
            buckets.get(item / numberOfBuckets).add(item);
        }

        var i = 0;
        for (var bucket: buckets){
            Collections.sort(bucket);
            for (var item: bucket){
                array[i++] = item;
            }
        }
    }
}
