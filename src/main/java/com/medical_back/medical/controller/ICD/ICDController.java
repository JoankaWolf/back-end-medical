package com.medical_back.medical.controller.ICD;


import com.medical_back.medical.service.ICDservice.ICDService;
import com.medical_back.medical.domain.ICDdto.ICDRootDataDto;
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
        return ResponseEntity.ok(icdService.getBmiScore(disease));
    }
}
