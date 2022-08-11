package com.survey.surveyapplication.mapper;

import com.survey.surveyapplication.dto.AnswerDto;
import com.survey.surveyapplication.model.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerMapper implements Mappable<Answer, AnswerDto> {

    @Override
    public Answer toEntity(AnswerDto answerDto) {
        if (answerDto == null) {
            return null;
        }
        Answer answer = new Answer();
        answer.setAnswerDescription(answerDto.getAnswerDescription());
        answer.setAnswered(answerDto.isAnswered());
        return answer;
    }

    @Override
    public AnswerDto toDto(Answer answer) {
        if (answer == null) {
            return null;
        }
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerDescription(answer.getAnswerDescription());
        answerDto.setAnswered(answer.isAnswered());
        return answerDto;
    }
}
