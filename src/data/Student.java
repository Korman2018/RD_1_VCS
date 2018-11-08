package data;

import marksCalculationService.MarksCalculationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Student {

    // Changes in Develop branch

    private String FIO;
    private Group group;
    private StudentProgress studentProgress;

    public Student(String FIO, Group group) {
        this.FIO = FIO;
        this.group = group;
    }

    public void setStudentProgress(StudentProgress studentProgress) {
        this.studentProgress = studentProgress;
    }

    public String getFIO() {
        return FIO;
    }

    public Group getGroup() {
        return group;
    }

    public StudentProgress getStudentProgress() {
        return studentProgress;
    }

    public void printStudent() {

        System.out.printf("%-6s %-30s", this.getGroup().getGroupCode(), this.getFIO());
        StudentProgress studentProgress = this.getStudentProgress();
        HashMap<Discipline, Integer> marks = studentProgress.getMarks();

        MarksCalculationServiceImpl marksCalculationServiceImpl = new MarksCalculationServiceImpl();

        for (Map.Entry<Discipline, Integer> entry : marks.entrySet()) {
            Discipline discipline = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("%-10s %-3d", discipline.getName()+":", value);
        }
        System.out.printf("      Средний балл: %.2f", marksCalculationServiceImpl.averageMarkOfStudent(this));
        //System.out.println();
        System.out.println();
        }

}
