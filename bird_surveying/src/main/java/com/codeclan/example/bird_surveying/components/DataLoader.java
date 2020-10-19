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

        BirdRecord bird1= new BirdRecord("Curlew",1, GenderType.UNKNOWN, AgeType.ADULT,
                ActivityType.SUMMERING,"",4.25,57.46,visit1);
        birdRecordRepository.save(bird1);

        BirdRecord bird2= new BirdRecord("Dunlin",1, GenderType.MALE, AgeType.ADULT,
                ActivityType.AGITATED,"Alarm calling",4.23,57.479,visit1);
        birdRecordRepository.save(bird2);

        BirdRecord bird3= new BirdRecord("Snipe",1, GenderType.MALE, AgeType.ADULT,
                ActivityType.DISPLAY,"Drumming",4.2247,57.4778,visit1);
        birdRecordRepository.save(bird3);

        SurveyVisit visit2= new SurveyVisit(20002,"Ben Wyvis", "Fred Smith",
                "04/06/2020","07:03","11:34",2,12,
                1, WindDirectionType.SOUTH_WEST, PrecipitationType.LIGHT_INTERMITTENT);
        surveyVisitRepository.save(visit2);

        BirdRecord bird4= new BirdRecord("Curlew",2, GenderType.UNKNOWN, AgeType.EGG,
                ActivityType.NEST_EGGS,"No sign of adult, eggs warm though",4.26,57.4778,visit2);
        birdRecordRepository.save(bird4);
    }
}
