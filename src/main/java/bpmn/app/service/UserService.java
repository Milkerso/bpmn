package bpmn.app.service;

import bpmn.app.model.User;

public interface UserService {

    User findUserByEmail(String email);

    void updateUserPassword(String newPassword, String email);

    void updateUserProfile(String newName, String newLastName, String newEmail, int id);

}
