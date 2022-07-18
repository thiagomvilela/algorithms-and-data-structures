import java.util.Random;

public class SortAlgorithms {

	public static void bubbleSort(int[] array) {
		if (array != null && array.length > 1) {
			boolean swaped;
			do {
				swaped = false;
				for (int i = 0; i < array.length - 1; i++) {
					if (array[i] > array[i+1]) {
						int temp = array[i];
						array[i] = array[i+1];
						array[i+1] = temp;
						swaped = true;
					}
				}
			} while (swaped);
		}
	}
	
	public static void selectionSort(int[] array) {
		if (array != null && array.length > 1) {
			for (int i = 0; i < array.length; i++) {
				int menor = i;
				for (int j = i; j < array.length; j++) {
					if (array[j] < array[menor]) {
						menor = j;
					}
				}
				int temp = array[menor];
				array[menor] = array[i];
				array[i] = temp;
			}
		}
	}
	
	public static void mergeSort(int[] array) {
		sort(array);
	}
	
	private static void sort(int[] array) {
		if (array.length > 1) {
			int leftArraySize = array.length/2;
			int[] leftArray = new int[leftArraySize];
			for (int i = 0; i < leftArray.length; i++) {
				leftArray[i] = array[i];
			}
			
			int[] rightArray = new int[array.length - leftArraySize];
			for (int i = 0; i < rightArray.length; i++) {
				rightArray[i] = array[i + leftArraySize];
			}
			
			sort(leftArray);
			sort(rightArray);
			merge(leftArray, rightArray, array);
		}
	}

	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		int l = 0, r = 0;
		for (int i = 0; i < array.length; i++) {
			if (l >= leftArray.length) {
				array[i] = rightArray[r];
				r++;
			} else if (r >= rightArray.length) {
				array[i] = leftArray[l];
				l++;
			}else if (leftArray[l] > rightArray[r]) {
				array[i] = rightArray[r];
				r++;
			} else {
				array[i] = leftArray[l];
				l++;
			}
		}
	}

	
	public static void quickSort(int[] array) {
		if(array.length > 1) {
			sort(array, 0, array.length - 1);
		}
	}
	
	private static void sort(int[] array, int first, int last) {
		if (last - first > 0) {
			int pivotIndex = partition(array, first, last);
			sort(array, first, pivotIndex - 1);
			sort(array, pivotIndex + 1, last);
		}
	}
	
	private static int partition(int[] array, int first, int last) {
		int up = first;
		int down = last;
		int pivot = array[first];
		
//		for (up = first; up < last; up++) {
//			if (array[up] > pivot) {
//				
//			}
//		}
		
		while(down > up) {
			while(up <= last && array[up] <= pivot) {
				up++;
			}
			
			while(array[down] > pivot) {
				down--;
			}
			
			if (down > up) {
				int temp = array[up];
				array[up] = array[down];
				array[down] = temp;
			}
		}
		
		array[first] = array[down];
		array[down] = pivot;
		return down;
	}

	public static void main(String[] args) {
		Random random = new Random();
		
		final int SIZE = 1000000000;
		
		int[] array = new int[SIZE];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(SIZE*10);
//			System.out.print(array[i] + ", ");
		}
		
//		System.out.println();
		
		long start = System.currentTimeMillis();
		mergeSort(array);
//		quickSort(array);
//		bubbleSort(array);
//		selectionSort(array);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
//		for (int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + ", ");
//		}
	}
	
}
