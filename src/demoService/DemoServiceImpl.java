package demoService;

import data.Discipline;
import data.Group;
import data.Student;
import data.StudentProgress;
import marksCalculationService.MarksCalculationServiceImpl;

import java.util.HashMap;

public class DemoServiceImpl implements DemoService {

    @Override
    public void showDemo() {

        // Инициализируем массив студентов
        Student[] students;

        // Добавим группы
        data.Group group634_1 = new Group("634-1");
        data.Group group664 = new Group("664");

        // Добавим студентов:
        students = new Student[] {new Student("Азимов Айзек", group634_1),
                new Student("Тесла Никола", group634_1),
                new Student("Флинт Ларри", group634_1),
                new Student("Лисков Барбара", group634_1),

                new Student("Эйнштейн Альберт", group664),
                new Student("Маск Илон", group664),
                new Student("Леннон Джон", group664),
                new Student("Шпенглер Освальд", group664)};

        // Инициализируем массив дисциплин
        data.Discipline[] disciplines = new Discipline[] {new Discipline("Mathematics"),
                new Discipline("Physics"),
                new Discipline("English"),
                new Discipline("Literature"),
                new Discipline("Chemistry")};

        // Добавим оценки
        for (Student student : students) {
            StudentProgress studentProgress = new StudentProgress();
            HashMap<Discipline, Integer> marks = new HashMap<>();
            for (Discipline discipline:disciplines) {
                int mark = (int) (Math.random()*(4)) + 2;
                marks.put(discipline, mark);
            }
            studentProgress.setMarks(marks);
            student.setStudentProgress(studentProgress);
        }

        // Выведем полученные списки студентов:
        System.out.println("Список студентов:");
        for (Student student: students) {
            student.printStudent();
        }

        MarksCalculationServiceImpl marksCalculationServiceImpl = new MarksCalculationServiceImpl();

        System.out.println();
        System.out.println("Средний бал по группе: "+group634_1.getGroupCode()+": "+
                marksCalculationServiceImpl.averageMarkOfGroup(students, group634_1));
        System.out.println("Средний бал по группе: "+group664.getGroupCode()+": "+
                marksCalculationServiceImpl.averageMarkOfGroup(students, group664));
        System.out.println();

        System.out.println("Количество отличников: "+marksCalculationServiceImpl.quantityOfHonoursStudents(students));
        System.out.println();

        System.out.println("Количество студентов, имеющих 'неудовлетворительно': "+
                marksCalculationServiceImpl.quantityOfPoorStudents(students));
    }
}
