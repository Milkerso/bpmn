package bpmn.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CompleteDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String urgent;

    @NotNull
    private String specialization;

    @NotNull
    private String doctor;

    @NotNull
    private int NFZ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getNFZ() {
        return NFZ;
    }

    public void setNFZ(int NFZ) {
        this.NFZ = NFZ;
    }
}
