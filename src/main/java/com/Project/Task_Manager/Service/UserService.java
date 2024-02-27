package com.Project.Task_Manager.Service;

import DTO.UserRequest;
import com.Project.Task_Manager.Entity.UserEntity;
import com.Project.Task_Manager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void register(UserRequest userRequest){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String bCrypt = passwordEncoder.encode(userRequest.getPassword());
        UserEntity user=new UserEntity();
        user.setUsername(userRequest.getUsername());
        user.setPassword(bCrypt);
        userRepository.save(user);
    }
}
