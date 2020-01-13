package bpmn.app.repository;

import bpmn.app.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("visitRepository")
public interface VisitRepository extends JpaRepository<Visit, Integer> {


}