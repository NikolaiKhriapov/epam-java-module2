package my.home.epam.module_2.sorts.task08;

import java.util.Random;
import java.util.Scanner;

/*
 * Задача 8. Даны дроби p1/q1, p2/q2, ..., pn/qn (pi, qi - натуральные). Составить программу, 
 * которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
 */

public class Main {

    public static void main(String[] args) {
	int n = console("Введите число n: ");

	Fraction[] numbers = new Fraction[n];
	Fraction[] sortedNumbers;

	System.out.println();

	numbers = initNumbers(numbers);
	print("Заданные дроби: ", numbers);

	arrayNok(numbers);

	reductToCommonDenominator(numbers);
	print("Дроби после приведения к общему знаменателю: ", numbers);

	System.out.println();

	sortedNumbers = sortNumbers(numbers);
	print("Результат: ", sortedNumbers);
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
	} while (number < 2);

	return number;
    }

    private static Fraction[] initNumbers(Fraction[] numbers) {
	Random random = new Random();

	for (int i = 0; i < numbers.length; i++) {
	    numbers[i] = new Fraction();
	    numbers[i].numerator = random.nextInt(1, 10);
	    numbers[i].denominator = random.nextInt(1, 10);
	}

	return numbers;
    }

    private static void print(String message, Fraction[] numbers) {
	System.out.print(message);

	for (int i = 0; i < numbers.length; i++) {
	    System.out.print(numbers[i].numerator + "/" + numbers[i].denominator + " ");
	}
	System.out.println();
    }

    private static void reductToCommonDenominator(Fraction[] numbers) {
	for (int i = 0; i < numbers.length; i++) {
	    int koefficient = arrayNok(numbers) / numbers[i].denominator;
	    numbers[i].numerator *= koefficient;
	    numbers[i].denominator = arrayNok(numbers);
	}
    }

    private static int arrayNok(Fraction[] numbers) {

	// создаем массив, элементами которого являются знаменатели
	int[] denominators = new int[numbers.length];
	for (int i = 0; i < numbers.length; i++) {
	    denominators[i] = numbers[i].denominator;
	}

	// находим минимальный элемент массива знаменателей
	int minNumber = Integer.MAX_VALUE;
	for (int i = 0; i < denominators.length; i++) {
	    if (denominators[i] < minNumber) {
		minNumber = denominators[i];
	    }
	}

	// находим НОД элементов массива знаменателей
	int arrayNod = nod(denominators[0], denominators[1]);
	for (int i = 1; i < denominators.length - 1; i++) {
	    arrayNod = nod(arrayNod, denominators[i + 1]);
	}

	// находим НОК элементов массива знаменателей
	int arrayNok = nok(denominators[0], denominators[1]);
	for (int i = 1; i < denominators.length - 1; i++) {
	    arrayNok = nok(arrayNok, denominators[i + 1]);
	}

	return arrayNok;
    }

    private static int nod(int number1, int number2) {
	int minNumber = Math.min(number1, number2);

	int nod = 1;
	for (int i = minNumber; i > 0; i--) {
	    if ((number1 % i == 0) && (number2 % i == 0)) {
		nod = i;
		break;
	    }
	}
	return nod;
    }

    private static int nok(int number1, int number2) {
	return (number1 * number2) / nod(number1, number2);
    }

    private static Fraction[] sortNumbers(Fraction[] numbers) {
	for (int i = 0; i < numbers.length - 1; i++) {
	    for (int j = i + 1; j < numbers.length; j++) {
		if (numbers[i].numerator > numbers[j].numerator) {
		    int temp = numbers[i].numerator;
		    numbers[i].numerator = numbers[j].numerator;
		    numbers[j].numerator = temp;
		}
	    }
	}
	return numbers;
    }
}

class Fraction {
    public int numerator;
    public int denominator;
}