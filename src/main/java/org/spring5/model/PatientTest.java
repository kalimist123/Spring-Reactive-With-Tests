package org.spring5.model;

public class PatientTest {

    public PatientTest(){}


    public PatientTest(Long id, String biomarker, long tat) {
        this.id = id;
        this.biomarker = biomarker;
        this.tat = tat;
    }


    private Long id;
    private String biomarker;
    private Long tat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBiomarker() {return biomarker;}
    public void setBiomarker(String biomarker){this.biomarker = biomarker;}

    public Long getTat(){return tat;}
    public void setTat(Long tat){this.tat = tat;}



}
