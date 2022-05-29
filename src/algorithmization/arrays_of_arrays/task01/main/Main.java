package algorithmization.arrays_of_arrays.task01.main;

import java.util.Random;

/*
 * Задача 1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */

public class Main {

    public static void main(String[] args) {
	int i = 5;
	int j = 5;
	int[][] array = new int[i][j];

	initArray(array);
	
	printArray("Матрица:", array);

	System.out.println();
	
	printResult("Результат:", array);
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

    private static void printResult(String message, int[][] array) {
	System.out.println(message);

	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j += 2) {
		if (array[0][j] > array[array.length - 1][j]) {
		    System.out.print(array[i][j] + " ");
		}
	    }
	    System.out.println();
	}
    }
}