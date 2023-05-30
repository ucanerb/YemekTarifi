package com.caner.dto;

import com.caner.repository.entity.Ingradients;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewRecipeRequestDto {
    private String recipeId;
    private String recipeName;
    private String name;
    private String type;
    private int prepTime;
    private int cookingTime;
    private String recipeSteps;
    private String photo;
    public String categoryId;
    public List<Ingradients> ingradients;

}
