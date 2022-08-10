package com.survey.surveyapplication.mapper;


public interface Mappable<Entity, Dto> {

    Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

}
