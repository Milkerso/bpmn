package bpmn.app.service;


import bpmn.app.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {

    Page<AppUser> findAll(Pageable pageable);

    AppUser findUserById(int id);

    void updateUser(int id, int nrRoli, int activity);

    Page<AppUser> findAllSearch(String param, Pageable pageable);

    void deleteUserById(int id);
}
