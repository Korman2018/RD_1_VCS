package marksCalculationService;

import data.Group;
import data.Student;

public interface MarksCalculationService {

    float averageMarkOfGroup(Student[] students, Group group);

    float averageMarkOfStudent(Student student);

    int quantityOfHonoursStudents(Student[] students);

    int quantityOfPoorStudents(Student[] students);

}
