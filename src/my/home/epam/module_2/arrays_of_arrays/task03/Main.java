package my.home.epam.module_2.arrays_of_arrays.task03;

import java.util.Random;
import java.util.Scanner;

/*
 * Задача 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

public class Main {

    public static void main(String[] args) {
	int i = 5;
	int j = 5;
	int[][] array = new int[i][j];
	int lineK;
	int columnP;

	initArray(array);
	printArray("Матрица:", array);

	System.out.println();

	do {
	    lineK = console("Введите номер строки k: ", i, j);
	} while ((lineK < 0) || (lineK > i));
	
	do {
	    columnP = console("Введите номер столбца p: ", i, j);
	} while ((columnP < 0) || (columnP > j));

	System.out.println();
	printLineK("Строка k: ", array, lineK);
	
	System.out.println();
	printColumnP("Столбец p: ", array, columnP);
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

    private static int console(String message, int lines, int columns) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.print(message);

	while (!scanner.hasNextInt()) {
	    scanner.next();
	    System.out.print(message);
	}
	
	return Integer.parseInt(scanner.next());
    }

    private static void printLineK(String message, int[][] array, int lineK) {
	System.out.print(message);

	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (i == lineK - 1)
		    System.out.print(array[lineK - 1][j] + " ");
	    }
	}
    }
    
    private static void printColumnP(String message, int[][] array, int columnP) {
	System.out.print(message);

	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (j == columnP - 1)
		    System.out.print(array[i][columnP - 1] + " ");
	    }
	}
    }
}