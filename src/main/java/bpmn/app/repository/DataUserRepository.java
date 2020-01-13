package bpmn.app.repository;


import bpmn.app.model.DataUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataUserRepository extends JpaRepository<DataUser, Integer> {


}