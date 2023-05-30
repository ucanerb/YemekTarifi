package com.caner.mapper;

import com.caner.dto.CreateNewRecipeRequestDto;
import com.caner.repository.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRecipeMapper {
    IRecipeMapper INSTANCE = Mappers.getMapper(IRecipeMapper.class);

    Recipe fromCreateNewRecipeRequestDtoToRecipe (final CreateNewRecipeRequestDto dto);




}
