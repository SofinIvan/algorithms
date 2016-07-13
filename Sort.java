package CodeAbbey.algorithms;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] nums = {2, 81, 1, 57, 27, 45, 65, 23, 42, 5, 8, 0, 4, 10, 25, 67, 33, 12, 14, 16, 9, 7, 111};
        System.out.println(Arrays.toString(nums));
        //bubbleSort(nums);
        //selectionSort(nums);
        //insertionSort(nums);
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        trampam(null);

    }

   // static void trampam(Integer a){
   //     System.out.println("Integer");
   // }

    static void trampam(String a){
        System.out.println("String");
    }

    static void trampam(Object a){
        System.out.println("Object");
    }


    //быстрая сортировка
    private static void quickSort(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        int x = nums[(low + high) / 2];

        do {
            while (nums[i] < x) ++i;
            while (nums[j] > x) --j;
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        } while (i < j);

        if (low < j) quickSort(nums, low, j);
        if (i < high) quickSort(nums, i, high);
    }

    //сортировка вставками
    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] >= temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    //сортировка выбором
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < temp) {
                    temp = nums[j];
                    swap(nums, i, j);
                }
            }
        }
    }

    //пузырьковая сортировка
    private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
            }
        }
    }

    //перестановка двух элементов в массиве
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}