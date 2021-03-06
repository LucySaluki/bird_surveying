package com.codeclan.example.bird_surveying.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="bird_records")
public class BirdRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "species")
    private String species;

    @Column(name = "count_birds")
    private int countBirds;

    @Column(name = "gender")
    @Enumerated(value= EnumType.STRING)
    private GenderType gender;

    @Column(name = "age")
    @Enumerated(value= EnumType.STRING)
    private AgeType ageClass;

    @Column(name = "activity")
    @Enumerated(value= EnumType.STRING)
    private ActivityType activity;

    @Column(name = "comments")
    private String comments;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;
    
    @ManyToOne
    @JoinColumn(name = "survey_visit_id", nullable = false)
    private SurveyVisit surveyVisit;

    public BirdRecord(String species, int countBirds, GenderType gender,
                      AgeType ageClass, ActivityType activity, String comments,
                      double longitude, double latitude, SurveyVisit surveyVisit) {
        this.species = species;
        this.countBirds = countBirds;
        this.gender = gender;
        this.ageClass = ageClass;
        this.activity = activity;
        this.comments = comments;
        this.longitude = longitude;
        this.latitude = latitude;
        this.surveyVisit = surveyVisit;
    }

    public BirdRecord(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getCountBirds() {
        return countBirds;
    }

    public void setCountBirds(int countBirds) {
        this.countBirds = countBirds;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public AgeType getAgeClass() {
        return ageClass;
    }

    public void setAgeClass(AgeType ageClass) {
        this.ageClass = ageClass;
    }

    public ActivityType getActivity() {
        return activity;
    }

    public void setActivity(ActivityType activity) {
        this.activity = activity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public SurveyVisit getSurveyVisit() {
        return surveyVisit;
    }

    public void setSurveyVisit(SurveyVisit surveyVisit) {
        this.surveyVisit = surveyVisit;
    }
}

