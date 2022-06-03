package my.home.epam.module_2.arrays_of_arrays.task10;

import java.util.Random;

/*
 * Задача 10. Найти положительные элементы главной диагонали квадратной матрицы.
 */

public class Main {

    public static void main(String[] args) {
	int n = 6;
	int[][] array = new int[n][n];
	
	initArray(array);
	
	printArray("Матрица:", array);
	System.out.println();
	
	findArrayDiagPosElem("Результат: ", array);
    }
    
    private static void initArray(int[][] array) {
	if (array == null) {
	    return;
	}
	
	Random random = new Random();
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = random.nextInt(-9, 10);
	    }
	}
    }
    
    private static void printArray(String message, int[][] array) {
	System.out.println(message);
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		System.out.printf("%2d" + " ", array[i][j]);
	    }
	    System.out.println();
	}
    }

    private static void findArrayDiagPosElem(String message, int[][] array) {
	System.out.print(message);
	
	int sumForCheck = 0;
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if ((i == j) && (array[i][j] > 0)) {
		    System.out.print(array[i][j] + " ");
		    sumForCheck += array[i][j];
		}
	    }
	}
	if (sumForCheck == 0) {
	    System.out.print("Главная диагональ матрицы не содержит положительных чисел.");
	}
    }
}