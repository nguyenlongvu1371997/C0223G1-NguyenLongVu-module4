package com.example.demo_change_money.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {

    @Override
    public double convert(double money, int value1, int value2) {
        double money1 = money;
        switch (value1) {
            case 2:
                money1 = money / 23000;
                break;
            case 3:
                money1 = money / 166;
                break;
            default:
                break;
        }
        switch (value2) {
            case 2:
                money1 = money * 23000;
                break;
            case 3:
                money1 = money * 166;
                break;
            default:
                break;
        }
        return money1;
    }
}
