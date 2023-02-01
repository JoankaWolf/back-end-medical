package com.medical_back.medical.controller;


import com.google.gson.Gson;
import com.medical_back.medical.domain.dto.DoctorDto;
import com.medical_back.medical.domain.dto.PatientDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PatientController patientController;

    @Test
    void shouldFetchEmptyPatientList() throws Exception{

        // Given
        when(patientController.getAllPatients()).thenReturn(ResponseEntity.ok(List.of()));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/medical/patient")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }
    @Test
    void shouldFetchPatient() throws Exception {

        PatientDto patientDto = new PatientDto(1L, "test", "test", "mail", 123L, new ArrayList<>());
        when(patientController.getPatient(any(Long.class))).thenReturn(ResponseEntity.ok(patientDto));


        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/medical/patient/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("test")));

    }


    @Test
    void shouldDeletePatient() throws Exception {

        //Given, When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/medical/patient/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void shouldUpdatePatient() throws Exception {

        //Given
        PatientDto patientDto = new PatientDto(1L, "test", "test", "test", 123L, new ArrayList<>());
        when(patientController.updatePatient(any(PatientDto.class))).thenReturn(ResponseEntity.ok(patientDto));

        Gson gson = new Gson();
        String jsonContent = gson.toJson(patientDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/medical/patient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("test")));
    }


    @Test
    void shouldCreatePatient() throws Exception {

        //Given
        PatientDto patientDto = new PatientDto(1L, "test", "test", "test", 123L, new ArrayList<>());

        Gson gson = new Gson();
        String jsonContent = gson.toJson(patientDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/medical/patient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
