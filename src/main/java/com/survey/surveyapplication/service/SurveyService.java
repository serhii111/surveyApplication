package com.survey.surveyapplication.service;

import com.survey.surveyapplication.dto.SurveyDto;

public interface SurveyService {
    Long createSurvey(SurveyDto surveyDto);

    SurveyDto getSurvey(Long id);
}
