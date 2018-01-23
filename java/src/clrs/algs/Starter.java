package clrs.algs;

import java.util.Arrays;

public class Starter {

    private static int[] arr = new int[]{2, 5, 1, 4, 3, 2, 1, 6, 8, 3};

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        System.out.println(Arrays.toString(arr));
        sorting.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
