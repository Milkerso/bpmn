package bpmn.app.service;

import bpmn.app.model.User;
import bpmn.app.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);


    private final AdminRepository adminRepository;


    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<User> userList = adminRepository.findAll(pageable);
        return userList;
    }

    @Override
    public User findUserById(int id) {
        User user = adminRepository.findUserById(id);
        return user;
    }

    @Override
    public void updateUser(int id, int nrRoli, int activity) {
        adminRepository.updateActivationUser(activity, id);
        adminRepository.updateRoleUser(nrRoli, id);
    }

    @Override
    public Page<User> findAllSearch(String param, Pageable pageable) {
        Page<User> userList = adminRepository.findAllSearch(param, pageable);
        return userList;
    }

    @Override
    public void deleteUserById(int id) {
        LOG.debug("[WYWOŁANIE >>> AdminServiceImpl.deleteUserById > PARAMETR: " + id);
        LOG.debug("[WYWOŁANIE >>> AdminRepository.deleteUserFromUserRole > PARAMETR: " + id);
        adminRepository.deleteUserFromUserRole(id);
        LOG.debug("[WYWOŁANIE >>> AdminRepository.deleteUserFromUser > PARAMETR: " + id);
        adminRepository.deleteUserFromUser(id);
    }

}
