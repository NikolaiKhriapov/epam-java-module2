package my.home.epam.module_2.one_dimentional_arrays.task06;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 6. Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых являются простыми числами.
 */

public class Main {

    public static void main(String[] args) {
	int n = 15;
	int[] array = new int[n];

	initArray(array);

	System.out.println("Последовательность вещественных чисел: " + Arrays.toString(array));
	System.out.println();

	result("Результат: ", array);
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

    private static void result(String message, int[] array) {
	System.out.print(message);

	int sum = 0;

	for (int i = 0; i < array.length; i++) {
	    if (checkSimple(i) == true) {
		sum += array[i];
	    }
	}
	System.out.println(sum);
    }

    private static boolean checkSimple(int x) // алгоритм из Википедии
    {
	if (x == 2 || x == 3) {
	    return true;
	}

	if (x <= 1 || x % 2 == 0 || x % 3 == 0) {
	    return false;
	}

	for (int i = 5; Math.pow(i, 2) <= x; i += 6) {
	    if (x % i == 0 || i % (i + 2) == 0) {
		return false;
	    }
	}
	return true;
    }
}