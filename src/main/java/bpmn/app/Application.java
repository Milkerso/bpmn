package bpmn.app;

import bpmn.app.model.AppUser;
import bpmn.app.model.Role;
import bpmn.app.repository.RoleRepository;
import bpmn.app.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;


@SpringBootApplication
public class Application {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private RoleRepository roleRepository;

    public Application(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void createTestData() {
        Role roleAdmin = new Role();
        roleAdmin.setRole("ROLE_ADMIN");
        roleAdmin = roleRepository.save(roleAdmin);
        Role roleUser = new Role();
        roleUser.setRole("ROLE_USER");
        roleUser = roleRepository.save(roleUser);
        AppUser appUser = new AppUser();
        appUser.setActive(1);
        appUser.setName("Jan");
        appUser.setLastName("Kowalski");
        appUser.setSex("Men");
        appUser.setAddress("Lodz");
        appUser.setEmail("user@wp.pl");
        appUser.setPassword("haslo123");
        appUser.setPesel(12345678901l);
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setRoles(new HashSet<Role>(Arrays.asList(roleUser)));
        userRepository.save(appUser);

        AppUser admin = new AppUser();
        admin.setActive(1);
        admin.setName("Michal");
        admin.setLastName("Nowak");
        admin.setSex("Men");
        admin.setAddress("Lodz");
        admin.setEmail("admin@wp.pl");
        admin.setPesel(9876543210l);
        admin.setPassword("haslo123");
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        admin.setRoles(new HashSet<Role>(Arrays.asList(roleAdmin)));
        userRepository.save(admin);
    }
}
