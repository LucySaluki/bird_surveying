package com.codeclan.example.bird_surveying.controllers;

import com.codeclan.example.bird_surveying.models.BirdRecord;
import com.codeclan.example.bird_surveying.repositories.BirdRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BirdRecordController {

    @Autowired
    BirdRecordRepository birdRecordRepository;


    @GetMapping(value = "/birds")
    public ResponseEntity<List<BirdRecord>> getAllBirdRecords(){
        return new ResponseEntity<>(birdRecordRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/birds/{id}")
    public ResponseEntity getBirdRecord(@PathVariable Long id){
        return new ResponseEntity<>(birdRecordRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/birds")
    public ResponseEntity<BirdRecord> postBirdRecord(@RequestBody BirdRecord birdRecord){
        birdRecordRepository.save(birdRecord);
        return new ResponseEntity<>(birdRecord, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/birds/{id}")
    public ResponseEntity<BirdRecord> updateBirdRecord(@RequestBody BirdRecord birdRecord){
        birdRecordRepository.save(birdRecord);
        return new ResponseEntity<>(birdRecord, HttpStatus.OK);
    }

    @DeleteMapping(value = "/birds/{id}")
    public ResponseEntity<BirdRecord> deleteBirdRecord(@PathVariable Long id) {
        BirdRecord found = birdRecordRepository.getOne(id);
        birdRecordRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
