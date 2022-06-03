package my.home.epam.module_2.arrays_of_arrays.task09;

import java.util.Random;

/*
 * Задача 9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. 
 * Определить, какой столбец содержит максимальную сумму.
 */

public class Main {

    public static void main(String[] args) {
	int n = 5;
	int[][] array = new int[n][n];

	initArray(array);

	printArray("Матрица:", array);
	System.out.println();

	countAndPrintSumForColumns(array);
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

    private static void countAndPrintSumForColumns(int[][] array) {
	int[] sumArray = new int[array.length];

	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		sumArray[j] += array[i][j];
	    }
	}

	System.out.print("Сумма элементов в каждом столбце: ");
	for (int i = 0; i < sumArray.length; i++) {
	    System.out.print(sumArray[i] + " ");
	}

	int maxSum = 0;
	int columnNumber = 0;
	for (int i = 0; i < sumArray.length; i++) {
	    if (sumArray[i] > maxSum) {
		maxSum = sumArray[i];
		columnNumber = i + 1;
	    }
	}
	System.out.println();
	System.out.println("Максимальную длину содержит столбец: " + columnNumber);
    }
}