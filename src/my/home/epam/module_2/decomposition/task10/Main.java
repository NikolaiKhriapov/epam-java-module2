package my.home.epam.module_2.decomposition.task10;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Задача 10. Дано натуральное число N. Написать метод (методы) для формирования массива, элементами которого являются цифры числа N.
 */

public class Main {

    public static void main(String[] args) {
	int numberN;
	int arrayLength;
	int[] array;

	numberN = console("Введите число N: ");

	arrayLength = countLength(numberN);

	array = new int[arrayLength];

	array = initArray(array, numberN);

	System.out.println();
	System.out.println("Массив: " + Arrays.toString(array));
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
	} while (number <= 0);

	return number;
    }

    private static int countLength(int n) {
	int count = 0;
	int tempN = n;

	while (!(tempN < 1)) {
	    tempN /= 10;
	    count++;
	}
	return count;
    }

    private static int[] initArray(int[] array, int numberN) {
	for (int i = 0; i < array.length; i++) {
	    array[i] = numberN % 10;
	    numberN /= 10;
	}

	int[] resultArray = new int[array.length];
	for (int i = 0; i < resultArray.length; i++) {
	    resultArray[i] = array[(array.length - 1) - i];
	}

	return resultArray;
    }
}