package pro.skypro.coursework2.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.skypro.coursework2.Question;
import pro.skypro.coursework2.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Random random = new Random();
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        add("что такое геттер?", "метод, который возвращает значение переменной");
        add("что такое инкапсуляция?", "концепция, согласно которой мы не даем доступ к свойствам объекта, а получаем их значения через методы");
        add("что такое итерация?", "очередной проход цикла.");
        add("Какие модификаторы доступа есть в Java?", "public, default (package), protected, private");
    }
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
       int randomIndex = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIndex);
    }
}
