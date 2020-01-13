package bpmn.app.service;

import bpmn.app.model.AppUser;

public interface UserService {

    AppUser findUserByEmail(String email);

    void updateUserPassword(String newPassword, String email);

//    void updateUserProfile(String newName, String newLastName, String newEmail, int id);

}
