package marksCalculationService;

import data.Discipline;
import data.Group;
import data.Student;
import data.StudentProgress;

import java.util.Map;

public class MarksCalculationServiceImpl implements MarksCalculationService {

    @Override
    public float averageMarkOfGroup(Student[] students, Group group) {

        int sum = 0;
        int quantity = 0;

        for (Student student : students) {
            if (student.getGroup().equals(group)) {

                StudentProgress marks = student.getStudentProgress();
                for (Map.Entry<Discipline, Integer> entry : marks.getMarks().entrySet()) {
                    sum += entry.getValue();
                    quantity += 1;
                }
            }
        }
        if (quantity > 0) {
            return (float) sum/quantity;
        }
        else {
            return 0;
        }
    }

    @Override
    public float averageMarkOfStudent(Student student) {

        int sum = 0;
        int quantity = 0;

        StudentProgress marks = student.getStudentProgress();
        for (Map.Entry<Discipline, Integer> entry : marks.getMarks().entrySet()) {
            sum += entry.getValue();
            quantity++;
        }

        if (quantity > 0) {
            return (float) sum/quantity;
        }
        else {
            return 0;
        }
    }

    @Override
    public int quantityOfHonoursStudents(Student[] students) {

        int quantity = 0;

        for (Student student : students) {
            StudentProgress marks = student.getStudentProgress();
            boolean isExcellent = true;
            for (Map.Entry<Discipline, Integer> entry : marks.getMarks().entrySet()) {
                if (entry.getValue() != 5) {
                    isExcellent = false;
                    break;
                }
            }
            if (isExcellent) {
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public int quantityOfPoorStudents(Student[] students) {
        int quantity = 0;

        for (Student student : students) {
            StudentProgress marks = student.getStudentProgress();
            for (Map.Entry<Discipline, Integer> entry : marks.getMarks().entrySet()) {
                if (entry.getValue() == 2) {
                    quantity++;
                    break;
                }
            }
        }
        return quantity;
    }
}
