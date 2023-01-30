package com.medical_back.medical.externalServiceBMI.serviceBMI;

import com.medical_back.medical.externalServiceBMI.configBMI.BmiApiClient;
import com.medical_back.medical.externalServiceBMI.dtoBMI.BmiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BmiService {

    private final BmiApiClient client;

    public BmiResponse getBmiScore(final int age, final int weight, final int height) {
        return client.bmiScore(age, weight, height);
    }
}
