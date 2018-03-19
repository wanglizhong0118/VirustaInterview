import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Several ways to find duplucated elements in two arrays.
 */
public class DuplicationInArrays {

    public static int DirectComparison(int[] arr1, int[] arr2) {

        int duplication = 0;

        Arrays.sort(arr1);
        int arr1Length = arr1.length;
        int arr1Pointer = 0;

        Arrays.sort(arr2);
        int arr2Length = arr2.length;
        int arr2Pointer = 0;

        while (arr1Pointer < arr1Length && arr2Pointer < arr2Length) {
            if (arr1[arr1Pointer] == arr2[arr2Pointer]) {
                duplication++;
                arr1Pointer++;
                arr2Pointer++;
            } else if (arr1[arr1Pointer] > arr2[arr2Pointer]) {
                arr2Pointer++;
            } else {
                arr1Pointer++;
            }
        }
        return duplication;
    }

    public static int CombineAndSort(int[] arr1, int[] arr2) {

        int duplication = 0;

        int[] temp = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, temp, 0, arr1.length);
        System.arraycopy(arr2, 0, temp, arr1.length, arr2.length);
        Arrays.sort(temp);

        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i] == temp[i + 1]) {
                duplication++;
            }
        }
        return duplication;
    }

    public static int HashSetWarn(int[] arr1, int[] arr2) {
        int duplication = 0;

        Set<Integer> tempSet = new HashSet<Integer>();
        for (int x : arr1) {
            Collections.addAll(tempSet, x);
        }
        for (int y : arr2) {
            boolean sucess = tempSet.add(y);
            if (!sucess) duplication++;
        }
        return duplication;
    }

    public static void main(String args[]) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = {2, 4, 6, 8, 10};

        int duplication;

        if (arr1.length == 0 || arr2.length == 0) {
            duplication = 0;
        }

        duplication = DirectComparison(arr1, arr2);
        System.out.println(duplication);

        duplication = CombineAndSort(arr1, arr2);
        System.out.println(duplication);

        duplication = DirectComparison(arr1, arr2);
        System.out.println(duplication);
    }
}
