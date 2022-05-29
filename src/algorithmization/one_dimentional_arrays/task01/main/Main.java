package algorithmization.one_dimentional_arrays.task01.main;

import java.util.Random;

/*
 * Задача 1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */

public class Main {

    public static void main(String[] args) {
	int n = 10;
	int k = 3;
	int[] a = new int[n];

	initArray(a);

	System.out.print("A[" + n + "] = {");
	printArray(a);
	System.out.println("}, число K = " + k);
	System.out.println();

	System.out.println("Сумма элементов, кратных числу K: " + sumOfElementsDivByK(a, k));
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

    private static int sumOfElementsDivByK(int[] array, int k) {
	int sum = 0;
	for (int i = 0; i < array.length; i++) {
	    if (array[i] % k == 0) {
		sum += array[i];
	    }
	}
	return sum;
    }

    private static void printArray(int[] array) {
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + " ");
	}
    }
}