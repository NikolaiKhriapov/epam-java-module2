package my.home.epam.module_2.decomposition.task06;

import java.util.Scanner;

/*
 * Задача 6. Написать метод (методы), проверяющий, являются ли данные три числа взаимно простыми.
 */

public class Main {

    public static void main(String[] args) {
	// Целые числа взаимно просты, если их наибольший общий делитель (НОД) равен 1
	
	int number1;
	int number2;
	int number3;
	
	number1 = console("Введите число 1: ");
	number2 = console("Введите число 2: ");
	number3 = console("Введите число 2: ");
	
	System.out.println();
	
	checkCondition(number1, number2, number3);
    }

    private static int console(String message) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	
	System.out.print(message);
	while (!scanner.hasNextInt()) {
	    System.out.print(message);
	    scanner.next();
	}
	return scanner.nextInt();
    }

    private static void checkCondition(int number1, int number2, int number3) {
	int minNumber;
	int nod = 1;
	minNumber = Math.min(Math.min(number1, number2), Math.min(number1, number3));
	
	for (int i = minNumber; i > 0; i--) {
	    if ((number1 % i == 0) && (number2 % i == 0) && (number3 % i == 0)) {
		nod = i;
		break;
	    }
	}
	System.out.println("НОД(" + number1 + "," + number2 + "," + number3 + ") = " + nod);
	
	if (!(nod > 1)) {
	    System.out.println("Следовательно, числа являются взаимно простыми");
	} else {
	    System.out.println("Следовательно, числа не являются взаимно простыми");
	}
    }
}