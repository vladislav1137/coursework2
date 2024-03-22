package pro.skypro.coursework2.service.impl;

import org.springframework.stereotype.Service;
import pro.skypro.coursework2.Question;
import pro.skypro.coursework2.exceptions.IncorrectAmountException;
import pro.skypro.coursework2.service.ExaminerService;
import pro.skypro.coursework2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new IncorrectAmountException("Недостаточно вопросов в списке");
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
