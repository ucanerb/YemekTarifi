package com.caner.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Category {
    @Id
    private String id;
    private String name;
}
