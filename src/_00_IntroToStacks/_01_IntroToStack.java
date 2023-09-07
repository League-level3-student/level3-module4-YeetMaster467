package _00_IntroToStacks;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


public class _01_IntroToStack {
    public static void main(String[] args) {
        program();
    }
    
    public static void program() {
    	
    	Random r = new Random();
    	Scanner s = new Scanner(System.in);
    	// 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	
    	Stack<Double> doubles = new Stack<Double>();

        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	
    	for (int i = 0; i < 100; i++) {
    		doubles.push(r.nextDouble(100));
    	}
    	
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    	System.out.println("Enter two numbers between 1 and 100 seperated by a comma.");
    	String input = s.nextLine();
    	input.replaceAll("[^1234567890,]", "");
    	if ( !input.contains(",") || input == null ) {
    		System.out.println("You must have two numbers seperated by a comma!");
    		System.out.println(" ");
    		program();
    		return;
    	}
    	String[] arr = input.split(",");
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
    	int num1 = 0;
    	int num2 = 0;
    	try {
    		num1 = Integer.parseInt(arr[0]);
        	num2 = Integer.parseInt(arr[1]);
		} catch (Exception e) {
			System.out.println("You must have two numbers SEPERATED by a comma!");
    		System.out.println(" ");
    		program();
    		return;
		}
    	
    	double topOfStack;
    	System.out.println("Popping all elements off stack...\nElements between " + num1 + " and " + num2 + ":");
    	
    	for (int i = num1; i < num2 && !doubles.isEmpty(); i++) {
    		topOfStack = doubles.pop();
    		if (topOfStack >= num1 && topOfStack <= num2) {
    			System.out.println(topOfStack);
    		}
		}
    	
        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
	}
}
