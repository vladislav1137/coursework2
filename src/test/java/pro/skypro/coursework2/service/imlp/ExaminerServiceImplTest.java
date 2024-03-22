package pro.skypro.coursework2.service.imlp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skypro.coursework2.Question;
import pro.skypro.coursework2.exceptions.IncorrectAmountException;
import pro.skypro.coursework2.service.impl.ExaminerServiceImpl;
import pro.skypro.coursework2.service.impl.JavaQuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncorrectAmountExceptionWhenThereIsNotEnoughQuestions() {
        int amount = 10;

        when(javaQuestionService.getAll()).thenReturn(List.of());

        Assertions.assertThrows(IncorrectAmountException.class,() -> examinerService.getQuestions(amount));
    }

    @Test
    public void shouldCorrectlyGetQuestions() {
        int amount = 3;
        List<Question> questions = List.of(
               new Question("question1", "answer1"),
               new Question("question2", "answer2"),
               new Question("question3", "answer3"),
               new Question("question4", "answer4"),
               new Question("question5", "answer5")
        );
        when(javaQuestionService.getAll()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(1),
                questions.get(0),
                questions.get(1),
                questions.get(2)
        );
        Collection<Question> actualQuestions = examinerService.getQuestions(amount);
        Assertions.assertEquals(Set.of(
                questions.get(0), questions.get(1), questions.get(2)), actualQuestions);
        verify(javaQuestionService, times(6)).getRandomQuestion();
    }
}
