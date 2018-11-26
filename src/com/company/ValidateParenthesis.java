package com.company;

import java.util.HashMap;
import java.util.Stack;

public class ValidateParenthesis {
    public static void main(String[] args) {
        System.out.println(validateParenthesis("abc(){return hello[i]==true}"));
        System.out.println(validateParenthesis("abc({return hello[i]==true})"));
    }
    public static boolean validateParenthesis(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> openParenthesis = new Stack<Character>();
        HashMap<Character, Character> openParenthesisPairs = new HashMap<Character, Character>();
        openParenthesisPairs.put('{', '}');
        openParenthesisPairs.put('(', ')');
        openParenthesisPairs.put('[', ']');
        HashMap<Character, Character> closeParenthesisPairs = new HashMap<Character, Character>();
        closeParenthesisPairs.put('}', '{');
        closeParenthesisPairs.put(')', '(');
        closeParenthesisPairs.put(']', '[');
        for (int i = 0; i < chars.length; i++) {
            Character close = openParenthesisPairs.get(chars[i]);
            if (close != null) {
                openParenthesis.push(chars[i]);
            }
            else {
                Character open = closeParenthesisPairs.get(chars[i]);
                if (open != null && openParenthesis.pop() != open) {
                    return false;
                }
            }
        }
        return openParenthesis.isEmpty();
    }
}
