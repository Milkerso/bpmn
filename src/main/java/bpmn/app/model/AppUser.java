package bpmn.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "appUser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private int active;

    @ManyToMany
    @JoinColumn
    private Set<Role> roles;

    @ManyToMany
    @JoinColumn
    private Set<Specialization> specializations;

    @ManyToMany
    @JoinColumn
    private Set<Visit> visits;

    @ManyToOne
    private AddressUser addressUser;


//    @OneToMany(mappedBy = "appUser")
//    private List<TermVisit> termVisitList;

    @Transient
    private int nrRoli;

    @Transient
    private String newPassword;

    @Column(name = "activation_code")
    private String activationCode;


    //gettery i settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getNrRoli() {
        return nrRoli;
    }

    public void setNrRoli(int nrRoli) {
        this.nrRoli = nrRoli;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }


    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public AddressUser getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(AddressUser addressUser) {
        this.addressUser = addressUser;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

//    public List<TermVisit> getTermVisitList() {
//        return termVisitList;
//    }
//
//    public void setTermVisitList(List<TermVisit> termVisitList) {
//        this.termVisitList = termVisitList;
//    }
}
