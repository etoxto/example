package com.etoxto.example.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    @JsonProperty("factorial_num")
    Integer factorialNum;

}
