import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] numbers = {2,8,6,9,4,2};
		System.out.println("Original array: " + Arrays.toString(numbers));
		swap(numbers, 2, 5);
		System.out.println("Array after swap: "+Arrays.toString(numbers));
		
		String[] fruits = {"apple", "banana", "pineapple", "orange", "pear"};
		System.out.println("Original array: " + Arrays.toString(fruits));
		swap(fruits, 1, 3);
		System.out.println("Array after swap: "+Arrays.toString(fruits));

	}
	static <T>void swap(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2]=temp;
	}
}
