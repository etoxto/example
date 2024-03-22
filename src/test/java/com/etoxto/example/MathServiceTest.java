package com.etoxto.example;

import com.etoxto.example.service.MathService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathServiceTest {

    @Test
    public void testCalculateFactorial() {
        MathService mathService = new MathService();
        assertEquals(1L, mathService.calculateFactorial(0));
        assertEquals(24L, mathService.calculateFactorial(4));
    }
}
