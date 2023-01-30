package com.medical_back.medical.externalServiceBMI.configBMI;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BmiConfig {

    @Value("${bmi.api.endpoint}")
    private String bmiApiEndpoint;
    @Value("${bmi.api.key}")
    private String bmiAppKey;
    @Value("${bmi.api.host}")
    private String bmiHost;

}
