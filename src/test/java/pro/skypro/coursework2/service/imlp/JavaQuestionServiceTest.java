package pro.skypro.coursework2.service.imlp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.skypro.coursework2.Question;
import pro.skypro.coursework2.service.QuestionService;
import pro.skypro.coursework2.service.impl.JavaQuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private final JavaQuestionService questionService = new JavaQuestionService();

    @Test
    public void shouldCorrectlyAddQuestion() {
        Question question= new Question("a", "b");
        Question addedQuestion = questionService.add(question);
        assertEquals(question,addedQuestion);
    }

    @Test
    public void shouldCorrectlyRemoveQuestion() {
        Question question = new Question("a", "b");
        Question removedQuestion = questionService.remove(question);
        assertEquals(question,removedQuestion);
    }

    @Test
    public void shouldCorrectlyGetAll() {
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        questionService.add(question1);
        questionService.add(question2);
        Collection<Question> actualQuestions = questionService.getAll();
        assertIterableEquals(List.of(question1,question2),actualQuestions);
    }

    @Test
    public void shouldCorrectlyGetRandomQuestion() {
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        questionService.add(question1);
        questionService.add(question2);
        Question randomQuestion = questionService.getRandomQuestion();
        assertTrue(Set.of(question1,question2).contains(randomQuestion));
    }
}
