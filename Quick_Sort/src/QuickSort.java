
import java.util.Random;

import javax.print.attribute.standard.NumberUpSupported;

public class QuickSort {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] numbers = new int[100];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(1000);
		}
		
		System.out.println("Before: ");
		printArray(numbers);
		
		quickSort(numbers);
		
		System.out.println("After: ");
		printArray(numbers);

	}
	
	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length -1);
	}
	
	private static void quickSort(int[] array, int lowIndex, int highIndex) {
		if (lowIndex >= highIndex) {
			return;
		}

		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex ;
		int pivot = array[pivotIndex];
		swapInt(array, pivotIndex, highIndex);

		int leftPointer = partition(array, lowIndex, highIndex, pivot);
		
		quickSort(array, lowIndex, leftPointer -1);
		quickSort(array, leftPointer + 1, highIndex);
	}

	private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		while (leftPointer < rightPointer) {
		
			while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			
			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			swapInt(array, leftPointer, rightPointer);
		}
		
		swapInt(array, leftPointer, highIndex);
		return leftPointer;
	}
	
	private static void swapInt(int[] array, int index1, int index2) {
		int tmp = array[index1];
		
		array[index1] = array[index2];
		array[index2] = tmp;
	}
	
	private static void printArray(int[] numbers) {
		System.out.print("[ ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.print("]\n");
	}

}
