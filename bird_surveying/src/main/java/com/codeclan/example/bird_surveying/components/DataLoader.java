package com.codeclan.example.bird_surveying.components;

import com.codeclan.example.bird_surveying.models.*;
import com.codeclan.example.bird_surveying.repositories.BirdRecordRepository;
import com.codeclan.example.bird_surveying.repositories.SurveyVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    SurveyVisitRepository surveyVisitRepository;

    @Autowired
    BirdRecordRepository birdRecordRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) throws Exception {
        SurveyVisit visit1= new SurveyVisit(20023,"Wild Bird Hill", "Joe Bloggs",
                "01/05/2020","10:13","14:45",5,5,
                2, WindDirectionType.NORTH, PrecipitationType.NONE);
        surveyVisitRepository.save(visit1);

        BirdRecord bird1= new BirdRecord("CU","Curlew",1, GenderType.UNKNOWN, AgeType.ADULT,
                ActivityType.SUMMERING,"",123456L,654321L,visit1);
        birdRecordRepository.save(bird1);
    }
}
