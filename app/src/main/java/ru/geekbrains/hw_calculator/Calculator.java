package ru.geekbrains.hw_calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> number = new ArrayList<>();
    private List<String> token = new ArrayList<>();
    private String conclusion = "";
    private int equality = 0;

    public void calculate(String str) {
        switch (str) {
            case "1":
                collectionNumber(str);
                break;
            case "2":
                collectionNumber(str);
                break;
            case "3":
                collectionNumber(str);
                break;
            case "4":
                collectionNumber(str);
                break;
            case "5":
                collectionNumber(str);
                break;
            case "6":
                collectionNumber(str);
                break;
            case "7":
                collectionNumber(str);
                break;
            case "8":
                collectionNumber(str);
                break;
            case "9":
                collectionNumber(str);
                break;
            case "0":
                collectionNumber(str);
                break;
            case "+":
                saveNumder();
                saveToken(str);
                break;
            case "-":
                saveNumder();
                saveToken(str);
                break;
            case "*":
                saveNumder();
                saveToken(str);
                break;
            case "/":
                saveNumder();
                saveToken(str);
                break;
            case "=":
                saveNumder();
                break;
            case "":
                number.clear();
                token.clear();
                conclusion = "";
                equality = 0;
        }
    }

    private void collectionNumber(String str) {
        conclusion = conclusion + str;
    }

    private void saveNumder() {
        number.add(conclusion);
        conclusion = "";
    }

    private void saveToken(String str) {
        token.add(str);
    }

    private void compute() {
        equality = Integer.parseInt(number.get(0));
        for (int i = 1; i < number.size(); i++) {
            if (token.get(i - 1).equals("/")) {
                equality = equality / Integer.parseInt(number.get(i));
            } else if (token.get(i - 1).equals("*")) {
                equality = equality * Integer.parseInt(number.get(i));
            } else if (token.get(i - 1).equals("+")) {
                equality = equality + Integer.parseInt(number.get(i));
            } else if (token.get(i - 1).equals("-")) {
                equality = equality - Integer.parseInt(number.get(i));
            }
        }

        number.clear();
        token.clear();

        conclusion = String.valueOf(equality);
    }

    public String answer() {
        compute();
        return String.valueOf(equality);
    }
}
