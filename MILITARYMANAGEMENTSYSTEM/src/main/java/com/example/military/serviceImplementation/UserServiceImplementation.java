package com.example.military.serviceImplementation;

import com.example.military.model.UserModel;
import com.example.military.repository.UserRepository;
import com.example.military.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
@Autowired
    UserRepository repo;
@Override

    public UserModel saveUser(UserModel user) {
        return repo.save(user);
    }

    @Override
    public List<UserModel> displayUsers() {
        return repo.findAll();
    }

    @Override
    public UserModel findUserbyarmynunber(UserModel user) {
        return repo.findById(user.getArmy_number()).orElse(null);
    }

    @Override
    public UserModel updateuserbyarmynumber(UserModel user) {
        UserModel savedUser =  repo.findById(user.getArmy_number()).orElse(null);
        if (savedUser!=null){
            savedUser.setUsername(user.getUsername());
            savedUser.setPassword(user.getPassword());
            return repo.save(savedUser);

        }else {
            return repo.save(user);
        }
    }

    @Override
    public void deleteuserbyarmynumber(UserModel user) {
     UserModel saveduser = repo.findById(user.getArmy_number()).orElse(null);
     if (saveduser!=null){
         repo.delete(saveduser);
     }
    }
}
