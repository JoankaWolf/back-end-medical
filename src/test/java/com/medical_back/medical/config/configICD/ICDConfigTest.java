package com.medical_back.medical.config.configICD;

import com.medical_back.medical.externalServiceICD.configICD.ICDConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ICDConfigTest {

    @Autowired
    private ICDConfig icdConfig;

    @Test
    public void checkBmiConfig() {
        //Given&When&Then
        assertNotNull(icdConfig.getIcdAuthorization());
        assertNotNull(icdConfig.getIcdHost());
        assertNotNull(icdConfig.getIcdAppKey());
        assertNotNull(icdConfig.getIcdApiEndpoint());

    }

}