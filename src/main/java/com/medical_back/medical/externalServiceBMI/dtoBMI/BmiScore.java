package com.medical_back.medical.externalServiceBMI.dtoBMI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BmiScore {

        @JsonProperty("bmi")
        private double bmi;
        @JsonProperty("health")
        private String health;
        @JsonProperty("healthy_bmi_range")
        private String healthy_bmi_range;
}
