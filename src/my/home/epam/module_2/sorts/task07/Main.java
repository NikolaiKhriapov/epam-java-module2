package my.home.epam.module_2.sorts.task07;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 7. Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm. 
 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= ... <= bm в первую 
 * последовательность так, чтобы новая последовательность оставалась возрастающей.
 */

public class Main {

    public static void main(String[] args) {
	int n = console("Введите число n: ");
	int m = console("Введите число m: ");

	int[] numbers1 = new int[n];
	int[] numbers2 = new int[m];

	numbers1 = initNumbers(numbers1);
	numbers2 = initNumbers(numbers2);

	System.out.println();
	System.out.println("Последовательность чисел 1: " + Arrays.toString(numbers1));
	System.out.println("Последовательность чисел 2: " + Arrays.toString(numbers2));
	System.out.println();

	showPosition(numbers1, numbers2);
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

	for (int i = 0; i < numbers.length; i++) {
	    numbers[i] = random.nextInt(20);
	}

	for (int i = 0; i < numbers.length - 1; i++) {
	    for (int j = i + 1; j < numbers.length; j++) {
		if (numbers[i] > numbers[j]) {
		    int temp = numbers[i];
		    numbers[i] = numbers[j];
		    numbers[j] = temp;
		}
	    }
	}

	return numbers;
    }

    private static void showPosition(int[] numbers1, int[] numbers2) {
	for (int i = 0; i < numbers2.length; i++) {
	    int position = binarySearch(numbers1, numbers2[i]);

	    if (position == 0) {
		System.out.println("Элемент " + numbers2[i] + " необходимо вставить в начало последовательности 1");
	    } else if (position == (numbers1.length)) {
		System.out.println("Элемент " + numbers2[i] + " необходимо вставить в конец последовательности 1");
	    } else {
		System.out.println("Элемент " + numbers2[i] + " необходимо вставить между элементами " + numbers1[position - 1] + " и " + numbers1[position]);
	    }
	}
    }

    private static int binarySearch(int[] numbers, int number) {
	int left = 0;
	int right = numbers.length - 1;

	while (left <= right) {
	    int mid = (left + right) / 2;

	    if (number == numbers[mid]) {
		return mid;
	    } else if (number < numbers[mid]) {
		right = mid - 1;
	    } else if (number > numbers[mid]) {
		left = mid + 1;
	    }
	}
	return left;
    }
}