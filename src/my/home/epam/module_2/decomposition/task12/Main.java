package my.home.epam.module_2.decomposition.task12;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 12. Даны натуральные числа К и N. Написать метод (методы) формирования массива А, 
 * элементами которого являются числа, сумма цифр которых равна К и которые не больше N.
 */

public class Main {

    public static void main(String[] args) {
	int numberK;
	int numberN;
	int[] array = new int[6];

	do {
	    numberK = console("Введите число K: ");
	} while (numberK < 1);

	do {
	    numberN = console("Введите число N: ");
	} while (numberN < numberK);

	initArray(array, numberK, numberN);

	System.out.println();
	System.out.println("Массив А: " + Arrays.toString(array));
    }

    private static int console(String message) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.print(message);
	while (!scanner.hasNextInt()) {
	    System.out.print(message);
	    scanner.next();
	}
	return Integer.parseInt(scanner.next());
    }

    private static void initArray(int[] array, int numberK, int numberN) {
	Random random = new Random();
	for (int i = 0; i < array.length; i++) {
	    while (!(sumOfDigits(array[i]) == numberK)) {
		array[i] = random.nextInt(numberN + 1);
	    }
	}
    }

    private static int sumOfDigits(int number) {
	int count = 0;
	int[] arrayOfDigits;
	int tempNumber = number;
	int sumOfDigits = 0;

	while (!(tempNumber < 1)) {
	    tempNumber /= 10;
	    count++;
	}

	arrayOfDigits = new int[count];

	for (int i = 0; i < arrayOfDigits.length; i++) {
	    arrayOfDigits[i] = number % 10;
	    sumOfDigits += arrayOfDigits[i];
	    number /= 10;
	}

	return sumOfDigits;
    }
}