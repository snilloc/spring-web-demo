package com.snilloc.springwebdemo.services;

import java.util.LinkedList;

public class BracketService {


    public static void main(String... args) {
        BracketService test = new BracketService();

        String c = "{{}";
        boolean results = test.check(c);
        System.out.println("Test: " + c + " results: " + results);

        c = "(){}";
        results = test.check(c);
        System.out.println("Test: " + c + " results: " + results);

        /*

        ({()})

        {}(

                [] */

        c = "{({{()}})}";
        results = test.check(c);
        System.out.println("Test: " + c + " results: " + results);
    }

    public BracketService() {
    }

    public boolean check(String brackets) {
        LinkedList<Character> list = new LinkedList();
        Character prevC = null;
        for (Character c : brackets.toCharArray()) {
            System.out.println("prevC: " + prevC + " c: " + c);
            if (prevC != null && getNextChar(c) != null && getNextChar(c) == prevC) {
                list.removeLast(); //.remove();
                if (list.size() == 0) {
                    prevC = null;
                } else {
                    prevC = list.getLast();
                    System.out.println("prevC: " + prevC);
                }
            } else {
                list.add(c);
                prevC = c;
            }
        }

        if (list.size() > 0) {
            System.out.println("size: " + list.size());
            return false;
        } else {
            return true;
        }
    }

    public Character getNextChar(Character c) {
        switch (c) {
            case '{':
                return '}';
            case '}':
                return '{';
            case '[':
                return ']';
            case ']':
                return '[';
            case '(':
                return ')';
            case ')':
                return '(';
            default:
                return null;
        }
    }
}
