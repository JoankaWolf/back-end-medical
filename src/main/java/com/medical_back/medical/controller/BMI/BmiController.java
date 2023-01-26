package com.medical_back.medical.controller.BMI;
import com.medical_back.medical.service.BMIservice.BmiService;
import com.medical_back.medical.domain.BMIdto.BmiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/bmi")
public class BmiController {

        private final BmiService bmiService;

        @GetMapping()
        public ResponseEntity<BmiResponse> getBmiScore(@RequestParam int age, int weight, int height) {
            return ResponseEntity.ok(bmiService.getBmiScore(age, weight, height));
        }
    }
