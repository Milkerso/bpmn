package bpmn.app.repository;

import bpmn.app.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("specializationRepository")
public interface SpecializationsRepository extends JpaRepository<Specialization, Integer> {


}