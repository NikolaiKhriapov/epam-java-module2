package my.home.epam.module_2.one_dimentional_arrays.task03;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 3. Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
 */

public class Main {

    public static void main(String[] args) {
	int n = 10;
	int[] array = new int[n];

	initArray(array);
	System.out.println("Массив действительных чисел: " + Arrays.toString(array));
	System.out.println();

	System.out.println("Количество отрицательных элементов: " + calculateNegElements(array));
	System.out.println("Количество положительных элементов: " + calculatePosElements(array));
	System.out.println("Количество нулевых элементов: " + calculateZeroElements(array));
    }

    private static void initArray(int[] array) {
	if (array == null) {
	    return;
	}

	Random random = new Random();

	for (int i = 0; i < array.length; i++) {
	    array[i] = random.nextInt(-10, 10);
	}
    }

    private static int calculatePosElements(int[] array) {
	int count = 0;

	for (int i = 0; i < array.length; i++)
	    if (array[i] > 0) {
		count++;
	    }

	return count;
    }

    private static int calculateNegElements(int[] array) {
	int count = 0;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] < 0) {
		count++;
	    }
	}
	return count;
    }

    private static int calculateZeroElements(int[] array) {
	int count = 0;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] == 0) {
		count++;
	    }
	}
	return count;
    }
}