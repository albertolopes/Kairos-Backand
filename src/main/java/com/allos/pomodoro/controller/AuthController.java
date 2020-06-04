package com.allos.pomodoro.controller;

import com.allos.pomodoro.security.JWTUtil;
import com.allos.pomodoro.security.UserSecurity;
import com.allos.pomodoro.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response){
        UserSecurity userSecurity = UserSecurityService.authenticate();
        response.addHeader("Authorization", "Bearer " + jwtUtil.generateToken(userSecurity.getUsername()));
        return ResponseEntity.noContent().build();
    }
}
