package com.survey.surveyapplication.controller;


import com.survey.surveyapplication.dto.SurveyDto;
import com.survey.surveyapplication.service.SurveyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/surveys")
public class SurveyController {
    private final SurveyServiceImpl surveyService;

    @PostMapping
    public Long createSurvey(@RequestBody SurveyDto surveyDto) {

        return surveyService.createSurvey(surveyDto);
    }

    @GetMapping("/{id}")
    public SurveyDto getSurvey(@PathVariable Long id) {
        return surveyService.getSurvey(id);
    }
}
