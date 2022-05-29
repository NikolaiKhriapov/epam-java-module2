package algorithmization.arrays_of_arrays.task06.main;

/*
 * Задача 6. Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).
 */

public class Main {

    public static void main(String[] args) {
	int n = 8;
	int[][] array = new int[n][n];

	initArray(array);

	printArray("Массив:", array);
    }

    private static void initArray(int[][] array) {
	if (array == null) {
	    return;
	}

	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (((j >= i) && (j < array[i].length - i)) || ((j <= i) && (j >= array[i].length - (i + 1)))) {
		    array[i][j] = 1;
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