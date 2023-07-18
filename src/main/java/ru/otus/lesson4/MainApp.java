package ru.otus.lesson4;

import java.util.Arrays;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("printString: ");
		printString(5, "Hello");
		System.out.println("sumArrayElements: ");
		sumArrayElements(initializeArray((int) (Math.random() * 10 + 1)));
		System.out.println("fillArray: ");
		fillArray(3, initializeArray((int) (Math.random() * 10 + 1)));
		System.out.println("increaseArrayElements: ");
		increaseArrayElements((int) (Math.random() * 10 + 1), initializeArray((int) (Math.random() * 10 + 1)));
		System.out.println("compareArrayElements: ");
		compareArrayElements(initializeArray(8));
		System.out.println("sumArray: ");
		sumArray(initializeArray((int) (Math.random() * 10 + 1)), initializeArray((int) (Math.random() * 10 + 1)), initializeArray((int) (Math.random() * 10 + 1)));
		System.out.println("findPoint: ");
		findPoint(initializeArray((int) (Math.random() * 10 + 1)));
		System.out.println("checkSequence: ");
		checkSequence(Math.random() > 0.5, initializeArray((int) (Math.random() * 10 + 1)));
		System.out.println("reverseArray: ");
		reverseArray(initializeArray((int) (Math.random() * 10 + 1)));
	}

	public static int[] initializeArray(int elementNum) { // Инициализация массива случайными значениями
		int[] randArray = new int[elementNum];
		for (int i = 0; i < elementNum; i++) {
			randArray[i] = (int) (Math.random() * 10 + 1);
		}

		return randArray;
	}

	public static void printArray(int[] arr) { // Вывод массива в консоль
		System.out.println(Arrays.toString(arr));
	}

	public static void printString(int num, String str) { // Вывод строки str в количестве num раз
		for (int i = 0; i < num; i++) {
			System.out.println(str);
		}
	}

	public static void sumArrayElements(int[] arr) { // Сумма элементов массива, которые больше 5
		printArray(arr);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 5) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
	}

	public static void fillArray(int num, int[] arr) { // Заполнение массива числом num
		System.out.println(" State before");
		printArray(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = num;
		}
		System.out.println(" State after");
		printArray(arr);
	}

	public static void increaseArrayElements(int num, int[] arr) { // Увелчиение элементов массива на num
		System.out.println("Num is: " + num);
		System.out.println(" State before");
		printArray(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] += num;
		}
		System.out.println(" State after");
		printArray(arr);
	}

	public static void compareArrayElements(int[] arr) { // Сравнение сумм левой и правой частей массива
		printArray(arr);
		int sumLeft = 0;
		int sumRight = 0;
		for (int i = 0; i < arr.length / 2; i++) {
			sumLeft += arr[i];
		}
		for (int j = arr.length - 1; j >= arr.length / 2; j--) { // При нечетном количестве элементов приоритет большинства будет у правой части
			sumRight += arr[j];
		}
		System.out.println(sumLeft);
		System.out.println(sumRight);
		if (sumLeft > sumRight) {
			System.out.println("Left part of array is more then right");
		} else if (sumLeft < sumRight) {
			System.out.println("Right part of array is more then left");
		} else {
			System.out.println("Left and right parts of array are equals");
		}
	}

	public static void sumArray(int[]... args) { // Получание массива, который равен сумме элементов входящих
		int maxLength = 0;
		System.out.println(" Initialized arrays:");
		for (int i = 0; i < args.length; i++) {
			printArray(args[i]);
			if (maxLength < args[i].length) {
				maxLength = args[i].length;
			}
		}
		int[] newArray = new int[maxLength];
		for (int i = 0; i < args.length; i++) {
			for (int j = 0; j < args[i].length; j++) {
				newArray[j] += args[i][j];
			}
		}
		System.out.println(" New array:");
		printArray(newArray);
	}

	public static void findPoint(int[] arr) { // Проверка наличия точки, в которой суммы левой и правой части массива равны
		printArray(arr);
		int sumLeft;
		int sumRight = 0;
		boolean gotPoint = false;
		for (int i = 1; i < arr.length; i++) {
			sumLeft = 0;
			for (int j = 0; j < i; j++) {
				sumRight = 0;
				sumLeft += arr[j];
				for (int k = j + 1; k < arr.length; k++) {
					sumRight += arr[k];
				}
			}
			if (sumLeft == sumRight) {
				gotPoint = true;
				break;
			}
		}
		System.out.println(gotPoint);
	}

	public static void checkSequence(boolean isAscending, int[] arr) { // Проверка расположения элементов массива по возрастанию/убыванию
		if (isAscending) {
			System.out.println("Ascending");
		} else {
			System.out.println("Descending");
		}
		printArray(arr);
		boolean checkResult = true;
		if (isAscending) {
			for (int i = 1; i < arr.length - 1; i++) {
				if (arr[i] < arr[i - 1] || arr[i] > arr[i + 1]) {
					checkResult = false;
					break;
				}
			}
		} else {
			for (int i = 1; i < arr.length - 1; i++) {
				if (arr[i] > arr[i - 1] || arr[i] < arr[i + 1]) {
					checkResult = false;
					break;
				}
			}
		}
		System.out.println(checkResult);
	}

	public static void reverseArray(int[] arr) { // Вывод "перевернутого" массива
		System.out.println(" Initialized array:");
		printArray(arr);
		int temp = 0;
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}

		System.out.println(" Reversed array:");
		printArray(arr);
	}
}
