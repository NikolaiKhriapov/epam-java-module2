package my.home.epam.module_2.arrays_of_arrays.task11;

import java.util.Random;

/*
 * Задача 11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.
 */

public class Main {

    public static void main(String[] args) {
	int i = 10;
	int j = 20;
	int[][] array = new int[i][j];
	
	initArray(array);
	
	printArray("Матрица:", array);
	System.out.println();
	
	printResult("Результат: ", array);
    }
    
    private static void initArray(int[][] array) {
	if (array == null) {
	    return;
	}
	
	Random random = new Random();
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = random.nextInt(0, 16);
	    }
	}
    }

    private static void printArray(String message, int[][] array) {
	System.out.println(message);
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		System.out.printf("%2d  ", array[i][j]);
	    }
	    System.out.println();
	}
    }

    private static void printResult(String message, int[][] array) {
	System.out.print(message);
	
	int count = 0;
	int[] temp = new int[array.length];
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (array[i][j] == 5) {
		    count++;
		    if (count >= 3) {
			temp[i]++;
		    }
		}
	    }
	    count = 0;
	}
	
	int total = 0;
	
	for (int i = 0; i < temp.length; i++) {
	    total += temp[i];
	    if (temp[i] > 0) {
		System.out.print((i + 1) + " ");
	    }
	}
	if (total == 0) {
	    System.out.print("Таких строк не встречается.");
	}
    }
}