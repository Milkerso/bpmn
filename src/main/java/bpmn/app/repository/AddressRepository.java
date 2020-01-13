package bpmn.app.repository;

import bpmn.app.model.AddressUser;
import bpmn.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("addressUserRepository")
public interface AddressRepository extends JpaRepository<AddressUser, Integer> {

//    List<AddressUser> findAddressUserBy (String street);
//    AddressUser findById(int id);

}