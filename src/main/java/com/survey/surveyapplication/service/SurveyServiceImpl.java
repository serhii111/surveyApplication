package com.survey.surveyapplication.service;

import com.survey.surveyapplication.dto.SurveyDto;
import com.survey.surveyapplication.mapper.SurveyMapper;
import com.survey.surveyapplication.model.Survey;
import com.survey.surveyapplication.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;
    private final SurveyMapper surveyMapper;

    public Long createSurvey(SurveyDto surveyDto) {
        if (surveyDto.getSurveyName().isEmpty()) {
            throw new IllegalArgumentException("Survey name can not be empty");
        }
        var result = surveyRepository.saveAndFlush(surveyMapper.toEntity(surveyDto));
        return result.getId();
    }

    public SurveyDto getSurvey(Long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        return survey.map(surveyMapper::toDto).orElse(null);
    }

}
