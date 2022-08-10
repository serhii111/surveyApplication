package com.survey.surveyapplication.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SurveyDto {
    private String surveyName;
    private Set<QuestionDto> questions = new HashSet<>();
}
