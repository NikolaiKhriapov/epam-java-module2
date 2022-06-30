package my.home.epam.module_2.decomposition.task07;

/*
 * Задача 7. Написать метод (методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 */

public class Main {

    public static void main(String[] args) {
	System.out.println("Сумма факториалов нечетных чисел от 1 до 9 равна " + countSumOfOddFactorials());
    }
    
    private static int factorial(int number) {
	int factorial = 1;
	
	for (int i = 1; i <= number; i++) {
	    factorial *= i;
	}
	
	return factorial;
    }

    private static int countSumOfOddFactorials() {
	int sumOfOddFactorials = 0;
	
	for (int i = 1; i <= 9; i += 2) {
	    sumOfOddFactorials += factorial(i);
	}
	
	return sumOfOddFactorials;
    }
}