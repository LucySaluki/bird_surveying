package com.codeclan.example.bird_surveying.controllers;

import com.codeclan.example.bird_surveying.models.SurveyVisit;
import com.codeclan.example.bird_surveying.repositories.SurveyVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SurveyVisitController {

    @Autowired
    SurveyVisitRepository surveyVisitRepository;

    @GetMapping(value = "/visits")
    public ResponseEntity<List<SurveyVisit>> getAllSurveyVisits(){
        return new ResponseEntity<>(surveyVisitRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/visits/{id}")
    public ResponseEntity getSurveyVisit(@PathVariable Long id){
        return new ResponseEntity<>(surveyVisitRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/visits")
    public ResponseEntity<SurveyVisit> createSurveyVisit(@RequestBody SurveyVisit surveyVisit){
        surveyVisitRepository.save(surveyVisit);
        return new ResponseEntity<>(surveyVisit, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/visits/{id}")
    public ResponseEntity<SurveyVisit> updateSurveyVisit(@RequestBody SurveyVisit surveyVisit){
        surveyVisitRepository.save(surveyVisit);
        return new ResponseEntity<>(surveyVisit, HttpStatus.OK);
    }

    @DeleteMapping(value = "/visits/{id}")
    public ResponseEntity<SurveyVisit> deleteSurveyVisit(@PathVariable Long id) {
        SurveyVisit found = surveyVisitRepository.getOne(id);
        surveyVisitRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
