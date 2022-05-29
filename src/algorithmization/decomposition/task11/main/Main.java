package algorithmization.decomposition.task11.main;

import java.util.Scanner;

/*
 * Задача 11. Написать метод (методы), определяющий, в каком из данных двух чисел больше цифр.
 */

public class Main {

    public static void main(String[] args) {
	int number1;
	int number2;

	number1 = console("Введите число 1: ");
	number2 = console("Введите число 2: ");

	System.out.println();

	findAndPrintResult(number1, number2);
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

    private static void findAndPrintResult(int number1, int number2) {
	int arrayLength1;
	int arrayLength2;

	arrayLength1 = countLength(number1);
	arrayLength2 = countLength(number2);

	if (arrayLength1 > arrayLength2) {
	    System.out.println("Число 1 содержит больше цифр");
	} else if (arrayLength1 < arrayLength2) {
	    System.out.println("Число 2 содержит больше цифр");
	} else {
	    System.out.println("Числа 1 и 2 содержат одинаковое количество цифр");
	}
    }

    private static int countLength(int number) {
	int countOfElem = 0;
	while (!(number < 1)) {
	    number /= 10;
	    countOfElem++;
	}
	return countOfElem;
    }
}