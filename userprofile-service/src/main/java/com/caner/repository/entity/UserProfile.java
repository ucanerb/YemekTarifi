package com.caner.repository.entity;

import com.caner.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Document
public class UserProfile  {
    @Id
    private String id;
    private Long authId;
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
    @Builder.Default
    private EStatus status = EStatus.PENDING;

}
