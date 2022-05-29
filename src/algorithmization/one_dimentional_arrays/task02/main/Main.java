package algorithmization.one_dimentional_arrays.task02.main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Задача 2. Дана последовательность действительных чисел а1, а2, ..., аn. Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
 */

public class Main {

    public static void main(String[] args) {
	int n = 10;
	int z;
	int[] array = new int[n];
	int replaced;

	initArray(array);
	System.out.println("Последовательность чисел: " + Arrays.toString(array));

	z = console("Введите число z: ");
	System.out.println();

	replaced = replaceNumbersOverZ(array, z);

	System.out.println("Последовательность чисел: " + Arrays.toString(array));
	System.out.println("Количество замен: " + replaced);
    }

    private static void initArray(int[] array) {
	if (array == null) {
	    return;
	}

	Random random = new Random();

	for (int i = 0; i < array.length; i++) {
	    array[i] = random.nextInt(10);
	}
    }

    private static int console(String message) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.print(message);
	while (!scanner.hasNextInt()) {
	    scanner.next();
	    System.out.print(message);
	}
	return Integer.parseInt(scanner.next());
    }

    private static int replaceNumbersOverZ(int[] array, int z) {
	int count = 0;
	for (int i = 0; i < array.length; i++) {
	    if (array[i] > z) {
		array[i] = z;
		count++;
	    }
	}
	return count;
    }
}