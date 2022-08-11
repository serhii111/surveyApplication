package com.survey.surveyapplication;

import com.survey.surveyapplication.dto.AnswerDto;
import com.survey.surveyapplication.dto.QuestionDto;
import com.survey.surveyapplication.dto.SurveyDto;
import com.survey.surveyapplication.service.SurveyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Collections;

@SpringBootTest
class SurveyApplicationITest {
	@Autowired
	SurveyService surveyService;

	@Test
	void should_ReturnSurvey_When_SurveyCreated() {
		Long id = surveyService.createSurvey(prepareTestData());
		SurveyDto actualSurvey = surveyService.getSurvey(id);

		Assertions.assertEquals(prepareTestData(), actualSurvey);
	}

	SurveyDto prepareTestData() {
		SurveyDto surveyDto = new SurveyDto();
		surveyDto.setSurveyName("Test Survey");

		QuestionDto questionDto = new QuestionDto();
		questionDto.setQuestionDescription("Test Question");

		AnswerDto answerDto = new AnswerDto();
		answerDto.setAnswerDescription("Test Answer");
		answerDto.setAnswered(true);

		questionDto.setAnswers(Collections.singleton(answerDto));

		surveyDto.setQuestions(Collections.singleton(questionDto));
		return surveyDto;
	}

}
