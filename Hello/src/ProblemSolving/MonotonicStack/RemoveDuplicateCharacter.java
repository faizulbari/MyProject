package ProblemSolving.MonotonicStack;

import java.util.Stack;

public class RemoveDuplicateCharacter {

    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26]; // Frequency of each character
        boolean[] inStack = new boolean[26]; // To track if a character is in the stack
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            freq[c - 'a']--; // Decrease frequency as character is processed
            if (inStack[c - 'a']) continue; // Skip if character is already in stack

            // Remove characters from the stack if they are greater than the current character
            // and can appear later (frequency > 0)
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            inStack[c - 'a'] = true;
        }

        // Build the result from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String arg[])
    {
        RemoveDuplicateCharacter rm = new RemoveDuplicateCharacter();

        System.out.println(rm.removeDuplicateLetters("bcabc"));   // output : abc

        System.out.println(rm.removeDuplicateLetters("cbacdcbc"));   // output : acdb

        System.out.println(rm.removeDuplicateLetters("cbbaa"));   // output : cba
    }

}
