package my.home.epam.module_2.decomposition.task08;

import java.util.Arrays;
import java.util.Random;

/*
 * Задача 8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 * Пояснение. Составить метод (методы) для вычисления суммы трех последовательно расположенных элементов массива с номерами от k до m.
 */

public class Main {

    public static void main(String[] args) {
	int n = 6;
	int[] array = new int[n];
	int k1 = 1;
	int k2 = 3;
	int k3 = 4;

	initArray(array);
	
	System.out.println("Массив D: " + Arrays.toString(array));
	System.out.println();
	
	sumOfThreeElem(array, k1);
	sumOfThreeElem(array, k2);
	sumOfThreeElem(array, k3);
    }
    
    private static void initArray(int[] array) {
	Random random = new Random();
	
	for (int i = 0; i < array.length; i++) {
	    array[i] = random.nextInt(10);
	}
    }
    
    private static void sumOfThreeElem(int[] array, int k) {
	int sum = array[k - 1] + array[(k - 1) + 1] + array[(k - 1) + 2];
	System.out.println("D[" + ((k - 1) + 1) + "] + D[" + ((k - 1) + 2) + "] + D[" + ((k - 1) + 3) + "] = " + sum);
    }
}