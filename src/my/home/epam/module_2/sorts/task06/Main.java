package my.home.epam.module_2.sorts.task06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию. 
 * Делается это следующим образом: сравниваются два соседних элемента a(i) и a(i+1). Если a(i) <= a(i+1), то продвигаются на один элемент вперед. 
 * Если a(i) > a(i+1), то производится перестановка и сдвигаются на один элемент назад. Составить алгоритм этой сортировки.
 */

public class Main {

    public static void main(String[] args) {
	int n;

	n = console("Введите число n: ");

	int[] numbers = new int[n];
	int[] sortedNumbers;

	numbers = initNumbers(numbers);
	System.out.println("Массив чисел: " + Arrays.toString(numbers));
	System.out.println();

	sortedNumbers = shellSort(numbers);
	System.out.println("Результат сортировки Шелла: " + Arrays.toString(sortedNumbers));
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

    private static int[] shellSort(int[] numbers) {
	for (int i = 0; i < numbers.length - 1; i++) {
	    while (i >= 0 && numbers[i] > numbers[i + 1]) {
		int temp = numbers[i];
		numbers[i] = numbers[i + 1];
		numbers[i + 1] = temp;
		i--;
	    }
	}
	return numbers;
    }
}