package bpmn.app.repository;

import bpmn.app.model.CompleteDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("completeDetailsRepository")
public interface CompleteDetailsRepository extends JpaRepository<CompleteDetails, Integer> {
}
