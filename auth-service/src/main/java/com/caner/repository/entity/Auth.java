package com.caner.repository.entity;

import com.caner.repository.enums.ERole;
import com.caner.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Auth extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String username;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ERole role = ERole.USER;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.PENDING;
    @ElementCollection
    private List<Address> addressList;
}