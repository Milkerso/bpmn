package bpmn.app;

import bpmn.app.model.Role;
import bpmn.app.model.User;
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
        User user = new User();
        user.setActive(1);
        user.setName("Jan");
        user.setLastName("Kowalski");
        user.setSex("Men");
        user.setAddress("Lodz");
        user.setEmail("user@wp.pl");
        user.setPassword("haslo123");
        user.setPesel(12345678901l);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<Role>(Arrays.asList(roleUser)));
        userRepository.save(user);

        User admin = new User();
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
