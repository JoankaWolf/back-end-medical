package com.medical_back.medical.config.ICD;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ICDConfig {

    @Value("${icd.api.endpoint}")
    private String icdApiEndpoint;
    @Value("${icd.api.key}")
    private String icdAppKey;
    @Value("${icd.api.host}")
    private String icdHost;
    @Value("${icd.api.authorization}")
    private String IcdAuthorization;
}
