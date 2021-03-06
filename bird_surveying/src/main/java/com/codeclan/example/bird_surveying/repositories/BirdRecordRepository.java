package com.codeclan.example.bird_surveying.repositories;

import com.codeclan.example.bird_surveying.models.BirdRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRecordRepository extends JpaRepository<BirdRecord, Long> {
}
