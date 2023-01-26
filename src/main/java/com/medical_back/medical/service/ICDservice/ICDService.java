package com.medical_back.medical.service.ICDservice;

import com.medical_back.medical.config.ICD.IcdApiClient;
import com.medical_back.medical.domain.ICDdto.ICDRootDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ICDService {

    private final IcdApiClient icdApiClient;

    public ICDRootDataDto getBmiScore(String disease) {
        return icdApiClient.ICD(disease);
    }


}
