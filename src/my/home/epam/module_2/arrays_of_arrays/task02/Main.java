package my.home.epam.module_2.arrays_of_arrays.task02;

import java.util.Random;

/*
 * Задача 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */

public class Main {

    public static void main(String[] args) {
	int n = 5;
	int[][] array = new int[n][n];

	initArray(array);

	printArray("Матрица:", array);

	System.out.println();
	printResult(array);
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

    private static void printResult(int[][] array) {
	System.out.print("Диагональ 1: ");
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (i == j) {
		    System.out.print(array[i][j] + " ");
		}
	    }
	}
	
	System.out.println();
	System.out.print("Диагональ 2: ");
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (i == (array[i].length - 1) - j) {
		    System.out.print(array[i][j] + " ");
		}
	    }
	}
    }
}