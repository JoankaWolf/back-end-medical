package com.medical_back.medical.service.BMIservice;

import com.medical_back.medical.config.BMI.BmiApiClient;
import com.medical_back.medical.domain.BMIdto.BmiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BmiService {

    private final BmiApiClient client;

    public BmiResponse getBmiScore(int age, int weight, int height) {
        return client.bmiScore(age, weight, height);
    }
}
