package com.example.culk.service;

import com.example.culk.exeption.ZeroDividerException;
import org.springframework.stereotype.Service;

@Service

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiplay(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ZeroDividerException();
        }
        System.out.println();
        return num1 / num2;
    }


}
