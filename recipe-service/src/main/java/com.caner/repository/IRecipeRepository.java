package com.caner.repository;

import com.caner.repository.entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecipeRepository extends MongoRepository<Recipe, String> {


}
