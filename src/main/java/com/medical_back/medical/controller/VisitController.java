package com.medical_back.medical.controller;

import com.medical_back.medical.domain.dto.VisitDto;
import com.medical_back.medical.domain.entity.Visit;
import com.medical_back.medical.exception.ObjectsInClassNotFoundException;
import com.medical_back.medical.mapper.VisitMapper;
import com.medical_back.medical.service.VisitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/medical/visit")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VisitController {

    private final VisitMapper visitMapper;
    private final VisitDbService visitDbService;

    @GetMapping(value = "{visitId}")
    public ResponseEntity<VisitDto> getVisit(@PathVariable long visitId) throws ObjectsInClassNotFoundException {
        return ResponseEntity.ok(visitMapper.mapToVisitDto(visitDbService.getVisit(visitId)));
    }

    @GetMapping
    public ResponseEntity<List<VisitDto>> getAllVisit() {
        List<Visit> visits = visitDbService.allVisits();
        return ResponseEntity.ok(visitMapper.mapToVisitDtoList(visits));
    }

    @DeleteMapping(value = "{visitId}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long visitId) {
        visitDbService.deleteVisit(visitId);
        return ResponseEntity.ok().build();
    }


    @PutMapping
    public ResponseEntity<VisitDto> updateVisit(@RequestBody VisitDto visitDto) throws ObjectsInClassNotFoundException {
        Visit visit = visitMapper.mapToVisit(visitDto);
        Visit saveVisit = visitDbService.saveVisit(visit);
        return ResponseEntity.ok(visitMapper.mapToVisitDto(saveVisit));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createVisit(@RequestBody VisitDto visitDto) throws ObjectsInClassNotFoundException{
        Visit visit =visitMapper.mapToVisit(visitDto);
        visitDbService.saveVisit(visit);
        return ResponseEntity.ok().build();
    }

}
