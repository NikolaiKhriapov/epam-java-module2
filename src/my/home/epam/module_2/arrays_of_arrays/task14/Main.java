package my.home.epam.module_2.arrays_of_arrays.task14;

import java.util.Random;

/*
 * Задача 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число единиц равно номеру столбца.
 */

public class Main {

    public static void main(String[] args) {
	int lines = 6;
	int columns = 5;
	int[][] array;

//	Количество строк не может быть меньше количества столбцов. Если меньше – меняем значения местами:
	if (lines < columns) {
	    lines = lines + columns;
	    columns = lines - columns;
	    lines = lines - columns;
	}

	array = new int[lines][columns];

	initArray(array, columns);

	printArray("Матрица:", array);
    }

    private static void initArray(int[][] array, int columns) {
	if (array == null) {
	    return;
	}

	Random random = new Random();

	int[] count = new int[columns];
	for (int k = 0; k < columns; k++) {
	    count[k] = k + 1;
	}

	for (int j = 0; j < columns; j++) {
	    int countOfOnes = 0;
	    while (true) {
		if (countOfOnes == count[j]) {
		    break;
		}
		int i = random.nextInt(array.length);
		if (array[i][j] == 0) {
		    array[i][j] = 1;
		    countOfOnes++;
		}
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
}