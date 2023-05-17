package com.example.military.service;

import com.example.military.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel user);
     List<UserModel> displayUsers();
     UserModel findUserbyarmynunber(UserModel user);
     UserModel updateuserbyarmynumber(UserModel user);
     void deleteuserbyarmynumber(UserModel user);
}
