package my.home.epam.module_2.decomposition.task13;

import java.util.Scanner;

/*
 * Задача 13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43). 
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. 
 * Для решения задачи использовать декомпозицию.
 */

public class Main {

    public static void main(String[] args) {
	int n;
	int[][] twins;

	n = console("Введите число n: ");

	twins = new int[n - 1][2];

	twins = findTwins(twins, n);

	System.out.println();

	printTwins("\"Близнецы\" на отрезке [" + n + "," + 2 * n + "]:", twins);
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
	} while (number <= 2);
	
	return number;
    }

    private static int[][] findTwins(int[][] array, int n) {
	for (int i = 0; i < array.length; i++) {
	    array[i][0] = (n + i);
	    array[i][1] = (n + i) + 2;
	}
	return array;
    }

    private static void printTwins(String message, int[][] array) {
	System.out.println(message);

	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		System.out.printf("%3d ", array[i][j]);
	    }
	    System.out.println();
	}
    }
}