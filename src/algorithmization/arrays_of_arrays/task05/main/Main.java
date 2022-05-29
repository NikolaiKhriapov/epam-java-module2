package algorithmization.arrays_of_arrays.task05.main;

/*
 * Задача 5. Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).
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

	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length - i; j++) {
		array[i][j] = i + 1;
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