package my.home.epam.module_2.decomposition.task09;

import java.util.Scanner;

/*
 * Задача 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. 
 * Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y — прямой.
 */

public class Main {

    public static void main(String[] args) {
	double sideX;
	double sideY;
	double sideZ;
	double sideT;

	sideX = console("Введите длину стороны X: ");
	sideY = console("Введите длину стороны Y: ");
	sideZ = console("Введите длину стороны Z: ");
	sideT = console("Введите длину стороны T: ");

	System.out.println();
	System.out.println("Площадь четырехугольника со сторонами X, Y, Z, Т с прямым углом между сторонами X и Y равна "
		+ calculateSquareXYTZ(sideX, sideY, sideZ, sideT));
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
	} while (number <= 0);

	return number;
    }

    private static double calculateSquareXYTZ(double sideX, double sideY, double sideZ, double sideT) {
	double squareXYM;
	double squareMTZ;
	double sideM; // сторона, разделяющая 4-хугольник на треугольники XYM и ZTM
	double p; // полупериметр треугольника MTZ

	squareXYM = (sideX * sideY) / 2;

	sideM = Math.sqrt(Math.pow(sideX, 2) + Math.pow(sideY, 2));
	p = (sideM + sideT + sideZ) * 1.0 / 2;

	squareMTZ = Math.sqrt(p * (p - sideM) * (p - sideT) * (p - sideZ));

	return squareXYM + squareMTZ;
    }
}