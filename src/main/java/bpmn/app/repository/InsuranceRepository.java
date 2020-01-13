package bpmn.app.repository;

import bpmn.app.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("insuranceRepository")
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

}