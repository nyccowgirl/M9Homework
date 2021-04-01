package Practice;

import java.util.ArrayList;
import java.util.Collections;

public class PracticeDriver {

    public static void main(String[] args) {
        Integer[] array1 = {1, 3, 5, 11, 2, 8, 3, 2, 15};
        Integer[] array2 = {0, 1, 2, 3, 3, 3, 5, 7, 11};

        ArrayList<Integer> indices1;
        indices1 = findIndicesRecursiveSorted(array1, 3);
        System.out.println(indices1.toString());                // unsorted: [1, 6]; sorted linear: [1]; binary: [6]

        ArrayList<Integer> indices2;
        indices2 = findIndicesRecursiveSorted(array2, 3);
        System.out.println(indices2.toString());                // [3, 4, 5]
    }

    public static ArrayList<Integer> findIndicesRecursiveSorted(Comparable[] array, Comparable target) {
        ArrayList<Integer> result = new ArrayList<>();
        findIndicesRecursiveSorted(result, array, 0, array.length - 1, target);
        return result;
    }

    public static void findIndicesRecursiveSorted(ArrayList indices, Comparable[] array, int start, int end, Comparable target) {
        // For unsorted:
//        if (start > end) {
//            return;
//        } else {
//            if (array[start].compareTo(target) == 0) {
//                indices.add(start);
//            }
//            findIndicesRecursiveSorted(indices, array, start + 1, end, target);
//        }

        // For sorted - ends if end of list or value is greater than target:
        // Linear/sequential
        if (start > end || array[start].compareTo(target) > 0) {
            return;
        } else {
            if (array[start].compareTo(target) == 0) {
                indices.add(start);
            }
            findIndicesRecursiveSorted(indices, array, start + 1, end, target);
        }

        // Binary
//        if (start > end) {
//            return;
//        }
//
//        int mid = ((end - start) / 2) + start;
//
//        if (array[mid].compareTo(target) == 0) {
//            indices.add(mid);
//
//            // check both sides for dupes
//            int left = mid - 1;
//            int right = mid + 1;
//            while (array[left].compareTo(target) == 0) {
//                indices.add(left);
//                left--;
//            }
//
//            while (array[right].compareTo(target) == 0) {
//                indices.add(right);
//                right++;
//            }
//
//            Collections.sort(indices);
//            return;
//        } else if (array[mid].compareTo(target) > 0) {
//            findIndicesRecursiveSorted(indices, array, start, mid - 1, target);
//        } else {
//            findIndicesRecursiveSorted(indices, array, mid + 1, end, target);
//        }
    }
}
