package com.caner.service;

import com.caner.dto.CreateNewRecipeRequestDto;
import com.caner.exception.ErrorType;
import com.caner.exception.RecipeManagerException;
import com.caner.repository.IRecipeRepository;
import com.caner.repository.entity.Recipe;
import com.caner.utility.JwtTokenProvider;
import com.caner.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService extends ServiceManager<Recipe, String> {

    private final IRecipeRepository recipeRepository;

    private final JwtTokenProvider jwtTokenProvider;

    /*
    public RecipeService(IRecipeRepository repository,JwtTokenProvider jwtTokenProvider){
        super(repository);
        this.recipeRepository=repository;
        this.jwtTokenProvider=jwtTokenProvider;
    }

    public Recipe createRecipe(String token, CreateNewRecipeRequestDto dto){
        Optional<Long> authId = jwtTokenProvider.getIdFromToken(token);
        if (authId.isEmpty()){
            throw new RecipeManagerException(ErrorType.INVALID_TOKEN);
        }


    }

     */


}
