package com.codeclan.example.bird_surveying.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="survey_visit")
public class SurveyVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="project_number")
    private int projectNumber;

    @Column(name="site_name")
    private String siteName;

    @Column(name="surveyor")
    private String surveyor;

    @Column(name="survey_date")
    private String surveyDate;

    @Column(name="start_time")
    private String startTime;

    @Column(name="finish_time")
    private String finishTime;

    @Column(name="cloud_cover")
    private int cloudCover;

    @Column(name="temperature")
    private int temperature;

    @Column(name="wind_speed")
    private int windSpeed;

    @Column(name="wind_direction")
    private WindDirectionType windDirectionType;

    @Column(name="precipitation")
    private PrecipitationType precipitation;

    @JsonIgnoreProperties(value="survey_visit")
    @OneToMany(mappedBy="survey_visit", fetch = FetchType.LAZY)
    private List<BirdRecord> birdRecords;

    public SurveyVisit(int projectNumber, String siteName, String surveyor,
                       String surveyDate, String startTime, String finishTime,
                       int cloudCover, int temperature, int windSpeed,
                       WindDirectionType windDirectionType, PrecipitationType precipitation) {
        this.projectNumber = projectNumber;
        this.siteName = siteName;
        this.surveyor = surveyor;
        this.surveyDate = surveyDate;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.cloudCover = cloudCover;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirectionType = windDirectionType;
        this.precipitation = precipitation;
        this.birdRecords = new ArrayList<>();
    }

    public SurveyVisit(){

    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSurveyor() {
        return surveyor;
    }

    public void setSurveyor(String surveyor) {
        this.surveyor = surveyor;
    }

    public String getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(String surveyDate) {
        this.surveyDate = surveyDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public WindDirectionType getWindDirection() {
        return windDirectionType;
    }

    public void setWindDirection(WindDirectionType windDirectionType) {
        this.windDirectionType = windDirectionType;
    }

    public PrecipitationType getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(PrecipitationType precipitation) {
        this.precipitation = precipitation;
    }

    public List<BirdRecord> getBirdRecords() {
        return birdRecords;
    }

    public void setBirdRecords(List<BirdRecord> birdRecords) {
        this.birdRecords = birdRecords;
    }

    public void addBirdRecord(BirdRecord birdRecord){
        this.birdRecords.add(birdRecord);
    }
}

