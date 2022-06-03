package my.home.epam.module_2.one_dimentional_arrays.task09;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. 
 * Если таких чисел несколько, то определить наименьшее из них.
 */

public class Main {

    public static void main(String[] args) {
	int n = 10;
	int[] array = new int[n];
	int resultNumber;

	initArray(array);

	System.out.println("Массив целых чисел: " + Arrays.toString(array));

	resultNumber = findResultNumber(array);

	System.out.println();
	System.out.print("Результат: " + resultNumber);
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

    private static int findResultNumber(int[] array) {
	int count = 0;
	int countMax = 0;
	int iMin = 0;
	int resultNumber = 0;

	for (int i = 0; i < array.length; i++) {
	    for (int j = i; j < array.length; j++) {
		if (array[i] == array[j]) {
		    count++;
		}
	    }

	    if (count >= countMax) {
		if (count > countMax) {
		    iMin = i;
		} else if (count == countMax) {
		    if (array[i] < array[iMin]) {
			resultNumber = array[i];
			iMin = i;
		    }
		}
		resultNumber = array[iMin];
		countMax = count;
	    }
	    count = 0;
	}
	return resultNumber;
    }
}