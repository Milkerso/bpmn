package bpmn.app.service;

import bpmn.app.model.CompleteDetails;
import bpmn.app.repository.CompleteDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("completeDetailsService")
public class CompleteDetailsServiceImpl implements CompleteDetailsService {

    @Qualifier("completeDetailsRepository")
    @Autowired
    private CompleteDetailsRepository completeDetailsRepository;


    @Override
    public void saveCompleteDetails(CompleteDetails completeDetails) {

        completeDetailsRepository.save(completeDetails);

    }
}
