package my.home.epam.module_2.sorts.task02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 2. Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей.
 * Примечание. Дополнительный массив не использовать.
 */

public class Main {

    public static void main(String[] args) {
	int n;
	int m;

	n = console("Введите число n: ");
	m = console("Введите число m: ");

	int[] numbers1 = new int[n];
	int[] numbers2 = new int[m];
	int[] resultNumbers;

	numbers1 = initNumbers(numbers1);
	numbers2 = initNumbers(numbers2);
	resultNumbers = findResultNumbers(numbers1, numbers2);

	System.out.println();
	System.out.println("Последовательность 1:" + Arrays.toString(numbers1));
	System.out.println("Последовательность 2:" + Arrays.toString(numbers2));
	System.out.println();
	System.out.println("Результат: " + Arrays.toString(resultNumbers));
    }

    private static int console(String message) {
	int number;

	do {
	    @SuppressWarnings("resource")
	    Scanner console = new Scanner(System.in);

	    System.out.print(message);
	    while (!console.hasNextInt()) {
		System.out.print(message);
		console.next();
	    }
	    number = Integer.parseInt(console.next());
	} while (number <= 2);
	return number;
    }

    private static int[] initNumbers(int[] numbers) {
	Random random = new Random();

	int minNumber = Integer.MIN_VALUE;
	for (int i = 0; i < numbers.length; i++) {
	    numbers[i] = random.nextInt(10);
	    while (!(numbers[i] >= minNumber)) {
		numbers[i] = random.nextInt(10);
	    }
	    minNumber = numbers[i];
	}
	return numbers;
    }

    private static int[] findResultNumbers(int[] numbers1, int[] numbers2) {
	int[] resultNumbers = new int[numbers1.length + numbers2.length];

	for (int i = 0; i < numbers1.length; i++) { // добавляем последовательность 1 в новую последовательность
	    resultNumbers[i] = numbers1[i];
	}

	for (int i = numbers1.length; i < resultNumbers.length; i++) { // добавляем последовательность 2 в новую последовательность
	    resultNumbers[i] = numbers2[i - numbers1.length];
	}

	for (int i = 0; i < resultNumbers.length; i++) { // сортируем элементы новой последовательности по возрастанию
	    for (int j = 0; j < resultNumbers.length - 1; j++) {
		if (resultNumbers[j] >= resultNumbers[j + 1]) {
		    resultNumbers[j] = resultNumbers[j] + resultNumbers[j + 1];
		    resultNumbers[j + 1] = resultNumbers[j] - resultNumbers[j + 1];
		    resultNumbers[j] = resultNumbers[j] - resultNumbers[j + 1];
		}
	    }
	}

	return resultNumbers;
    }
}