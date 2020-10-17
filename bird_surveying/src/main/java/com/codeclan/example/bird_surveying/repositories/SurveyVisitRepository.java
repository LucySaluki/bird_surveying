package com.codeclan.example.bird_surveying.repositories;

import com.codeclan.example.bird_surveying.models.SurveyVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyVisitRepository extends JpaRepository<SurveyVisit, Long> {

}
