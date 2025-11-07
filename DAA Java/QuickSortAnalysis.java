import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSortAnalysis {
    static int deterministicCount = 0;
    static int randomizedCount = 0;
    static Random rand = new Random();

    public static void quickSortDeterministic(int[] arr, int low, int high) {
        if (low < high) {
            deterministicCount++;
            int pi = partitionDeterministic(arr, low, high);
            quickSortDeterministic(arr, low, pi - 1);
            quickSortDeterministic(arr, pi + 1, high);
        }
    }

    public static int partitionDeterministic(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[low];
        arr[low] = arr[i - 1];
        arr[i - 1] = temp;
        return i - 1;
    }

    public static void quickSortRandomized(int[] arr, int low, int high) {
        if (low < high) {
            randomizedCount++;
            int pi = partitionRandomized(arr, low, high);
            quickSortRandomized(arr, low, pi - 1);
            quickSortRandomized(arr, pi + 1, high);
        }
    }

    public static int partitionRandomized(int[] arr, int low, int high) {
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int temp = arr[low];
        arr[low] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        return partitionDeterministic(arr, low, high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] arrCopy = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            arrCopy[i] = arr[i];
        }

        quickSortDeterministic(arr, 0, n - 1);
        System.out.println("Sorted array (Deterministic pivot): " + Arrays.toString(arr));
        System.out.println("Steps (recursive calls) for Deterministic Quick Sort: " + deterministicCount);

        quickSortRandomized(arrCopy, 0, n - 1);
        System.out.println("Sorted array (Randomized pivot): " + Arrays.toString(arrCopy));
        System.out.println("Steps (recursive calls) for Randomized Quick Sort: " + randomizedCount);

        sc.close();
    }
}
