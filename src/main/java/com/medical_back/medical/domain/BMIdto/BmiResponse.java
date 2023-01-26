package com.medical_back.medical.domain.BMIdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BmiResponse {
    @JsonProperty("data")
    private BmiScore bmiScore;
}
