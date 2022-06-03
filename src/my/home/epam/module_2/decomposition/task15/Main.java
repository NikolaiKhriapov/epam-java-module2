package my.home.epam.module_2.decomposition.task15;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность (например, 1234, 5789). 
 * Для решения задачи использовать декомпозицию.
 */

public class Main {

    public static void main(String[] args) {
	int n;
	int[] array = new int[20];

	n = console("Введите число n: ");

	array = initArray(array, n);

	System.out.println();
	System.out.println("Числа: " + Arrays.toString(array));
	System.out.println();

	printAscNumbers("Результат: ", array);
    }

    private static int console(String message) {
	int nMin = 2;
	int nMax = countOfDigits(Integer.MAX_VALUE);

	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.print(message);
	while (!scanner.hasNextInt()) {
	    System.out.print(message);
	    scanner.next();
	}

	int number = Integer.parseInt(scanner.next());

	while (!((number >= nMin) && (number <= nMax))) {
	    if (number <= nMax) {
		System.out.println("n не может быть меньше 2");
	    } else if (number >= nMin) {
		System.out.println("Пожалуйста, введите число, не превышающее 10, а лучше - 4 :)");
	    }
	    number = console("Введите число n: ");
	}

	return number;
    }

    private static int countOfDigits(int number) {
	int countOfDigits = 0;
	while (!(number < 1)) {
	    number /= 10;
	    countOfDigits++;
	}
	return countOfDigits;
    }

    private static int[] initArray(int[] array, int numberOfDigits) {
	Random random = new Random();

	for (int i = 0; i < array.length; i++) {
	    array[i] = (int) (random.nextDouble(1, 10) * Math.pow(10, numberOfDigits - 1));
	}
	return array;
    }

    private static void printAscNumbers(String message, int[] array) {
	int[] tempArray = new int[array.length];

	System.out.print(message);
	for (int i = 0; i < array.length; i++) {
	    if (isAsc(array[i])) {
		tempArray[i] = array[i];
	    }
	}

	int tempSum = 0;
	for (int i = 0; i < array.length; i++) {
	    tempSum += tempArray[i];
	    if (tempArray[i] != 0) {
		System.out.print(tempArray[i] + " ");
	    }
	}

	if (tempSum == 0) {
	    System.out.println("Чисел, соответстующих условию задачи, нет.");
	}
    }

    private static boolean isAsc(int number) {
	int countOfDigits = countOfDigits(number);
	int[] array = new int[countOfDigits];

	for (int i = 0; i < array.length; i++) {
	    array[i] = number % 10;
	    number /= 10;
	}

	for (int i = 0; i < array.length - 1; i++) {
	    while (!(array[i] > array[i + 1])) {
		return false;
	    }
	}
	return true;
    }
}