package algorithmization.decomposition.task02.main;

import java.util.Scanner;

/*
 * Задача 2. Написать метод (методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */

public class Main {

    public static void main(String[] args) {
	int number1;
	int number2;
	int number3;
	int number4;

	number1 = console("Введите число 1: ");
	number2 = console("Введите число 2: ");
	number3 = console("Введите число 3: ");
	number4 = console("Введите число 4: ");

	System.out.println();

	System.out.println("Наибольший общий делитель: " + nod(number1, number2, number3, number4));
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

    private static int nod(int x1, int x2, int x3, int x4) {
	int result = 1;
	int min = Math.min(Math.min(x1, x2), Math.min(x3, x4));
	for (int i = min; i > 0; i--) {
	    if ((x1 % i == 0) && (x2 % i == 0) && (x3 % i == 0) && (x4 % i == 0)) {
		result = i;
		break;
	    }
	}
	return result;
    }
}