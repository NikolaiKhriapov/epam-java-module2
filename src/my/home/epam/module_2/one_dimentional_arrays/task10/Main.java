package my.home.epam.module_2.one_dimentional_arrays.task10;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 10. Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из него каждый второй элемент 
 * (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */

public class Main {

    public static void main(String[] args) {
	int n = 10;
	int[] array = new int[n];

	initArray(array);

	System.out.println("Массив: " + Arrays.toString(array));

	changeArray(array);

	System.out.println();
	System.out.println("Результат: " + Arrays.toString(array));
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

    private static void changeArray(int[] array) {
	for (int i = 1; i < array.length; i += 2) {
	    array[i] = 0;
	}
    }
}