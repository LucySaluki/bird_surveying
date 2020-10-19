package com.codeclan.example.bird_surveying;

import com.codeclan.example.bird_surveying.models.*;
import com.codeclan.example.bird_surveying.repositories.BirdRecordRepository;
import com.codeclan.example.bird_surveying.repositories.SurveyVisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class BirdSurveyingApplicationTests {
	@Autowired
	SurveyVisitRepository surveyVisitRepository;
	@Autowired
	BirdRecordRepository birdRecordRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void hasProjectNumber(){
		assertEquals(20023,surveyVisitRepository.getOne(1L).getProjectNumber());
	}
	@Test
	public void hasSiteName(){
		assertEquals("Wild Bird Hill",surveyVisitRepository.getOne(1L).getSiteName());
	}
	@Test
	public void hasSurveyor(){
		assertEquals("Joe Bloggs",surveyVisitRepository.getOne(1L).getSurveyor());
	}
	@Test
	public void hasSurveyDate(){
		assertEquals("01/05/2020",surveyVisitRepository.getOne(1L).getSurveyDate());
	}
	@Test
	public void hasStartTime(){
		assertEquals("10:13",surveyVisitRepository.getOne(1L).getStartTime());
	}
	@Test
	public void hasFinishTime(){
		assertEquals("14:45",surveyVisitRepository.getOne(1L).getFinishTime());
	}
	@Test
	public void hasCloudCover(){
		assertEquals(5,surveyVisitRepository.getOne(1L).getCloudCover());
	}
	@Test
	public void hasTemperature(){
		assertEquals(5,surveyVisitRepository.getOne(1L).getTemperature());
	}
	@Test
	public void hasWindSpeed(){
		assertEquals(2,surveyVisitRepository.getOne(1L).getWindSpeed());
	}
	@Test
	public void hasWindDirection(){
		assertEquals("NORTH",surveyVisitRepository.getOne(1L).getWindDirectionType().toString());
	}
	@Test
	public void hasPrecipitation(){
		assertEquals("NONE",surveyVisitRepository.getOne(1L).getPrecipitation().toString());
	}
	@Test
	public void canAddVisit(){
		SurveyVisit surveyVisit= new SurveyVisit(12345,"Area needing Survey","A. Surveyor",
				"01/01/2020", "10:00","17:00", 1,17,4,
				WindDirectionType.NORTH_EAST, PrecipitationType.HEAVY_PERSISTENT);
		surveyVisitRepository.save(surveyVisit);
		assertEquals(3,surveyVisitRepository.count());
	}
	@Test
	public void hasSpecies(){
		assertEquals("Curlew",birdRecordRepository.getOne(1L).getSpecies());
	}
	@Test
	public void hasCount(){
		assertEquals(2,birdRecordRepository.getOne(4L).getCountBirds());
	}
	@Test
	public void hasGender(){
		assertEquals("UNKNOWN",birdRecordRepository.getOne(1L).getGender().toString());
	}
	@Test
	public void hasAge(){
		assertEquals("ADULT",birdRecordRepository.getOne(1L).getAgeClass().toString());
	}
	@Test
	public void hasActivity(){
		assertEquals("SUMMERING",birdRecordRepository.getOne(1L).getActivity().toString());
	}
	@Test
	public void hasComments(){
		assertEquals("Alarm calling",birdRecordRepository.getOne(2L).getComments());
	}
	@Test
	public void hasEasting(){
		assertEquals(57.4,birdRecordRepository.getOne(1L).getLongitude());
	}
	@Test
	public void hasNorthing(){
		assertEquals(4.22,birdRecordRepository.getOne(1L).getLatitude());
	}
	@Test
	public void hasSurveyVisit(){
		assertEquals(1,birdRecordRepository.getOne(1L).getSurveyVisit().getId());
	}
	@Test
	public void canAddBirdRecord(){
		SurveyVisit survey=surveyVisitRepository.getOne(2L);
		BirdRecord birdRecord=new BirdRecord("Common sandpiper",1, GenderType.UNKNOWN,
				AgeType.ADULT,ActivityType.FLYING,"Flying over",4.22,57.4,survey);
		survey.addBirdRecord(birdRecord);
		assertEquals(2,survey.getBirdRecords().size());
	}
}
