package com.medical_back.medical.domain.ICDdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ICDRootDataDto {
    public int current_page;

    public ArrayList<Datum> data;
}
