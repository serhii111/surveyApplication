package com.survey.surveyapplication;

import com.survey.surveyapplication.dto.SurveyDto;
import com.survey.surveyapplication.mapper.SurveyMapper;
import com.survey.surveyapplication.model.Survey;
import com.survey.surveyapplication.repository.SurveyRepository;
import com.survey.surveyapplication.service.SurveyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SurveyServiceImplTest {
    private static final String SURVEY_NAME_CAN_NOT_BE_EMPTY = "Survey name can not be empty";
    private static final String WRONG_EXCEPTION_MESSAGE = "Wrong Exception message";
    private static final String IDS_ARE_NOT_EQUAL = "Id's are not equal";
    public static final long EXPECTED_ID = 1L;
    public static final String SURVEY_NAME = "Test";

    @InjectMocks
    private SurveyServiceImpl surveyService;
    @Mock
    private SurveyRepository surveyRepository;
    @Mock
    private SurveyMapper surveyMapper;

    @Test
    void when_SurveyNameIsNotEmpty_ThenProceed() {
        SurveyDto surveyDto = new SurveyDto();
        surveyDto.setSurveyName(SURVEY_NAME);
        when(surveyMapper.toEntity(surveyDto)).thenReturn(new Survey());

        Survey survey = new Survey();
        survey.setId(EXPECTED_ID);
        when(surveyRepository.saveAndFlush(new Survey())).thenReturn(survey);

        Long id = surveyService.createSurvey(surveyDto);
        Assertions.assertEquals(1L, id, IDS_ARE_NOT_EQUAL);
    }

    @Test
    void when_SurveyNameIsEmpty_ThenIsException() {
        SurveyDto surveyDto = new SurveyDto();
        surveyDto.setSurveyName("");

        var exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> surveyService.createSurvey(surveyDto));
        Assertions.assertEquals(SURVEY_NAME_CAN_NOT_BE_EMPTY, exception.getMessage(), WRONG_EXCEPTION_MESSAGE);
    }

}
