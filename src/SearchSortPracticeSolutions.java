import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SearchSortPracticeSolutions {

	public static void main(String[] args) {
		int size = 100;
		Integer[] numbers = new Integer[size];
		Random generator = new Random();
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(size/2);
		}
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		int target = generator.nextInt(size/2);
		System.out.println("The indices of " + target + " are: \n" + findIndicesRecursiveSorted(numbers, target));
		
	}
	
	public static ArrayList<Integer> findIndicesRecursiveSorted(Comparable[] array, Comparable target) {
		return findIndicesRecursiveSortedHelper(array, 0, array.length-1, target);
	}
	private static ArrayList<Integer> findIndicesRecursiveSortedHelper(Comparable[] array, int first, int last, Comparable target) {
		if(first > last) {
			return new ArrayList<Integer>(); // we are done- this means the target was not in the array
		}
		
		int mid = ((last - first) / 2) + first;

		if (array[mid].compareTo(target)==0) {
		   // we have found the target
		   ArrayList<Integer> indexList = new ArrayList<Integer>();
		   indexList.add(mid);
		   
		   // since there could be duplicates, we need to move left and right to get all the indices
			
		   // find all to the left
		   int left = mid;
		   left--;
		   while(left>=first && array[left].compareTo(target)==0) {
			   indexList.add(left);
			   left--;
		   }
		   
		   // find all to the right
		   int right = mid;
		   right++;
		   while(right<=last && array[right].compareTo(target)==0) {
			   indexList.add(right);
			   right++;
		   }
		   Collections.sort(indexList);
		   return indexList;
		
		} else if (array[mid].compareTo(target) > 0 ) { // the number in the array is bigger than the target- look to the left
		      return findIndicesRecursiveSortedHelper(array, first, mid-1, target);
		
		} else { // array[mid].compareTo(target) < 0 // the number in the array is smaller than the target- look to the right
			return findIndicesRecursiveSortedHelper(array, mid+1, last, target);
		}
		
	}
}
