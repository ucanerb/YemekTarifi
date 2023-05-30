package com.caner.repository.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {
    @Id
    private String id;
    private String street;
    private String district;
    private String town;
    private String city;
    private String country;
    private String apartmentNumber;
    private int doorNumber;
    private int postalCode;
}
