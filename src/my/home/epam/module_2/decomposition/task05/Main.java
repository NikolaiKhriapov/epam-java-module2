package my.home.epam.module_2.decomposition.task05;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести 
 * на печать число, которое меньше максимального элемента массива, но больше всех других элементов).
 */

public class Main {

    public static void main(String[] args) {
	int n = 8;
	int[] array = new int[n];
	int secondMaxElem;

	initArray(array);

	System.out.println("Массив: " + Arrays.toString(array));

	secondMaxElem = findSecondMaxElem(array);

	System.out.println();
	System.out.println("Второе по величине число: " + secondMaxElem);
    }

    private static void initArray(int[] array) {
	Random random = new Random();

	for (int i = 0; i < array.length; i++) {
	    array[i] = random.nextInt(10);
	}
    }

    private static int findSecondMaxElem(int[] array) {
	int maxElem = array[0];
	int secondMaxElem;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] > maxElem) {
		maxElem = array[i];
	    }
	}

	for (int i = 0; i < array.length; i++) {
	    if (array[i] == maxElem) {
		array[i] = 0;
	    }
	}

	secondMaxElem = array[0];

	for (int i = 0; i < array.length; i++) {
	    if (array[i] > secondMaxElem) {
		secondMaxElem = array[i];
	    }
	}

	return secondMaxElem;
    }
}