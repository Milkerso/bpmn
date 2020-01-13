package bpmn.app.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class TermVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String date;


//    @ManyToOne
//    private Visit visit;


//    @ManyToOne
//    private AppUser appUsers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public Visit getVisit() {
//        return visit;
//    }
//
//    public void setVisit(Visit visit) {
//        this.visit = visit;
//    }

    //    public AppUser getAppUsers() {
//        return appUsers;
//    }
//
//    public void setAppUsers(AppUser appUsers) {
//        this.appUsers = appUsers;
//    }
}
