package pro.skypro.coursework2.service;

import pro.skypro.coursework2.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
