package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(double number1, double number2, String math) {
        double result = 0;
        switch (math) {
            case "plus":
                result = plus(number1, number2);
                break;
            case "minus":
                result = minus(number1, number2);
                break;
            case "multiply":
                result = multiply(number1, number2);
                break;
            case "divide":
                if (number2 == 0) {
                    return "Không tính được";
                }
                result = divide(number1, number2);
                break;
            default:
                break;
        }
        return String.valueOf(result);
    }

    @Override
    public double plus(double number1, double number2) {
        return number1 + number2;
    }

    @Override
    public double minus(double number1, double number2) {
        return number1 - number2;
    }

    @Override
    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    @Override
    public double divide(double number1, double number2) {
        return number1 / number2;
    }
}
