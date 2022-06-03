package my.home.epam.module_2.arrays_of_arrays.task04;

/*
 * Задача 4. Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).
 */

public class Main {

    public static void main(String[] args) {
	int n = 6;
	int[][] array = new int[n][n];

	initArray(array);

	printArray("Матрица:", array);
    }

    private static void initArray(int[][] array) {
	if (array == null) {
	    return;
	}

	for (int i = 0; i < array.length; i += 2) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = j + 1;
	    }
	}

	for (int i = 1; i < array.length; i += 2) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = array[i].length - j;
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