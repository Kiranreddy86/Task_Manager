package com.Project.Task_Manager.Service;

import DTO.UserRequest;
import com.Project.Task_Manager.Entity.UserEntity;
import com.Project.Task_Manager.Repository.RoleRepository;
import com.Project.Task_Manager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    public void register(UserEntity userEntity){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String bCrypt = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(bCrypt);
        userRepository.save(userEntity);
    }
}
