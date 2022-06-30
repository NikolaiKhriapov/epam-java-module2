package my.home.epam.module_2.arrays_of_arrays.task12;

import java.util.Random;

/*
 * Задача 12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */

public class Main {

    public static void main(String[] args) {
	int n = 5;
	int[][] array = new int[n][n];
	
	initArray(array);
	printArray("Исходная матрица:", array);
	
	changeLineAsc(array);
	System.out.println();
	printArray("Сортировка строк по возрастанию значений элементов:", array);
	
	changeLineDesc(array);
	System.out.println();
	printArray("Сортировка строк по убыванию значений элементов:", array);
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

    private static int[][] changeLineAsc(int[][] array) {
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		for (int k = 0; k < array[i].length - 1; k++) {
		    int temp;
		    if (array[i][k] > array[i][k + 1]) {
			temp = array[i][k];
			array[i][k] = array[i][k + 1];
			array[i][k + 1] = temp;
		    }
		}
	    }
	}
	return array;
    }

    private static int[][] changeLineDesc(int[][] array) {
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		for (int k = 0; k < array[i].length - 1; k++) {
		    int temp;
		    if (array[i][k] < array[i][k + 1]) {
			temp = array[i][k];
			array[i][k] = array[i][k + 1];
			array[i][k + 1] = temp;
		    }
		}
	    }
	}
	return array;
    }
}