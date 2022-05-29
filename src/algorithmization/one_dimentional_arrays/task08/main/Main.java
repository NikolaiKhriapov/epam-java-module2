package algorithmization.one_dimentional_arrays.task08.main;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 8. Дана последовательность целых чисел a1, a2, ..., an. Образовать новую последовательность, 
 * выбросив из исходной те члены, которые равны min(a1, a2, ..., an).
 */

public class Main {

    public static void main(String[] args) {
	int n = 10;
	int[] a = new int[n];
	int[] newArray;

	initArray(a);

	System.out.println("Последовательность чисел: " + Arrays.toString(a));

	newArray = newArray(a);

	System.out.println();
	System.out.println("Результат: " + Arrays.toString(newArray));
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

    private static int[] newArray(int[] array) {
	int minElem = array[0];
	for (int i = 0; i < array.length; i++) {
	    if (array[i] < minElem) {
		minElem = array[i];
	    }
	}

	int numOfMinElem = 0;
	for (int i = 0; i < array.length; i++) {
	    if (array[i] == minElem) {
		numOfMinElem++;
	    }
	}

	int[] arrayNew = new int[array.length - numOfMinElem];
	int arrayNewIndex = 0;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] != minElem) {
		arrayNew[arrayNewIndex] = array[i];
		arrayNewIndex++;
	    }
	}

	return arrayNew;
    }
}