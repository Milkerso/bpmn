package bpmn.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean active;

//    @OneToMany(mappedBy = "visit")
//    private List<TermVisit> termVisitsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    public List<TermVisit> getTermVisitsList() {
//        return termVisitsList;
//    }
//
//    public void setTermVisitsList(List<TermVisit> termVisitsList) {
//        this.termVisitsList = termVisitsList;
//    }
}
