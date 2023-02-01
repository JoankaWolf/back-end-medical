package com.medical_back.medical.externalServices.ICD;


import com.medical_back.medical.externalServiceICD.controllerICD.ICDController;
import com.medical_back.medical.externalServiceICD.dtoICD.Datum;
import com.medical_back.medical.externalServiceICD.dtoICD.ICDRootDataDto;
import com.medical_back.medical.externalServiceICD.serviceICD.ICDService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ICDControllerTest {

    @Mock
    private ICDService service;

    @InjectMocks
    private ICDController controller;

    @Test
    void getICDTest() throws RuntimeException {

        //Given
        Datum datum = new Datum("test", "test", "test", "test", "test");

        ICDRootDataDto icdRootDataDto = new ICDRootDataDto(1, List.of(datum));

        when(service.getICDCode(any(String.class))).thenReturn(icdRootDataDto);

        //When
        ResponseEntity<ICDRootDataDto> result = controller.getICD("cancer");

        //Then
        assertEquals("test", result.getBody().getData().get(0).getCode());



    }
}