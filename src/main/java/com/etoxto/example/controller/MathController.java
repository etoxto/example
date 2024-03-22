package com.etoxto.example.controller;

import com.etoxto.example.model.network.RequestDto;
import com.etoxto.example.model.network.ResponseDto;
import com.etoxto.example.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/math")
public class MathController {

    private final MathService mathService;

    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @PostMapping(value = "/factorial", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> calculateFactorial(@RequestBody @Validated RequestDto dto) {
        return ResponseEntity.ok().body(new ResponseDto(mathService.calculateFactorial(dto.getFactorialNum())));
    }
}
