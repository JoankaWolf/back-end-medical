package com.medical_back.medical.domain.BMIdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class BmiScore {

        @JsonProperty("bmi")
        int bmi;
        @JsonProperty("health")
        String health;
        @JsonProperty("healthy_bmi_range")
        String healthy_bmi_range;
}
