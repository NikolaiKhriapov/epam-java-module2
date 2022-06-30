package my.home.epam.module_2.one_dimentional_arrays.task05;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 5. Даны целые числа а1, а2, ...,аn. Вывести на печать только те числа, для которых аi > i.
 */

public class Main {

    public static void main(String[] args) {
	int n = 10;
	int[] a = new int[n];

	initArray(a);
	System.out.println("Целые числа: " + Arrays.toString(a));
	System.out.println();

	result("Результат: ", a);
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

    private static void result(String message, int[] array) {
	System.out.print(message);

	for (int i = 0; i < array.length; i++) {
	    if (array[i] > i) {
		System.out.print(array[i] + " ");
	    }
	}
    }
}