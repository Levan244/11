package com.example.culk;

import com.example.culk.service.CalculatorService;
import com.example.culk.service.CalculatorServiceImpl;
import net.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorServiceImplParameterisedTest {
    private CalculatorService calculatorService = new CalculatorServiceImpl();

    public static Stream<Arguments> provideParamsToTests() {
        return Stream.of(
                arguments(5,5),
                arguments(6,6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsToTests")
    public void shouldReturnCorrectResultWhenPlus(int num1, int num2) {
        int result = calculatorService.plus(num1,num2);
        Assertions.assertEquals((num1+num2), result);
    }
    @ParameterizedTest
    @MethodSource("provideParamsToTests")
    public void shouldReturnCorrectResultWhenMinus(int num1, int num2) {
        int result = calculatorService.minus(num1,num2);
        Assertions.assertEquals((num1-num2), result);
    }
    @ParameterizedTest
    @MethodSource("provideParamsToTests")
    public void shouldReturnCorrectResultWhenMultiply(int num1, int num2) {
        int result = calculatorService.multiplay(num1,num2);
        Assertions.assertEquals((num1*num2), result);
    }
    @ParameterizedTest
    @MethodSource("provideParamsToTests")
    public void shouldReturnCorrectResultWhenDivide(int num1, int num2) {
        int result = calculatorService.divide(num1,num2);
        Assertions.assertEquals((num1/num2), result);
    }
}
