package com.caner.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileResponseDto {
    private Long authId;
    private String userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String username;
    private String city;
    private String town;
    private String district;
    private String street;
    private String avatar;
}
