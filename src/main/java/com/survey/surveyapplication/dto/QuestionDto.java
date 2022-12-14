package com.survey.surveyapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuestionDto {
    private String questionDescription;
    private Set<AnswerDto> answers;
}
