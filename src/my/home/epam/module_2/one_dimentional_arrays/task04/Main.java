package my.home.epam.module_2.one_dimentional_arrays.task04;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 4. Даны действительные числа а1, а2, ..., аn. Поменять местами наибольший и наименьший элементы.
 */

public class Main {

    public static void main(String[] args) {
	int n = 10;
	int[] a = new int[n];

	initArray(a);

	System.out.println("Действительные числа: " + Arrays.toString(a));
	System.out.println();

	swap(a);

	System.out.println("Результат: " + Arrays.toString(a));
    }

    private static void initArray(int[] array) {
	if (array == null) {
	    return;
	}

	Random random = new Random();

	for (int i = 0; i < array.length; i++)
	    array[i] = random.nextInt(-10, 10);
    }

    private static void swap(int[] array) {
	int highestElem = array[0];
	int lowestElem = array[0];

	for (int i = 0; i < array.length; i++) {
	    if (array[i] > highestElem) {
		highestElem = array[i];
	    }
	    if (array[i] < lowestElem) {
		lowestElem = array[i];
	    }
	}

	for (int i = 0; i < array.length; i++) {
	    if (array[i] == highestElem) {
		array[i] = lowestElem;
	    } else if (array[i] == lowestElem) {
		array[i] = highestElem;
	    }
	}
    }
}