package my.home.epam.module_2.sorts.task03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 3. Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ... <= an. Требуется переставить элементы так, чтобы они 
 * были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое место, 
 * а первый - на место наибольшего. Затем, начиная со второго, эта процедура повторяется. Написать алгоритм сортировки выбором.
 */

public class Main {

    public static void main(String[] args) {
	int n;

	n = console("Введите число n: ");

	int[] numbers = new int[n];
	int[] sortedNumbers;

	numbers = initNumbers(numbers);
	System.out.println("Последовательность чисел: " + Arrays.toString(numbers));
	System.out.println();

	sortedNumbers = selectionSort(numbers);
	System.out.println("Результат сортировки выбором: " + Arrays.toString(sortedNumbers));
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
	} while (number < 2);

	return number;
    }

    private static int[] initNumbers(int[] numbers) {
	Random random = new Random();

	int minNumber = Integer.MIN_VALUE;
	for (int i = 0; i < numbers.length; i++) {
	    numbers[i] = random.nextInt(20);
	    while (!(numbers[i] >= minNumber)) {
		numbers[i] = random.nextInt(20);
	    }
	    minNumber = numbers[i];
	}
	return numbers;
    }

    private static int[] selectionSort(int[] numbers) {
	for (int i = 0; i < numbers.length - 1; i++) {
	    for (int j = i + 1; j < numbers.length; j++) {
		int maxNumber = numbers[i];
		if (numbers[j] >= numbers[i]) {
		    maxNumber = numbers[j];
		    numbers[j] = numbers[i];
		    numbers[i] = maxNumber;
		}
	    }
	}
	return numbers;
    }
}