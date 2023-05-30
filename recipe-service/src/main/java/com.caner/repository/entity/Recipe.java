package com.caner.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Recipe extends Base {
    @Id
    private String id;
    private String name;
    private String type;
    private int prepTime;
    private int cookingTime;
    private String recipeSteps;
    private String photo;
    private List<String> comments;
    private List<Ingradients> ingradients;

}
