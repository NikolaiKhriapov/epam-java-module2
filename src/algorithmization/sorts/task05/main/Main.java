package algorithmization.sorts.task05.main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 5. Сортировка вставками. Дана последовательность чисел a1, a2, ..., an. Требуется переставить числа в порядке возрастания. 
 * Делается это следующим образом. Пусть a1, a2, ..., ai - упорядоченная последовательность, т.е. a1 <= a2 <= ... <= an. Берется 
 * следующее число i+1 a и вставляется в последовательность так, чтобы новая последовательность была тоже возрастающей. Процесс 
 * производится до тех пор, пока все элементы от i +1 до n не будут перебраны. Примечание. Место помещения очередного элемента в 
 * отсортированную часть производить с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
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

	sortedNumbers = binaryInsertionSort(numbers);
	System.out.println("Результат сортировки вставками: " + Arrays.toString(sortedNumbers));
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

    private static int[] binaryInsertionSort(int[] numbers) {
	for (int i = 1; i < numbers.length; i++) {
	    int number = numbers[i];
	    int insertionPosition = binarySearch(numbers, 0, i - 1, number);

	    for (int j = i - 1; j >= insertionPosition; j--) {
		numbers[j + 1] = numbers[j];
	    }
	    numbers[insertionPosition] = number;
	}
	return numbers;
    }

    private static int binarySearch(int[] numbers, int left, int right, int number) {
	while (left <= right) {
	    int mid = (left + right) / 2;

	    if (number == numbers[mid]) {
		return mid;
	    }

	    if (number < numbers[mid]) {
		right = mid - 1;
	    }

	    if (number > numbers[mid]) {
		left = mid + 1;
	    }
	}
	return left;
    }
}