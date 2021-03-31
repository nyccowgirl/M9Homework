import java.util.ArrayList;

public class Practice {

    public static void main(String[] args) {
        Comparable[] array1 = {1, 3, 5, 11, 2, 8, 3, 2, 15};
        Comparable[] array2 = {0, 1, 2, 3, 3, 3, 5, 7, 11};

        ArrayList<Integer> indices1 = new ArrayList<>();
        indices1 = findIndicesRecursiveSorted(array1, 3);
        System.out.println(indices1.toString());

        ArrayList<Integer> indices2 = new ArrayList<>();
        indices2 = findIndicesRecursiveSorted(array2, 3);
        System.out.println(indices2.toString());
    }

    public static ArrayList<Integer> findIndicesRecursiveSorted(Comparable[] array, Comparable target) {
        ArrayList<Integer> result = new ArrayList<>();

        findIndicesRecursiveSorted(result, array, 0, array.length - 1, target);

        return result;
    }

    public static void findIndicesRecursiveSorted(ArrayList indices, Comparable[] array, int start, int end, Comparable target) {
        if (array[start].compareTo(target) == 0) {
            indices.add(start);
        }

        // For unsorted:
//        if (start == end) {
//            return;
//        } else {
//            findIndicesRecursiveSorted(temp, array, start + 1, end, target);
//        }

        // For sorted - ends if end of list or value is greater than target:
        if (start == end || array[start].compareTo(target) > 0) {
            return;
        } else {
            findIndicesRecursiveSorted(indices, array, start + 1, end, target);
        }
    }
}
