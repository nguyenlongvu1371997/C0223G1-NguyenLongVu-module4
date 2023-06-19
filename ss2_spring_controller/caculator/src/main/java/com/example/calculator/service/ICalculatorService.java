package com.example.calculator.service;

public interface ICalculatorService {
    String calculator(double number1, double number2, String math);

    double plus(double number1, double number2);

    double minus(double number1, double number2);

    double multiply(double number1, double number2);

    double divide(double number1, double number2);
}
