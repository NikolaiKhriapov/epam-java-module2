package algorithmization.arrays_of_arrays.task07.main;

/*
 * Задача 7. Сформировать квадратную матрицу порядка N по правилу: A[I,J] = sin((I^2 - J^2) / N) и подсчитать количество положительных элементов в ней.
 */

public class Main {

    public static void main(String[] args) {
	int n = 4;
	double[][] array = new double[n][n];
	int posNumbers;
	
	initArray(array);
	
	printArray("Матрица:", array);
	
	posNumbers = calculatePosNumbers(array);
	
	System.out.println("Количество положительных элементов: " + posNumbers);
    }
    
    private static void initArray(double[][] array) {
	if (array == null) {
	    return;
	}
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = (Math.sin(Math.pow(i, 2) - Math.pow(j, 2))) / array.length;
	    }
	}
    }

    private static void printArray(String message, double[][] array) {
	System.out.println(message);
	
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		System.out.printf("%7.3f ", array[i][j]);
	    }
	    System.out.println();
	}
    }

    private static int calculatePosNumbers(double[][] array) {
	int countPosNumbers = 0;

	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (array[i][j] > 0) {
		    countPosNumbers++;
		}
	    }
	}
	return countPosNumbers;
    }
}