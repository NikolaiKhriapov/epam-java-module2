package my.home.epam.module_2.decomposition.task14;

import java.util.Scanner;

/*
 * Задача 14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, возведенная 
 * в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.
 */

public class Main {

    public static void main(String[] args) {
	int k;

	k = console("Введите число k: ");

	System.out.println();

	printNarcissisticNumbers(k);
    }

    private static int console(String message) {
	int number;

	do {
	    @SuppressWarnings("resource")
	    Scanner scanner = new Scanner(System.in);

	    System.out.print(message);
	    while (!scanner.hasNextInt()) {
		System.out.print(message);
		scanner.next();
	    }
	    number = Integer.parseInt(scanner.next());
	} while (number < 1);

	return number;
    }

    private static void printNarcissisticNumbers(int limit) {
	System.out.print("Числа Армстронга от 1 до " + limit + ": ");
	for (int i = 1; i <= limit; i++) {
	    if (isNarcissisticNumber(i)) {
		System.out.print(i + " ");
	    }
	}
    }

    private static boolean isNarcissisticNumber(int number) {
	if (number == sumOfDigitsToThePowerOfCount(number)) {
	    return true;
	} else {
	    return false;
	}
    }

    private static int sumOfDigitsToThePowerOfCount(int number) {
	int tempNumber = number;
	int countOfDigits = 0;
	int[] digits;
	int sumOfDigitsCubes = 0;

	while (!(tempNumber < 1)) {
	    tempNumber /= 10;
	    countOfDigits++;
	}

	digits = new int[countOfDigits];

	for (int i = 0; i < digits.length; i++) {
	    digits[i] = number % 10;
	    sumOfDigitsCubes += Math.pow(digits[i], countOfDigits);
	    number /= 10;
	}

	return sumOfDigitsCubes;
    }
}