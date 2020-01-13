package bpmn.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CompleteDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private boolean urgent;

    @NotNull
    private String specialization;

    @NotNull
    private String doctor;

    @NotNull
    private boolean NFZ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public boolean isNFZ() {
        return NFZ;
    }

    public void setNFZ(boolean NFZ) {
        this.NFZ = NFZ;
    }
}
