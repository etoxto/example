package com.etoxto.example;

import com.etoxto.example.model.network.RequestDto;
import com.etoxto.example.model.network.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MathControllerIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testCalculateFactorial_ReturnsOkResponse() throws Exception {
        RequestDto request = new RequestDto(5);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy()).writeValueAsString(request);
        HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);

        ResponseEntity<ResponseDto> response = restTemplate.postForEntity(getURLWithPort(), entity, ResponseDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(120, response.getBody().getResult());
    }

    @Test
    public void calculateFactorial_ValidationFailed_ReturnsBadRequest() throws Exception {
        RequestDto request = new RequestDto(-1);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy()).writeValueAsString(request);
        HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);

        ResponseEntity<ResponseDto> response = restTemplate.postForEntity(getURLWithPort(), entity, ResponseDto.class);

        assertEquals(400, response.getStatusCode().value());
    }

    private String getURLWithPort() {
        return "http://localhost:" + port + "/api/v1/math/factorial";
    }
}
