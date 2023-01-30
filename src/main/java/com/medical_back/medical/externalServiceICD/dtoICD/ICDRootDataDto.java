package com.medical_back.medical.externalServiceICD.dtoICD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ICDRootDataDto {

    private final int current_page;
    private final List<Datum> data;
}
