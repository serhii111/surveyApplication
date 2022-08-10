package com.survey.surveyapplication.mapper;

import com.survey.surveyapplication.dto.QuestionDto;
import com.survey.surveyapplication.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionsMapper implements Mappable<Question, QuestionDto> {

    @Override
    public Question toEntity(QuestionDto questionDto) {
        if (questionDto == null) {
            return null;
        }
        Question question = new Question();
        question.setQuestionDescription(questionDto.getQuestionDescription());
        return question;
    }

    @Override
    public QuestionDto toDto(Question question) {
        if (question == null) {
            return null;
        }
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionDescription(question.getQuestionDescription());
        return questionDto;
    }
}
