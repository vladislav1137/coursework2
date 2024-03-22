package pro.skypro.coursework2.service;

import pro.skypro.coursework2.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll ();
    Question getRandomQuestion();

}
