package bpmn.app;

import bpmn.app.model.*;
import bpmn.app.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@SpringBootApplication
public class Application {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private RoleRepository roleRepository;

    private AddressRepository addressRepository;

    private SpecializationsRepository specializationsRepository;

    private TermVisitRepository termVisitRepository;

    private VisitRepository visitRepository;

    private InsuranceRepository insuranceRepository;

    public Application(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository,
                       AddressRepository addressRepository, SpecializationsRepository specializationsRepository,
                       TermVisitRepository termVisitRepository, VisitRepository visitRepository, InsuranceRepository insuranceRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
        this.specializationsRepository = specializationsRepository;
        this.termVisitRepository = termVisitRepository;
        this.visitRepository = visitRepository;
        this.insuranceRepository = insuranceRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void createTestData() {
        Role roleAdmin = new Role();
        roleAdmin.setRole("ROLE_ADMIN");
        roleAdmin = roleRepository.save(roleAdmin);

        Role rolePatient = new Role();
        rolePatient.setRole("ROLE_PATIENT");
        rolePatient = roleRepository.save(rolePatient);

        Role roleDoctor = new Role();
        roleDoctor.setRole("ROLE_DOCTOR");
        roleDoctor = roleRepository.save(roleDoctor);


        AppUser appUser = new AppUser();
        AddressUser addressUser = new AddressUser();
        Visit visitUser = new Visit();
        TermVisit termVisit = new TermVisit();
        Specialization specialization = new Specialization();
        Insurance insurance = new Insurance();

        appUser.setActive(1);
        appUser.setEmail("user@wp.pl");
        appUser.setPassword("haslo123");


        addressUser.setBirth("2020-12-21");
        addressUser.setCity("Lodz");
        addressUser.setLastName("Nowak");
        addressUser.setName("Kuba");
        addressUser.setPesel(343434334);
        addressUser.setSex("mezczyzna");
        addressUser.setStreet("Politechniki");
        addressUser.setTelephone("34343434334");
        appUser.setAddressUser(addressUser);

        visitUser.setActive(true);

//        appUser.setVisits(new HashSet<Visit>(Arrays.asList(visitUser)));
//
//
//
//

        termVisit.setDate("Wtorek-20-grudnia-2019");
        //termVisit.setVisit(visitUser);
//        appUser.setTermVisit(termVisit);
//        visitUser.setTermVisit(termVisit);
//
//
//
        specialization.setSpecialization("Kardiolog");

//        specialization.setSpecialization("Neurolog");
//
        insurance.setActive(true);
        insurance.setPesel(960807073);

        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setRoles(new HashSet<Role>(Arrays.asList(rolePatient)));

        specializationsRepository.save(specialization);
        insuranceRepository.save(insurance);
        termVisitRepository.save(termVisit);

        addressRepository.save(addressUser);
        userRepository.save(appUser);



        AppUser admin = new AppUser();
        admin.setActive(1);
        admin.setEmail("admin@wp.pl");
        admin.setPassword("haslo123");
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        admin.setRoles(new HashSet<Role>(Arrays.asList(roleAdmin)));
        userRepository.save(admin);
    }
}
