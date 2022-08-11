package com.survey.surveyapplication.mapper;

import com.survey.surveyapplication.dto.AnswerDto;
import com.survey.surveyapplication.dto.QuestionDto;
import com.survey.surveyapplication.model.Answer;
import com.survey.surveyapplication.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuestionsMapper implements Mappable<Question, QuestionDto> {
    private final AnswerMapper answerMapper;

    @Override
    public Question toEntity(QuestionDto questionDto) {
        if (questionDto == null) {
            return null;
        }
        Question question = new Question();
        question.setQuestionDescription(questionDto.getQuestionDescription());
        if (questionDto.getAnswers() != null) {
            Set<Answer> answers = questionDto.getAnswers()
                    .stream()
                    .map(answerMapper::toEntity).collect(Collectors.toSet());
            question.setAnswers(answers);
        }
        return question;
    }

    @Override
    public QuestionDto toDto(Question question) {
        if (question == null) {
            return null;
        }
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionDescription(question.getQuestionDescription());
        Set<AnswerDto> answers = question.getAnswers()
                .stream()
                .filter(Objects::nonNull)
                .map(answerMapper::toDto).collect(Collectors.toSet());
        questionDto.setAnswers(answers);
        return questionDto;
    }
}
