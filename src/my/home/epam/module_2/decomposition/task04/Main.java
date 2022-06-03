package my.home.epam.module_2.decomposition.task04;

import java.util.Random;
import java.util.Scanner;

/*
 * Задача 4. На плоскости заданы своими координатами n точек. Написать метод (методы), определяющие, 
 * между какими из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
 */

public class Main {

    public static void main(String[] args) {
	int n;
	int[][] coords;

	n = console("Введите количество точек: ");

	System.out.println();

	coords = new int[n][2];

	initCoords(coords);

	printCoords("Координаты точек:", coords);
	System.out.println();

	findAndPrintResult(coords);
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
	} while (number < 3);

	return number;
    }

    private static void initCoords(int[][] coords) {
	Random random = new Random();

	for (int i = 0; i < coords.length; i++) {
	    for (int j = 0; j < coords[i].length; j++) {
		coords[i][j] = random.nextInt(-9, 10);
	    }
	}
    }

    private static void printCoords(String message, int[][] coords) {
	System.out.println(message);

	for (int i = 0; i < coords.length; i++) {
	    for (int j = 0; j < coords[i].length; j++) {
		System.out.printf("%2d ", coords[i][j]);
	    }
	    System.out.println();
	}
    }

    private static void findAndPrintResult(int[][] coords) {
	double maxDist = 0;
	int pointOneX = 0;
	int pointTwoX = 0;
	int[][] pointsWithMaxDist = new int[2][2];

	for (int i = 0; i < coords.length; i++) {
	    for (int ii = 0; ii < coords[i].length; ii++) {
		double distX = Math.abs(coords[i][0] - coords[ii][0]);
		double distY = Math.abs(coords[i][1] - coords[ii][1]);
		double dist = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
		if (dist > maxDist) {
		    maxDist = dist;
		    pointOneX = i;
		    pointTwoX = ii;
		}
	    }
	}
	pointsWithMaxDist[0][0] = coords[pointOneX][0];
	pointsWithMaxDist[0][1] = coords[pointOneX][1];
	pointsWithMaxDist[1][0] = coords[pointTwoX][0];
	pointsWithMaxDist[1][1] = coords[pointTwoX][1];

	System.out.println("Наибольшее расстояние - между точками [" + pointsWithMaxDist[0][0] + ", " + pointsWithMaxDist[0][1] + "] и [" + pointsWithMaxDist[1][0] + ", "
		+ pointsWithMaxDist[1][1] + "]");
	System.out.println("Расстояние = " + maxDist);
    }
}