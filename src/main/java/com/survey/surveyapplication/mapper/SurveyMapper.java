package com.survey.surveyapplication.mapper;

import com.survey.surveyapplication.dto.QuestionDto;
import com.survey.surveyapplication.dto.SurveyDto;
import com.survey.surveyapplication.model.Question;
import com.survey.surveyapplication.model.Survey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SurveyMapper implements Mappable<Survey, SurveyDto> {
    private final QuestionsMapper questionsMapper;

    @Override
    public Survey toEntity(SurveyDto surveyDto) {
        if (surveyDto == null) {
            return null;
        }
        Survey survey = new Survey();
        survey.setSurveyName(surveyDto.getSurveyName());
        Set<Question> questions = getQuestions(surveyDto);
        survey.setQuestions(questions);
        return survey;
    }

    private Set<Question> getQuestions(SurveyDto surveyDto) {
        return surveyDto.getQuestions().stream()
                .map(questionsMapper::toEntity).collect(Collectors.toSet());
    }

    @Override
    public SurveyDto toDto(Survey survey) {
        if (survey == null) {
            return null;
        }
        SurveyDto surveyDto = new SurveyDto();
        surveyDto.setSurveyName(survey.getSurveyName());
        Set<QuestionDto> questionDtos = getQuestionDtos(survey);
        surveyDto.setQuestions(questionDtos);
        return surveyDto;
    }

    private Set<QuestionDto> getQuestionDtos(Survey survey) {
        return survey.getQuestions().stream()
                .map(questionsMapper::toDto).collect(Collectors.toSet());
    }
}
