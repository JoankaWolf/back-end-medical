package com.medical_back.medical.config.configBMI;


import com.medical_back.medical.externalServiceBMI.configBMI.BmiConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BmiConfigTest {

    @Autowired
    private BmiConfig bmiConfig;

    @Test
    public void checkBmiConfig() {
        //Given&When&Then
        assertNotNull(bmiConfig.getBmiAppKey());
        assertNotNull(bmiConfig.getBmiApiEndpoint());
        assertNotNull(bmiConfig.getBmiHost());

    }

}