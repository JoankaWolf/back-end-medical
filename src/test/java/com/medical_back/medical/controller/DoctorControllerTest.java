package com.medical_back.medical.controller;

import com.google.gson.Gson;
import com.medical_back.medical.domain.dto.DoctorDto;
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

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DoctorController doctorController;



    @Test
    void shouldFetchEmptyDoctorList() throws Exception{

        // Given
        when(doctorController.getAllDoctors()).thenReturn(ResponseEntity.ok(List.of()));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/medical/doctor")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldFetchDoctorsList() throws Exception {

        //Given
        List<DoctorDto> doctorDtos =
                List.of(new DoctorDto(1L, "test", "test", "spec"));

        when(doctorController.getAllDoctors()).thenReturn(ResponseEntity.ok(doctorDtos));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/medical/doctor")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].specialization", Matchers.is("spec")));
    }

    @Test
    void shouldFetchDoctor() throws Exception {

        DoctorDto doctorDto = new DoctorDto(1L, "test", "test", "spec");
        when(doctorController.getDoctor(any(Long.class))).thenReturn(ResponseEntity.ok(doctorDto));


        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/medical/doctor/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.specialization", Matchers.is("spec")));

    }


    @Test
    void shouldDeleteDoctor() throws Exception {

        //Given, When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/medical/doctor/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void shouldUpdateDoctor() throws Exception {

        //Given
        DoctorDto doctorDto = new DoctorDto(1L, "test", "test", "spec");
        when(doctorController.updateDoctor(any(DoctorDto.class))).thenReturn(ResponseEntity.ok(doctorDto));

        Gson gson = new Gson();
        String jsonContent = gson.toJson(doctorDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/medical/doctor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.specialization", Matchers.is("spec")));
    }

    @Test
    void shouldCreateDoctor() throws Exception {

        //Given
        DoctorDto doctorDto = new DoctorDto(1L, "test", "test", "spec");

        Gson gson = new Gson();
        String jsonContent = gson.toJson(doctorDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/medical/doctor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
