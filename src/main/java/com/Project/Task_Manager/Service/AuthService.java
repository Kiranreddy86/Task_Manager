package com.Project.Task_Manager.Service;

import DTO.JwtRequest;
import DTO.JwtResponse;
import com.Project.Task_Manager.JWT.JwtAuthencationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager manager;
    @Autowired
    JwtAuthencationHelper jwtAuthencationHelper;
    @Autowired
    UserDetailsService userDetailsService;
    public JwtResponse login(JwtRequest jwtRequest) throws Exception {
        this.doAuthenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        UserDetails userDetails= userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token=jwtAuthencationHelper.generateToken(userDetails);
        JwtResponse response=JwtResponse.builder().jwtToken(token).build();
        return response;
    }

    private void doAuthenticate(String username, String password) throws Exception {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username,password);
        try{
            manager.authenticate(usernamePasswordAuthenticationToken);
        }catch (Exception e){
            throw new Exception("bad credentials");
        }

    }
}
