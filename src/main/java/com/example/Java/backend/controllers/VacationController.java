package com.example.Java.backend.controllers;

import com.example.Java.backend.dto.VacationResponseDTO;
import com.example.Java.backend.entities.Excursion;
import com.example.Java.backend.entities.Vacation;
import com.example.Java.backend.services.ExcursionService;
import com.example.Java.backend.services.VacationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional; 
@RestController
@RequestMapping("/api/vacations")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @Autowired
    private ExcursionService excursionService;

    @GetMapping
    public ResponseEntity<VacationResponseDTO> getAllVacations() {
        
        List<Vacation> vacations = vacationService.getAllVacations();

        for (Vacation vacation : vacations) {
            vacation.setSelfHref();
        }


        VacationResponseDTO responseDto = new VacationResponseDTO();

       responseDto.setVacations(vacations);

        
        return ResponseEntity.ok(responseDto);
    }

       @GetMapping("/{id}")
    public ResponseEntity<?> getVacationById(@PathVariable Long id) {
        try {
            Vacation vacation = vacationService.getVacationById(id);
            return ResponseEntity.ok(vacation);
        } catch (Exception e) {
            // You can customize the exception handling as needed
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/excursions")
    public ResponseEntity<?> getVactionExcursions(@PathVariable Long id){

        List<Excursion> excursions = excursionService.getExcursionsByVacationId(id);
        for (Excursion excursion : excursions) {
            excursion.setSelfHref();
        }
        return ResponseEntity.ok().body(Map.of("_embedded", Map.of("excursions", excursions)));

    }

    @GetMapping("{vacationId}/excursions/{excursionId}")
    public ResponseEntity<Optional<Excursion>> getVacationSingleExcursion(@PathVariable Long vacationId,@PathVariable Long excursionId){
        
        List<Excursion> vacationExcursions = excursionService.getExcursionsByVacationId(vacationId);
        System.out.println(" and excursion" + vacationExcursions);
              
      Optional<Excursion> matchedExcursion = vacationExcursions.stream()
      .filter(excursion -> excursion.getId().equals(excursionId))
      .findFirst();

      if (matchedExcursion == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(matchedExcursion);
    }

}