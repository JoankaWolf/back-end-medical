package com.medical_back.medical.externalServiceICD.controllerICD;


import com.medical_back.medical.externalServiceICD.serviceICD.ICDService;
import com.medical_back.medical.externalServiceICD.dtoICD.ICDRootDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/icd")
public class ICDController {

    private final ICDService icdService;

    @GetMapping(value="{disease}")
    public ResponseEntity<ICDRootDataDto> getICD(@PathVariable String disease) {
        return ResponseEntity.ok(icdService.getICDCode(disease));
    }
}
