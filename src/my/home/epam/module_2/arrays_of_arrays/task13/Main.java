package my.home.epam.module_2.arrays_of_arrays.task13;

import java.util.Random;

/*
 * Задача 13. Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов.
 */

public class Main {

    public static void main(String[] args) {
	int n = 5;
	int[][] array = new int[n][n];

	initArray(array);
	printArray("Исходная матрица:", array);

	changeColumnAsc(array);
	System.out.println();
	printArray("Сортировка столбцов по возрастанию значений элементов:", array);

	changeColumnDesc(array);
	System.out.println();
	printArray("Сортировка столбцов по убыванию значений элементов:", array);

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

    private static void changeColumnAsc(int[][] array) {
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		for (int k = 0; k < array.length - 1; k++) {
		    int temp;
		    if (array[k][j] > array[k + 1][j]) {
			temp = array[k][j];
			array[k][j] = array[k + 1][j];
			array[k + 1][j] = temp;
		    }
		}
	    }
	}
    }

    private static void changeColumnDesc(int[][] array) {
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		for (int k = 0; k < array.length - 1; k++) {
		    int temp;
		    if (array[k][j] < array[k + 1][j]) {
			temp = array[k][j];
			array[k][j] = array[k + 1][j];
			array[k + 1][j] = temp;
		    }
		}
	    }
	}
    }
}