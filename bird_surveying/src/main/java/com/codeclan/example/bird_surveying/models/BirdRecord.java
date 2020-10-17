package com.codeclan.example.bird_surveying.models;

import javax.persistence.*;

@Entity
@Table(name="bird_records")
public class BirdRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bto_code")
    private String btoCode;

    @Column(name = "species")
    private String species;

    @Column(name = "count_birds")
    private int countBirds;

    @Column(name = "gender")
    private GenderType gender;

    @Column(name = "age")
    private AgeType ageClass;

    @Column(name = "activity")
    private ActivityType activity;

    @Column(name = "comments")
    private String comments;

    @Column(name = "easting")
    private Long easting;

    @Column(name = "northing")
    private Long northing;

    @ManyToOne
    @JoinColumn(name = "surveyVisit_id", nullable = false)
    private SurveyVisit surveyVisit;

    public BirdRecord(String btoCode, String species, int countBirds, GenderType gender,
                      AgeType ageClass, ActivityType activity, String comments,
                      Long easting, Long northing, SurveyVisit surveyVisit) {
        this.btoCode = btoCode;
        this.species = species;
        this.countBirds = countBirds;
        this.gender = gender;
        this.ageClass = ageClass;
        this.activity = activity;
        this.comments = comments;
        this.easting = easting;
        this.northing = northing;
        this.surveyVisit = surveyVisit;
    }

    public BirdRecord(){

    }

    public String getBtoCode() {
        return btoCode;
    }

    public void setBtoCode(String btoCode) {
        this.btoCode = btoCode;
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

    public Long getEasting() {
        return easting;
    }

    public void setEasting(Long easting) {
        this.easting = easting;
    }

    public Long getNorthing() {
        return northing;
    }

    public void setNorthing(Long northing) {
        this.northing = northing;
    }

    public SurveyVisit getSurveyVisit() {
        return surveyVisit;
    }

    public void setSurveyVisit(SurveyVisit surveyVisit) {
        this.surveyVisit = surveyVisit;
    }
}

