package my.home.epam.module_2.decomposition.task03;

import java.util.Scanner;

/*
 * Задача 3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.
 */

public class Main {

    public static void main(String[] args) {
	double a = console("Введите значение а: ");

	System.out.println();

	System.out.println("Результат: " + area(a));
    }

    private static double console(String message) {
	double number;

	do {
	    @SuppressWarnings("resource")
	    Scanner scanner = new Scanner(System.in);

	    System.out.print(message);
	    while (!scanner.hasNextDouble()) {
		scanner.next();
		System.out.print(message);
	    }
	    number = Double.parseDouble(scanner.next());
	} while (number < 0);

	return number;
    }

    private static double area(double side) {
	return 3 * Math.sqrt(3) * Math.pow(side, 2) / 2;
    }
}