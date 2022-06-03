package my.home.epam.module_2.arrays_of_arrays.task08;

import java.util.Random;
import java.util.Scanner;

/*
 * Задача 8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить на соответствующие 
 * им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит пользователь с клавиатуры.
 */

public class Main {

    public static void main(String[] args) {
	int n = 5;
	int[][] array = new int[n][n];
	int column1;
	int column2;
	
	initArray(array);
	
	printArray("Матрица:", array);
	System.out.println();
	
	do {
	    column1 = console("Введите номер столбца 1: ");
	} while ((column1 < 0) || (column1 > n));
	
	do {
	    column2 = console("Введите номер столбца 2: ");
	} while ((column2 < 0) || (column2 > n));
	
	swapColumns(array, column1, column2);
	
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

    private static int console(String message) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	
	System.out.print(message);
	
	while (!scanner.hasNextInt()) {
	    System.out.print(message);
	    scanner.next();
	}
	return scanner.nextInt();
    }

    private static void swapColumns(int[][] array, int column1, int column2) {
	int temp;
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		temp = array[i][column1 - 1];
		array[i][column1 - 1] = array[i][column2 - 1];
		array[i][column2 - 1] = temp;
	    }
	}
    }
}