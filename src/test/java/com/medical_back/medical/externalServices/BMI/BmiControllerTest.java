package com.medical_back.medical.externalServices.BMI;

import com.medical_back.medical.externalServiceBMI.controllerBMI.BmiController;
import com.medical_back.medical.externalServiceBMI.dtoBMI.BmiResponse;
import com.medical_back.medical.externalServiceBMI.dtoBMI.BmiScore;
import com.medical_back.medical.externalServiceBMI.serviceBMI.BmiService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class BmiControllerTest {

    @Mock
    private BmiService service;

    @InjectMocks
    private BmiController controller;

    @Test
    void getBmiScoreTest() throws RuntimeException {

        //Given
        BmiScore bmiScore = new BmiScore(20.5, "Normal", "19-25");
        BmiResponse response = new BmiResponse(bmiScore);
        when(service.getBmiScore(any(Integer.class), any(Integer.class), any(Integer.class))).thenReturn(response);

        //When
        ResponseEntity<BmiResponse> result = controller.getBmiScore(25,45,165);

        //Then
        assertEquals(20.5, result.getBody().getBmiScore().getBmi());

    }
}