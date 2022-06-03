package my.home.epam.module_2.arrays_of_arrays.task15;

import java.util.Random;

/*
 * Задача 15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */

public class Main {

    public static void main(String[] args) {
	int i = 5;
	int j = 6;
	int[][] array = new int[i][j];
	int maxElem;
	
	initArray(array);
	
	printArray("Исходная матрица:", array);
	System.out.println();
	
	maxElem = findMaxElem("Максимальный элемент матрицы: ", array);
	
	changeElem(array, maxElem);
	
	System.out.println();
	printArray("Результат:", array);
    }
    
    private static void initArray(int[][] array) {
	if (array == null) {
	    return;
	}
	
	Random random = new Random();
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = random.nextInt(10);
	    }
	}
    }

    private static void printArray(String message, int[][] array) {
	System.out.println(message);
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		System.out.print(array[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    private static int findMaxElem(String message, int[][] array) {
	System.out.print(message);
	
	int maxElem = array[0][0];
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (array[i][j] > maxElem) {
		    maxElem = array[i][j];
		}
	    }
	}
	System.out.println(maxElem);
	return maxElem;
    }

    private static void changeElem(int[][] array, int maxElem) {
	for (int i = 0; i < array.length; i += 2) {
	    for (int j = 0; j < array[i].length; j += 2) {
		array[i][j] = maxElem;
	    }
	}
    }
}