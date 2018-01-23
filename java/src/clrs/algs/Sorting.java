package clrs.algs;

public class Sorting {

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public void insertSort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int toBeInserted = nums[i];
            int j = i;
            while (j > 0 && toBeInserted < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = toBeInserted;
        }
    }

    public void mergeSort(int[] nums) {
        int[] aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, aux);
    }

    private void mergeSort(int[] nums, int lo, int hi, int[] aux) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo)/2;
        mergeSort(nums, lo, mid, aux);
        mergeSort(nums, mid + 1, hi, aux);
        merge(nums, lo, mid, hi, aux);
    }

    private void merge(int[] nums, int lo, int mid, int hi, int[] aux) {
        int i = lo, j = mid + 1;
        System.arraycopy(nums, lo, aux, lo, hi - lo + 1);
        for (int k = lo; k <= hi; k++) {
            if (i > mid) nums[k] = aux[j++];
            else if (j > hi) nums[k] = aux[i++];
            else if (aux[i] < aux[j]) nums[k] = aux[i++];
            else nums[k] = aux[j++];
        }
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int j = partition1(nums, lo, hi);
            quickSort(nums, lo, j - 1);
            quickSort(nums, j + 1, hi);
        }
    }

    private int partition1(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, hi);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
