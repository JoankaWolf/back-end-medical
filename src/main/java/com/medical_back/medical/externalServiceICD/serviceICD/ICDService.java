package com.medical_back.medical.externalServiceICD.serviceICD;

import com.medical_back.medical.externalServiceICD.configICD.IcdApiClient;
import com.medical_back.medical.externalServiceICD.dtoICD.ICDRootDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ICDService {

    private final IcdApiClient icdApiClient;

    public ICDRootDataDto getICDCode(final String disease) {
        return icdApiClient.ICD(disease);
    }


}
