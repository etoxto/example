package com.etoxto.example.service;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Long calculateFactorial(int num) {
        return CombinatoricsUtils.factorial(num);
    }
}
