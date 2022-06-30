package my.home.epam.module_2.sorts.task04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 4. Сортировка обменами. Дана последовательность чисел a1 <= a2 <= ... <= an. Требуется переставить числа в порядке возрастания. 
 * Для этого сравниваются два соседних числа a(i) и a(i+1). Если a(i) и a(i+1), то делается перестановка. Так продолжается до тех пор, 
 * пока все элементы не станут расположены в порядке возрастания. Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
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

	sortedNumbers = bubbleSort(numbers);
	System.out.println("Результат сортировки обменами: " + Arrays.toString(sortedNumbers));
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
	return numbers;
    }

    private static int[] bubbleSort(int[] numbers) {
	int count = 0;
	for (int i = 0; i < numbers.length; i++) {
	    for (int j = i + 1; j < numbers.length; j++) {
		if (numbers[i] > numbers[j]) {
		    int temp = numbers[i];
		    numbers[i] = numbers[j];
		    numbers[j] = temp;
		    count++;
		}
	    }
	}
	System.out.println("Количество перестановок: " + count);
	return numbers;
    }
}