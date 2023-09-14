package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	
    	Stack<Character> brackets = new Stack<Character>();
    	
    	for (int i = 0; i < b.length(); i++) {
    		if (b.charAt(i) == '{') {
    			brackets.push('{');
    		} else if (b.charAt(i) == '}') {
    			if (!brackets.empty()) {
    				brackets.pop();
    			} else {
    				return false;
    			}
    		}
    	}
    	
    	if (brackets.empty()) {
    		return true;
    	}
    	
        return false;
    }
}