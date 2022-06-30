package my.home.epam.module_2.one_dimentional_arrays.task07;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 7. Даны действительные числа a1, a2, ..., a2n. Найти max(a1 + a2n, a2 + a2n-1, ..., an + an+1).
 */

public class Main {

    public static void main(String[] args) {
	int n = 5;
	int m = 2 * n;
	int[] a = new int[m];

	initArray(a);

	System.out.println("Действительные числа: " + Arrays.toString(a));
	System.out.println();

	findMaxElem("Результат: ", a);
    }

    private static void initArray(int[] array) {
	if (array == null) {
	    return;
	}

	Random random = new Random();

	for (int i = 0; i < array.length; i++) {
	    array[i] = random.nextInt(10);
	}
    }

    private static void findMaxElem(String message, int[] array) {
	System.out.print(message);

	int maxElem = array[0];
	int nextElem;
	for (int i = 0; i < (array.length / 2); i++) {
	    nextElem = array[i] + array[2 * ((array.length - 1) / 2) - i + 1];
	    if (nextElem > maxElem) {
		maxElem = nextElem;
	    }
	}
	System.out.print(maxElem);
    }
}