package com.example.culk.controller;

import com.example.culk.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String show() {
        return "Добро пожаловать в канкулятор";
    }

    @GetMapping("/plus")
    public String sum(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.plus(num1, num2);
        return buildMassage(num1, num2, result, '+');
    }

    @GetMapping("/minus")
    public String nubtract(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.minus(num1, num2);
        return buildMassage(num1, num2, result, '-');
    }

    @GetMapping("/multiplay")
    public String multiplay(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.multiplay(num1, num2);
        return buildMassage(num1, num2, result, '*');
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "Второй аргумент 0, на 0 делить нельзя.";
        }

        int result = calculatorService.divide(num1, num2);
        return buildMassage(num1, num2, result, '/');
    }

    private String buildMassage(int num1, int num2, int result, char action) {
        return String.format("%d %c %d = %d", num1, action, num2, result);
    }

}
