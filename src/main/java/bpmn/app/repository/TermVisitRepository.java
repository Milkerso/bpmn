package bpmn.app.repository;

import bpmn.app.model.TermVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("termVisitRepository")
public interface TermVisitRepository extends JpaRepository<TermVisit, Integer> {


}
