package com.caner.controller;

import com.caner.dto.request.LoginRequestDto;
import com.caner.dto.request.RegisterRequestDto;
import com.caner.dto.request.UpdateEmailOrUsernameRequestDto;
import com.caner.dto.response.RegisterResponseDto;
import com.caner.repository.entity.Auth;
import com.caner.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.caner.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {

    private final AuthService authService;
    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){
        return ResponseEntity.ok(authService.register(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }
    @PutMapping("/update-username-email")
    public ResponseEntity<Boolean> update(@RequestBody UpdateEmailOrUsernameRequestDto dto){
        return ResponseEntity.ok(authService.update(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Auth>> findAll (){
        return ResponseEntity.ok(authService.findAll());
    }

}
