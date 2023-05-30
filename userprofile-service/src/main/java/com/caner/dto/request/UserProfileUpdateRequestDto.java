package com.caner.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileUpdateRequestDto {

    private String token;
    private String username;
    private String email;
    private String phone;
    private String avatar;
    private String info;
    private String address;
}
