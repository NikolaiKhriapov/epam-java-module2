package my.home.epam.module_2.sorts.task01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
 * Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого, 
 * при этом не используя дополнительный массив.
 */

public class Main {

    public static void main(String[] args) {
	int length1;
	int length2;
	int k;

	length1 = consoleLength("Введите размер массива 1: ");
	length2 = consoleLength("Введите размер массива 2: ");
	k = consoleK("Введите число k: ", length1);

	int[] array1 = new int[length1];
	int[] array2 = new int[length2];
	int[] resultArray;

	array1 = initArray(array1);
	array2 = initArray(array2);
	resultArray = findResultArray(array1, array2, k);

	System.out.println();
	System.out.println("Массив 1: " + Arrays.toString(array1));
	System.out.println("Массив 2: " + Arrays.toString(array2));
	System.out.println();
	System.out.println("Результат: " + Arrays.toString(resultArray));
    }

    private static int consoleLength(String message) {
	int number;

	do {
	    @SuppressWarnings("resource")
	    Scanner console = new Scanner(System.in);

	    System.out.print(message);
	    while (!console.hasNextInt()) {
		console.next();
		System.out.print(message);
	    }
	    number = Integer.parseInt(console.next());
	} while (number < 2);

	return number;
    }

    private static int consoleK(String message, int length) {
	int number;

	do {
	    @SuppressWarnings("resource")
	    Scanner console = new Scanner(System.in);

	    System.out.print(message);
	    while (!console.hasNextInt()) {
		console.next();
		System.out.print(message);
	    }
	    number = Integer.parseInt(console.next());
	} while ((number < 1) || (number > length - 1));

	return number;
    }

    private static int[] initArray(int[] array) {
	Random random = new Random();

	for (int i = 0; i < array.length; i++) {
	    array[i] = random.nextInt(10);
	}
	return array;
    }

    private static int[] findResultArray(int[] array1, int[] array2, int k) {
	int[] resultArray = new int[array1.length + array2.length];

	for (int i = 0; i < k; i++) { // первая часть первого массива
	    resultArray[i] = array1[i];
	}

	for (int i = k; i < array2.length + k; i++) { // второй массив
	    resultArray[i] = array2[i - k];
	}

	for (int i = k + array2.length; i < resultArray.length; i++) { // вторая часть первого массива
	    resultArray[i] = array1[i - array2.length];
	}

	return resultArray;
    }
}