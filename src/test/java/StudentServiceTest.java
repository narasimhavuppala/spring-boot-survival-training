import com.example.springtrainingdemo.model.Student;
import com.example.springtrainingdemo.repo.StudentRepository;
import com.example.springtrainingdemo.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService=new StudentService();

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void handleTest(){
        Student student = new Student();
        student.setId(1);
        student.setName("sampel");
        Mockito.when(studentRepository.findAll()).thenReturn(List.of(student));
        List<Student>  studentsList= studentService.getStudents();
        Assertions.assertTrue(1==studentsList.size());
    }
}
