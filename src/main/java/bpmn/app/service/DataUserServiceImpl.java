package bpmn.app.service;

import bpmn.app.model.DataUser;
import bpmn.app.repository.DataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("dataUserService")
public class DataUserServiceImpl implements DataUserService {

    @Qualifier("dataUserRepository")
    @Autowired
    private DataUserRepository dataUserRepository;

    @Override
    public void saveUser(DataUser dataUser) {

        dataUserRepository.save(dataUser);
    }
}
