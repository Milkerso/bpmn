package bpmn.app.repository;

import bpmn.app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByEmail(String email);

    @Modifying
    @Query("UPDATE AppUser u SET u.password = :newPassword WHERE u.email= :email")
    void updateUserPassword(@Param("newPassword") String password, @Param("email") String email);

    @Modifying
    @Query("UPDATE AppUser u SET u.name = :newName, u.lastName = :newLastName, u.email = :newEmail WHERE u.id= :id")
    void updateUserProfile(@Param("newName") String newName, @Param("newLastName") String newLastName,
                           @Param("newEmail") String newEmail, @Param("id") Integer id);

    @Modifying
    @Query("UPDATE AppUser u SET u.active = :activeParam WHERE u.activationCode = :activationCode")
    void updateActivation(@Param("activeParam") int activeParam, @Param("activationCode") String activationCode);
}
