package my.home.epam.module_2.decomposition.task01;

import java.util.Scanner;

/*
 * Задача 1. Написать метод (методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух натуральных чисел.
 */

public class Main {

    public static void main(String[] args) {
	int number1;
	int number2;

	number1 = console("Введите число 1: ");
	number2 = console("Введите число 2: ");

	System.out.println();

	System.out.println("Наибольший общий делитель: " + nod(number1, number2));
	System.out.println("Наименьшее общее кратное: " + nok(number1, number2));
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

    private static int nod(int x1, int x2) {
	int result = 1;
	int min = x1 < x2 ? x1 : x2;
	for (int i = min; i > 0; i--) {
	    if (x1 % i == 0 && x2 % i == 0) {
		result = i;
		break;
	    }
	}
	return result;
    }

    private static int nok(int x1, int x2) {
	return (x1 * x2) / nod(x1, x2);
    }
}