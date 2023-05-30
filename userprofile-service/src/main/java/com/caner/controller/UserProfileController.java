package com.caner.controller;

import com.caner.dto.request.NewCreateUserRequestDto;
import com.caner.dto.request.PasswordChangeDto;
import com.caner.dto.request.UserProfileUpdateRequestDto;
import com.caner.dto.response.UserProfileResponseDto;
import com.caner.repository.entity.UserProfile;
import com.caner.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.caner.constant.ApiUrls.*;

@RestController
@RequestMapping(USER_PROFILE)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createUser(@RequestBody NewCreateUserRequestDto dto){
        return ResponseEntity.ok(userProfileService.createUser(dto));
    }
    @PutMapping(UPDATE)
    public ResponseEntity<UserProfile> update(@RequestBody UserProfileUpdateRequestDto dto){
        return ResponseEntity.ok(userProfileService.update(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }
    @GetMapping(FIND_BY_USERNAME)
    public ResponseEntity<UserProfileResponseDto> findOptionalByUsernameIgnoreCase(String username){
        return ResponseEntity.ok(userProfileService.findOptionalByUsernameIgnoreCase(username));
    }

    @DeleteMapping ("/delete-by-id/{authId}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable Long authId){
        return ResponseEntity.ok(userProfileService.deleteUserById(authId));
    }
    @PutMapping(PASS_CHANGE)
    public ResponseEntity<Boolean> passwordChange(PasswordChangeDto dto){
        return ResponseEntity.ok(userProfileService.passwordChange(dto));
    }
    @GetMapping("/find-by-userprofile-dto/{authId}")
    public ResponseEntity<UserProfileResponseDto> findByUserProfileDto(@PathVariable Long authId){
        return ResponseEntity.ok(userProfileService.findByUserProfileDto(authId));
    }

}
