package scanner;

/*
 * References:
 * 1. Difference between next() and nextLine() : https://www.geeksforgeeks.org/difference-between-next-and-nextline-methods-in-java/
 * 2. nextLine() after nextInt() issue : https://www.freecodecamp.org/news/java-scanner-nextline-call-gets-skipped-solved/#:~:text=nextInt()%20method%20only%20consumes,the%20user%2C%20and%20returns%20immediately.
 * Why above issue happens?:
 * When the user inputs the name and presses enter, scanner.nextLine() consumes the name and 
 * the enter or the newline character at the end. Which means the input buffer is now empty. 
 * Then the scanner.nextInt() prompts the user for their age. The user inputs the age and 
 * presses enter. Unlike the scanner.nextLine() method, the scanner.nextInt() method only consumes 
 * the integer part and leaves the enter or newline character in the input buffer.
 * When the third scanner.nextLine() is called, it finds the enter or newline character 
 * still existing in the input buffer, mistakes it as the input from the user, and returns immediately.
 * 
 * NOTE: new Scanner Object will create new input buffer and hence nextLine() will not solve the issue
 * with another Scanner object input buffer.
 * */

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("What's your name? ");
		String name = scanner.nextLine();

		System.out.printf("So %s. How old are you? ", name);
		int age = scanner.nextInt();
		//solution for nextInt problem is to add extra nextLine() to consume enter or next line
		scanner.nextLine();
		System.out.printf("Cool! %d is a good age to start programming. %nWhat language would you prefer? ", age);
		String language = scanner.nextLine();

		System.out.println();
		System.out.printf("Ah! %s is a solid programming language.", language);
		
		//introduce new Scanner Object
		Scanner sc = new Scanner(System.in);
		System.out.printf("So %s. How old are you? ", name);
		int age2 = sc.nextInt();
		//here again we have to introduce sc.nextLine() as we introduce new Scanner Object.

		System.out.println("In which class do u study?");
		String clas = sc.nextLine();

		System.out.printf("So %s u study in %s class", name, clas);
		scanner.close();
	}
}
